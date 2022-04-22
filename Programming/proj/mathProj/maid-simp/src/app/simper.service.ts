import {Injectable} from '@angular/core';
import {Observable, of} from "rxjs";
import {Formula} from "./Entities/response/Formula";
import {RequestEntity} from "./Entities/requests/RequestEntity";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Result} from "./Entities/response/Result";

@Injectable({
  providedIn: 'root'
})
export class SimperService
{
  private formulasUrl = 'http://localhost:8080/formulas'

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(
    private http: HttpClient
  )
  {
  }

  getFormulas(): Observable<Formula[]>
  {
    return this.http.get<Formula[]>(this.formulasUrl);
  }

  postRequest(request: RequestEntity, id: number): Observable<Result>
  {
    return this.http.post<Result>(this.formulasUrl + "/" + id, request, this.httpOptions);
  }
}
