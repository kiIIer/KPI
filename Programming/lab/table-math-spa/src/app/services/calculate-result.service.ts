import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http';
import {CalculateRequestModel} from '../models/calculateRequest.model';
import {Observable, tap} from 'rxjs';
import {DimensionModel} from '../models/dimension.model';

@Injectable({
  providedIn: 'root',
})
export class CalculateResultService
{

  restUrl: string = 'http://localhost:8080';

  constructor(private http: HttpClient)
  {
  }

  getTable(request: CalculateRequestModel): Observable<HttpResponse<DimensionModel>>
  {
    return this.http.post<DimensionModel>(`${this.restUrl}/hypercube`, request, {observe: 'response'}).pipe(
      tap((r) => console.log(r)),
    );
  }
}
