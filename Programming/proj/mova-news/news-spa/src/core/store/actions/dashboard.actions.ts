import {createAction, props} from "@ngrx/store";
import {PagedStories} from "../../entities/response/PagedStories";

export const loadStories = createAction('[Dashboard] Load News');
export const loadNewsSuccesses = createAction('[Dashboard] Load News Successes', props<{ page: PagedStories }>());
export const loadNewsFail = createAction('[Dashboard] Load News Fail');
