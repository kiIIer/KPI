import { createAction, props } from '@ngrx/store';
import { PagedStories } from '../../models/response/PagedStories';
import { StoryEntity } from '../../models/story.entity';

export const loadStories = createAction('[Stories] Load Stories');
export const loadStoriesSuccesses = createAction(
  '[Stories] Load Stories Successes',
  props<{ page: PagedStories }>()
);
export const loadNewsFail = createAction('[Stories] Load Stories Fail');
export const loadStory = createAction(
  '[Stories] Load Story',
  props<{ id: string }>()
);
export const loadStorySuccesses = createAction(
  '[Stories] Load Story Successes',
  props<{ story: StoryEntity }>()
);
export const loadArticle = createAction(
  '[Stories] Load Article',
  props<{ id: string }>()
);
export const loadArticleSuccesses = createAction(
  '[Stories] Load Article Successes',
  props<{ id: string; article: string }>()
);

export const saveStory = createAction(
  '[Editor] Save Story',
  props<{ story: StoryEntity }>()
);

export const saveStorySuccesses = createAction(
  '[Editor] Save Story Successes',
  props<{ story: StoryEntity }>()
);

export const deleteStory = createAction(
  '[Editor] Delete Story',
  props<{ id: string }>()
);

export const deleteStorySuccesses = createAction(
  '[Editor] Delete Story Successes',
  props<{ id: string }>()
);
