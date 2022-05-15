import { createReducer, on } from '@ngrx/store';
import {
  initialAuthenticationState,
  AuthenticationState,
} from '../state/authentication.state';
import { loginComplete, logoutComplete } from '../actions/auth.actions';

export const authenticationReducer = createReducer(
  initialAuthenticationState,
  on(
    loginComplete,
    (state: AuthenticationState, { profile, isLoggedIn, isAdmin }) => ({
      ...state,
      isLoggedIn: isLoggedIn,
      isAdmin: isAdmin,
      userProfile: profile,
    })
  ),
  on(logoutComplete, (state: AuthenticationState) => ({
    ...state,
    isLoggedIn: false,
    userProfile: null,
  }))
);
