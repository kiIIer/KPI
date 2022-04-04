import {AppState} from "../state/app.state";
import {createFeatureSelector, createSelector} from "@ngrx/store";
import {StoriesState} from "../state/stories.state";

export const selectDashboardState = (state: AppState) => state.stories;
export const selectUserState = (state: AppState) => state.user;
