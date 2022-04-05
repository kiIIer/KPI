import {createSelector} from "@ngrx/store";
import {selectUserState} from "./app.selector";
import {UserState} from "../state/user.state";

export const selectIsAdmin = createSelector(selectUserState, (state: UserState) => state.isAdmin);
