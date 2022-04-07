import { createReducer, on } from '@ngrx/store';
import { logIn, logOut } from '../actions/user.actions';
import { initialUserState, UserState } from '../state/user.state';

export const userReducer = createReducer(
  initialUserState,
  on(logIn, (state: UserState) => ({
    ...state,
    isAdmin: true,
    isLogined: true,
    userName: 'Killer',
  })),
  //TODO:Change hard code username
  on(logOut, (state: UserState) => ({
    ...state,
    isAdmin: false,
    isLogined: false,
    userName: undefined,
  }))
);
