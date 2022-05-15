import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { AuthenticationService } from '../../services/authentication.service';
import {
  asyncScheduler,
  combineLatest,
  of,
  scheduled,
  switchMap,
  tap,
} from 'rxjs';
import {
  checkAuth,
  login,
  loginComplete,
  logout,
  logoutComplete,
} from '../actions/auth.actions';

@Injectable()
export class AuthenticationEffects {
  login$ = createEffect(
    () =>
      this.actions$.pipe(
        ofType(login),
        tap(() => this.authService.login())
      ),
    { dispatch: false }
  );

  checkAuth$ = createEffect(() =>
    this.actions$.pipe(
      ofType(checkAuth),
      switchMap(() =>
        combineLatest([
          this.authService.isLoggedIn$,
          this.authService.user$,
          this.authService.getIsAdmin$(),
        ])
      ),
      switchMap(([isLoggedIn, profile, isAdmin]) => {
        if (isLoggedIn) {
          return scheduled(
            [
              loginComplete({
                profile: profile!,
                isLoggedIn: isLoggedIn,
                isAdmin: isAdmin,
              }),
            ],
            asyncScheduler
          );
        }

        return scheduled([logoutComplete()], asyncScheduler);
      })
    )
  );

  logout$ = createEffect(() =>
    this.actions$.pipe(
      ofType(logout),
      tap(() => this.authService.logout()),
      switchMap(() => of(logoutComplete()))
    )
  );

  constructor(
    private actions$: Actions,
    private authService: AuthenticationService
  ) {}
}
