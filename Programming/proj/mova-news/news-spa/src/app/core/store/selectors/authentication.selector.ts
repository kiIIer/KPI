import { createSelector } from '@ngrx/store';
import { selectAuthenticationState } from './app.selector';
import { AuthenticationState } from '../state/authentication.state';

export const selectCurrentUserProfile = createSelector(
  selectAuthenticationState,
  (state: AuthenticationState) => state.userProfile
);

// get the isLoggedIn from the auth state
export const selectIsLoggedIn = createSelector(
  selectAuthenticationState,
  (state: AuthenticationState) => state.isLoggedIn
);

export const selectIsAdmin = createSelector(
  selectAuthenticationState,
  (state: AuthenticationState) => state.isAdmin
  // () => true
);
