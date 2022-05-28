import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { AppState } from '../state/app.state';
import { Store } from '@ngrx/store';
import { errorNotFound } from '../actions/errors.actions';
import { map } from 'rxjs';
import { go } from '../actions/router.actions';

@Injectable()
export class ErrorsEffects {
  errorNotFound$ = createEffect(() => {
    return this.actions$.pipe(
      ofType(errorNotFound),
      map((errorNotFound) => go({ url: '/not-found' }))
    );
  });

  constructor(private actions$: Actions, private store: Store<AppState>) {}
}
