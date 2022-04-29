import {Injectable} from "@angular/core";
import {AppState} from "../state/app.state";
import {Store} from "@ngrx/store";
import {Actions, createEffect, ofType} from "@ngrx/effects";
import {CalculateResultService} from "../../services/calculate-result.service";
import {loadResult, loadResultFail, loadResultSuccesses} from "../actions/table.actions";
import {asyncScheduler, catchError, map, mergeMap, scheduled} from "rxjs";
import {HttpErrorResponse, HttpResponse} from "@angular/common/http";
import {DimensionModel} from "../../models/dimension.model";
import {ErrorModel} from "../../models/Error.model";

@Injectable()
export class TableEffects
{
  loadTable$ = createEffect(() => this.actions$.pipe(
      ofType(loadResult),
      mergeMap((action) => this.service$.getTable(action.request).pipe(
          map(
            (response: HttpResponse<DimensionModel>) => loadResultSuccesses({dimension: response.body!}),
          ),
          catchError((error: HttpErrorResponse) =>
          {
            return scheduled([loadResultFail({error: error.error as ErrorModel})], asyncScheduler)
          })
        )
      )
    )
  )

  constructor(
    private store: Store<AppState>,
    private actions$: Actions,
    private service$: CalculateResultService
  )
  {
  }

}
