import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { StoryWorkerService } from '../../services/story-worker.service';
import { Store } from '@ngrx/store';
import { AppState } from '../state/app.state';
import { Router } from '@angular/router';
import { go, goWithExtras } from '../actions/router.actions';
import { map, pipe, tap } from 'rxjs';

@Injectable()
export class RouterEffects {
  navigate$ = createEffect(
    () => {
      return this.actions$.pipe(
        ofType(go),
        tap((action) => {
          this.router.navigateByUrl(action.url);
        })
      );
    },
    { dispatch: false }
  );

  navigateWithExtras$ = createEffect(
    () => {
      return this.actions$.pipe(
        ofType(goWithExtras),
        tap((action) => {
          this.router.navigate([action.url], action.extras);
        })
      );
    },
    { dispatch: false }
  );

  constructor(
    private actions$: Actions,
    private store: Store<AppState>,
    private router: Router
  ) {}
}
