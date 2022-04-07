import { Injectable } from '@angular/core';
import {
  asyncScheduler,
  catchError,
  map,
  Observable,
  scheduled,
  switchMap,
  tap,
  throwError,
} from 'rxjs';
import { PagedStories } from '../models/response/PagedStories';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { StoryEntity } from '../models/story.entity';

@Injectable({
  providedIn: 'root',
})
export class StoryWorkerService {
  private restUrl: string = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  getPagedStories(url: string): Observable<HttpResponse<PagedStories>> {
    return this.http.get<PagedStories>(url, { observe: 'response' });
  }

  getTitle(id: string): Observable<HttpResponse<StoryEntity>> {
    return this.http
      .get<StoryEntity>(`${this.restUrl}/titles/${id}`, {
        observe: 'response',
      })
      .pipe(
        catchError((err, source) => {
          return scheduled([err], asyncScheduler);
        })
      );
  }

  getArticle(id: string): Observable<HttpResponse<StoryEntity>> {
    return this.http.get<StoryEntity>(`${this.restUrl}/titles/${id}/article`, {
      observe: 'response',
    });
  }

  postTitle(story: StoryEntity): Observable<HttpResponse<StoryEntity>> {
    return this.http
      .post<StoryEntity>(`${this.restUrl}/titles/`, story, {
        observe: 'response',
      })
      .pipe(
        catchError((err, source) => {
          return scheduled([err], asyncScheduler);
        })
      );
  }

  postArticle(story: StoryEntity): Observable<HttpResponse<StoryEntity>> {
    return this.http
      .post<StoryEntity>(`${this.restUrl}/titles/${story.id}/article`, story, {
        observe: 'response',
      })
      .pipe(
        catchError((err, source) => {
          return scheduled([err], asyncScheduler);
        })
      );
  }

  postStory(story: StoryEntity): Observable<HttpResponse<StoryEntity>> {
    return this.http
      .post<StoryEntity>(`${this.restUrl}/titles/`, story, {
        observe: 'response',
      })
      .pipe(
        switchMap((titleResponse: HttpResponse<StoryEntity>) =>
          this.http
            .post<StoryEntity>(
              `${this.restUrl}/titles/${titleResponse.body!.id}/article`,
              story,
              { observe: 'response' }
            )
            .pipe(
              map(
                (articleResponse: HttpResponse<StoryEntity>) =>
                  ({
                    ...titleResponse,
                    ...articleResponse,
                    body: {
                      ...titleResponse.body,
                      ...articleResponse.body,
                    },
                  } as HttpResponse<StoryEntity>)
              )
            )
        )
      );
  }

  patchTitle(story: StoryEntity): Observable<HttpResponse<StoryEntity>> {
    return this.http
      .patch<StoryEntity>(`${this.restUrl}/titles/${story.id}`, story, {
        observe: 'response',
      })
      .pipe(
        catchError((err, source) => {
          return scheduled([err], asyncScheduler);
        })
      );
  }

  patchArticle(story: StoryEntity): Observable<HttpResponse<StoryEntity>> {
    return this.http
      .patch<StoryEntity>(`${this.restUrl}/titles/${story.id}/article`, story, {
        observe: 'response',
      })
      .pipe(
        catchError((err, source) => {
          return scheduled([err], asyncScheduler);
        })
      );
  }

  patchStory(story: StoryEntity): Observable<HttpResponse<StoryEntity>> {
    return this.http
      .patch<StoryEntity>(`${this.restUrl}/titles/${story.id}`, story, {
        observe: 'response',
      })
      .pipe(
        switchMap((titleResponse: HttpResponse<StoryEntity>) =>
          this.http
            .patch<StoryEntity>(
              `${this.restUrl}/titles/${story.id}/article`,
              story,
              { observe: 'response' }
            )
            .pipe(
              map(
                (articleResponse: HttpResponse<StoryEntity>) =>
                  ({
                    ...titleResponse,
                    ...articleResponse,
                    body: {
                      ...titleResponse.body,
                      ...articleResponse.body,
                    },
                  } as HttpResponse<StoryEntity>)
              ),
              catchError((err, source) => {
                return scheduled([err], asyncScheduler);
              })
            )
        ),
        catchError((err, source) => {
          return scheduled([err], asyncScheduler);
        })
      );
  }

  deleteStory(id: string): Observable<HttpResponse<Object>> {
    return this.http
      .delete(`${this.restUrl}/titles/${id}`, {
        observe: 'response',
      })
      .pipe(
        catchError((err, source) => {
          return scheduled([err], asyncScheduler);
        })
      );
  }
}
