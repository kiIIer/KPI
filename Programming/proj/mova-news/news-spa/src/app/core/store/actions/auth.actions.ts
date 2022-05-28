import { createAction, props } from '@ngrx/store';
import { User } from '@auth0/auth0-angular';

export const checkAuth = createAction('[Auth] checkAuth');
export const login = createAction('[Auth] login');
export const loginComplete = createAction(
  '[Auth] loginComplete',
  props<{ profile: User | null; isLoggedIn: boolean; isAdmin: boolean }>()
);

export const logout = createAction('[Auth] logout');
export const logoutComplete = createAction('[Auth] logoutComplete');
