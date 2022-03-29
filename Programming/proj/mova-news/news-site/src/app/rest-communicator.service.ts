import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {IPagedTitles} from "./entities/response/IPagedTitles";
import {IArticle} from "./entities/IArticle";

@Injectable({
  providedIn: 'root'
})
export class RestCommunicatorService
{
  private serviceUrl = 'http://localhost:8080/'

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(
    private http: HttpClient,
  )
  {
  }

  getPagedTitles(): Observable<IPagedTitles>
  {
    return this.http.get<IPagedTitles>(this.serviceUrl + 'titles')
  }

  getNews(id: string): Observable<IArticle>
  {
    return this.http.get<IArticle>(this.serviceUrl + 'titles/' + id + '/article')
  }

  getPagedTitlesFromLink(link: string): Observable<IPagedTitles>
  {
    return this.http.get<IPagedTitles>(link)
  }

  postArticle(article: IArticle): Observable<IArticle>
  {
    return this.http.post<IArticle>(this.serviceUrl + 'titles/', article);
  }

}
