import {AppState} from "../state/app.state";
import {createFeatureSelector, createSelector} from "@ngrx/store";
import {StoriesState} from "../state/stories.state";

export const selectStoriesState = (state: AppState) => state.stories;
export const selectAuthenticationState = (state: AppState) => state.authentication;
