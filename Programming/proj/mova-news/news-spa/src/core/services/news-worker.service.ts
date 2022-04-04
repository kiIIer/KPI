import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {PagedStories} from "../models/response/PagedStories";
import {HttpClient} from "@angular/common/http";
import {StoryEntity} from "../models/story.entity";

@Injectable({
  providedIn: 'root'
})
export class NewsWorkerService
{
  private restUrl: string = 'http://localhost:8080'

  constructor(private http: HttpClient)
  {
  }

  getPagedStories(url: string): Observable<PagedStories>
  {
    return this.http.get<PagedStories>(url);
  }

  getStory(id: string): Observable<StoryEntity>
  {
    return this.http.get<StoryEntity>(`${this.restUrl}/titles/${id}`);
  }

  getArticle(id: string): Observable<StoryEntity>
  {
    return this.http.get<StoryEntity>(`${this.restUrl}/titles/${id}/article`);
  }
}
