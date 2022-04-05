import { Injectable } from '@angular/core';
import { map, Observable, switchMap, tap } from 'rxjs';
import { PagedStories } from '../models/response/PagedStories';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { StoryEntity } from '../models/story.entity';

@Injectable({
  providedIn: 'root',
})
export class StoryWorkerService {
  private restUrl: string = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  getPagedStories(url: string): Observable<PagedStories> {
    return this.http.get<PagedStories>(url);
  }

  getStory(id: string): Observable<StoryEntity> {
    return this.http.get<StoryEntity>(`${this.restUrl}/titles/${id}`);
  }

  getArticle(id: string): Observable<StoryEntity> {
    return this.http.get<StoryEntity>(`${this.restUrl}/titles/${id}/article`);
  }

  postStory(story: StoryEntity): Observable<StoryEntity> {
    console.log(story);
    return this.http.post<StoryEntity>(`${this.restUrl}/titles/`, story).pipe(
      tap((a) => console.log(a)),
      switchMap((titled: StoryEntity) =>
        this.http
          .post<StoryEntity>(
            `${this.restUrl}/titles/${titled.id}/article`,
            story
          )
          .pipe(
            map(
              (articled: StoryEntity) =>
                ({
                  ...articled,
                  ...titled,
                } as StoryEntity)
            ),
            tap((story: StoryEntity) => console.log(story))
          )
      )
    );
  }

  patchStory(story: StoryEntity): Observable<StoryEntity> {
    return this.http
      .patch<StoryEntity>(`${this.restUrl}/titles/${story.id}`, story)
      .pipe(
        switchMap((titled: StoryEntity) =>
          this.http
            .patch<StoryEntity>(
              `${this.restUrl}/titles/${story.id}/article`,
              story
            )
            .pipe(map((articled: StoryEntity) => ({ ...titled, ...articled })))
        )
      );
  }

  deleteStory(id: string): Observable<HttpResponse<Object>> {
    return this.http.delete(`${this.restUrl}/titles/${id}`, {
      observe: 'response',
    });
  }
}
