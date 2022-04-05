import { createReducer, on } from '@ngrx/store';
import { logIn, logOut } from '../actions/user.actions';
import { initialUserState, UserState } from '../state/user.state';

export const userReducer = createReducer(
  initialUserState,
  on(logIn, (state: UserState) => ({ ...state, isAdmin: true })),
  on(logOut, (state: UserState) => ({ ...state, isAdmin: false }))
);
