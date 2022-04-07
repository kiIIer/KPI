import { createSelector } from '@ngrx/store';
import { selectUserState } from './app.selector';
import { UserState } from '../state/user.state';

export const selectIsAdmin = createSelector(
  selectUserState,
  (state: UserState) => state.isAdmin
);
export const selectUserName = createSelector(
  selectUserState,
  (state: UserState) => state.userName
);
export const selectIsLogined = createSelector(
  selectUserState,
  (state: UserState) => state.isLogined
);
