import {Injectable} from "@angular/core";
import {Actions, createEffect, ofType} from "@ngrx/effects";
import {NewsWorkerService} from "../../services/news-worker.service";
import {Store} from "@ngrx/store";
import {AppState} from "../state/app.state";
import {Router} from "@angular/router";
import {go} from "../actions/router.actions";
import {map, pipe, tap} from "rxjs";

@Injectable()
export class RouterEffects
{

  navigate$ = createEffect(
    () =>
    {
      return this.actions$.pipe(
        ofType(go),
        tap((action) =>
        {
          this.router.navigateByUrl(action.url);
        })
      )
    },
    {dispatch: false}
  )

  constructor(
    private actions$: Actions,
    private store: Store<AppState>,
    private router: Router,
  )
  {
  }
}
