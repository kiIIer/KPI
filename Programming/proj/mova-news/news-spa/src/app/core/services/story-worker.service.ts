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
import {
  HttpClient,
  HttpHeaders,
  HttpParams,
  HttpResponse,
} from '@angular/common/http';
import { StoryEntity } from '../models/story.entity';

@Injectable({
  providedIn: 'root',
})
export class StoryWorkerService {
  private restUrl: string = 'http://localhost:8080';
  private headers: HttpHeaders = new HttpHeaders({
    Accept: 'application/json',
  });

  constructor(private http: HttpClient) {}

  getPagedStories(url: string): Observable<HttpResponse<PagedStories>> {
    return this.http.get<PagedStories>(url, {
      observe: 'response',
      headers: this.headers,
    });
  }

  searchStories(
    url: string,
    q: string
  ): Observable<HttpResponse<PagedStories>> {
    if (!!url) {
      return this.getPagedStories(url);
    }
    let params = new HttpParams().set('q', q);

    return this.http.get<PagedStories>(this.restUrl + '/titles', {
      observe: 'response',
      params: params,
      headers: this.headers,
    });
  }

  getTitle(id: string): Observable<HttpResponse<StoryEntity>> {
    return this.http
      .get<StoryEntity>(`${this.restUrl}/titles/${id}`, {
        observe: 'response',
        headers: this.headers,
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
      headers: this.headers,
    });
  }

  postTitle(story: StoryEntity): Observable<HttpResponse<StoryEntity>> {
    return this.http
      .post<StoryEntity>(`${this.restUrl}/titles/`, story, {
        observe: 'response',
        headers: this.headers,
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
        headers: this.headers,
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
        headers: this.headers,
      })
      .pipe(
        switchMap((titleResponse: HttpResponse<StoryEntity>) =>
          this.http
            .post<StoryEntity>(
              `${this.restUrl}/titles/${titleResponse.body!.id}/article`,
              story,
              { observe: 'response', headers: this.headers }
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
        headers: this.headers,
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
        headers: this.headers,
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
        headers: this.headers,
      })
      .pipe(
        switchMap((titleResponse: HttpResponse<StoryEntity>) =>
          this.http
            .patch<StoryEntity>(
              `${this.restUrl}/titles/${story.id}/article`,
              story,
              { observe: 'response', headers: this.headers }
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
        headers: this.headers,
      })
      .pipe(
        catchError((err, source) => {
          return scheduled([err], asyncScheduler);
        })
      );
  }
}
