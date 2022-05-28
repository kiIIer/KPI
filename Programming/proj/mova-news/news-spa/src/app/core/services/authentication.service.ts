import { Injectable } from '@angular/core';
import { AuthService, User } from '@auth0/auth0-angular';
import {
  asyncScheduler,
  concatMap,
  map,
  Observable,
  pluck,
  scheduled,
  switchMap,
  tap,
} from 'rxjs';
import jwt_decode from 'jwt-decode';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {
  constructor(public authService: AuthService) {}

  get isLoggedIn$(): Observable<boolean> {
    return this.authService.isAuthenticated$;
  }

  getToken$(): Observable<string> {
    return this.authService.getAccessTokenSilently();
  }

  getIsAdmin$(): Observable<boolean> {
    return this.authService.isAuthenticated$.pipe(
      switchMap((isAuthed: boolean) =>
        isAuthed
          ? this.authService.getAccessTokenSilently().pipe(
              tap((tocken) => console.log(tocken)),
              map((token: string) =>
                (jwt_decode(token) as any).permissions.includes('admin')
              )
            )
          : scheduled([false], asyncScheduler)
      )
    );
  }

  get user$(): Observable<User | null | undefined> {
    return this.authService.user$;
  }

  login(): void {
    this.authService.loginWithRedirect();
  }

  logout(): void {
    this.authService.logout({ returnTo: document.location.origin });
  }
}
