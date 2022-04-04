import {createAction, props} from "@ngrx/store";
import {PagedStories} from "../../models/response/PagedStories";
import {StoryEntity} from "../../models/story.entity";

export const loadStories = createAction('[Stories] Load Stories');
export const loadNewsSuccesses = createAction('[Stories] Load Stories Successes', props<{ page: PagedStories }>());
export const loadNewsFail = createAction('[Stories] Load Stories Fail');
export const loadStory = createAction('[Stories] Load Story', props<{ id: string }>());
export const loadStorySuccesses = createAction('[Stories] Load Story Successes', props<{ story: StoryEntity }>());
export const loadArticle = createAction('[Stories] Load Article', props<{ id: string }>());
export const loadArticleSuccesses = createAction('[Stories] Load Article Successes', props<{ id: string, article: string }>());
