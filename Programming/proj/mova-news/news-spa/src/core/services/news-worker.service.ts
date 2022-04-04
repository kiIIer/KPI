import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {PagedStories} from "../entities/response/PagedStories";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class NewsWorkerService
{
  constructor(private http: HttpClient)
  {
  }

  getPagedNews(url: string): Observable<PagedStories>
  {
    return this.http.get<PagedStories>(url);
  }
}
