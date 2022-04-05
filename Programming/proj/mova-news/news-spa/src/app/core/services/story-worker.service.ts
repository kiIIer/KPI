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

  getStory(id: string): Observable<HttpResponse<StoryEntity>> {
    return this.http.get<StoryEntity>(`${this.restUrl}/titles/${id}`, {
      observe: 'response',
    });
  }

  getArticle(id: string): Observable<HttpResponse<StoryEntity>> {
    return this.http.get<StoryEntity>(`${this.restUrl}/titles/${id}/article`, {
      observe: 'response',
    });
  }

  postTitle(story: StoryEntity): Observable<HttpResponse<StoryEntity>> {
    return this.http.post<StoryEntity>(`${this.restUrl}/titles/`, story, {
      observe: 'response',
    });
  }

  postArticle(story: StoryEntity): Observable<HttpResponse<StoryEntity>> {
    return this.http.post<StoryEntity>(
      `${this.restUrl}/titles/${story.id}/article`,
      story,
      {
        observe: 'response',
      }
    );
  }

  postStory(story: StoryEntity): Observable<HttpResponse<StoryEntity>> {
    return this.http
      .post<StoryEntity>(`${this.restUrl}/titles/`, story, {
        observe: 'response',
      })
      .pipe(
        switchMap((titleResponse: HttpResponse<StoryEntity>) =>
          titleResponse.status == 201
            ? this.http
                .post<StoryEntity>(
                  `${this.restUrl}/titles/${titleResponse.body!.id}/article`,
                  story,
                  { observe: 'response' }
                )
                .pipe(
                  map((articleResponse: HttpResponse<StoryEntity>) =>
                    articleResponse.status == 201
                      ? ({
                          ...titleResponse,
                          ...articleResponse,
                          body: {
                            ...titleResponse.body,
                            ...articleResponse.body,
                          },
                        } as HttpResponse<StoryEntity>)
                      : articleResponse
                  )
                )
            : scheduled([titleResponse], asyncScheduler)
        )
      );
  }

  patchTitle(story: StoryEntity): Observable<HttpResponse<StoryEntity>> {
    return this.http.patch<StoryEntity>(
      `${this.restUrl}/titles/${story.id}`,
      story,
      {
        observe: 'response',
      }
    );
  }

  patchArticle(story: StoryEntity): Observable<HttpResponse<StoryEntity>> {
    return this.http.patch<StoryEntity>(
      `${this.restUrl}/titles/${story.id}/article`,
      story,
      {
        observe: 'response',
      }
    );
  }

  patchStory(story: StoryEntity): Observable<HttpResponse<StoryEntity>> {
    return this.http
      .patch<StoryEntity>(`${this.restUrl}/titles/${story.id}`, story, {
        observe: 'response',
      })
      .pipe(
        switchMap((titleResponse: HttpResponse<StoryEntity>) =>
          titleResponse.status == 200
            ? this.http
                .patch<StoryEntity>(
                  `${this.restUrl}/titles/${story.id}/article`,
                  story,
                  { observe: 'response' }
                )
                .pipe(
                  map((articleResponse: HttpResponse<StoryEntity>) =>
                    articleResponse.status == 200
                      ? ({
                          ...titleResponse,
                          ...articleResponse,
                          body: {
                            ...titleResponse.body,
                            ...articleResponse.body,
                          },
                        } as HttpResponse<StoryEntity>)
                      : articleResponse
                  )
                )
            : scheduled([titleResponse], asyncScheduler)
        )
      );
  }

  deleteStory(id: string): Observable<HttpResponse<Object>> {
    return this.http.delete(`${this.restUrl}/titles/${id}`, {
      observe: 'response',
    });
  }
}
