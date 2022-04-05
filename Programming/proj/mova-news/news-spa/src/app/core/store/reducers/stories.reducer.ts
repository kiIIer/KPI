import { createReducer, on } from '@ngrx/store';
import { StoriesState, initialStoriesState } from '../state/stories.state';
import {
  loadStories,
  loadNewsFail,
  loadStoriesSuccesses,
  loadArticleSuccesses,
  loadArticle,
  loadStory,
  loadStorySuccesses,
  saveStorySuccesses,
  deleteStory,
  deleteStorySuccesses,
} from '../actions';
import { StoryEntity } from '../../models/story.entity';

export const storiesReducer = createReducer(
  initialStoriesState,
  on(loadStories, (state: StoriesState) => ({
    ...state,
    loading: true,
    loaded: false,
  })),
  on(loadStoriesSuccesses, (state: StoriesState, { page }) => ({
    ...state,
    loading: false,
    loaded: true,
    nextPage:
      typeof page._links.nextPage === 'undefined'
        ? undefined
        : page._links.nextPage.href,
    news: {
      ...state.news,
      ids: [
        ...(state.news.ids as string[]),
        ...page.entityModels.map((entity: StoryEntity) => entity.id),
      ],
      entities: Object.assign(
        { ...state.news.entities },
        ...page.entityModels.map((entity: StoryEntity) => ({
          [entity.id]: entity,
        }))
      ),
    },
  })),
  on(loadNewsFail, (state: StoriesState) => ({
    ...state,
    loading: false,
    loaded: false,
  })),
  on(loadStory, (state: StoriesState) => ({
    ...state,
    loading: true,
    loaded: false,
  })),
  on(loadStorySuccesses, (state: StoriesState, { story }) => ({
    ...state,
    loading: false,
    loaded: true,
    news: {
      ...state.news,
      ids: [...(state.news.ids as string[]), story.id],
      entities: {
        ...state.news.entities,
        [story.id]: story,
      },
    },
  })),
  on(loadArticle, (state: StoriesState) => ({
    ...state,
    loading: true,
    loaded: false,
  })),
  on(loadArticleSuccesses, (state: StoriesState, { id, article }) => ({
    ...state,
    loading: false,
    loaded: true,
    news: {
      ...state.news,
      entities: {
        ...state.news.entities,
        [id]: {
          ...(state.news.entities[id] as StoryEntity),
          article: article,
        },
      },
    },
  })),
  on(saveStorySuccesses, (state: StoriesState, { story }) => ({
    ...state,
    news: {
      ...state.news,
      ids: [...(state.news.ids as string[]), story.id],
      entities: {
        ...state.news.entities,
        [story.id]: {
          ...(state.news.entities[story.id] as StoryEntity),
        },
      },
    },
  })),
  on(deleteStorySuccesses, (state: StoriesState, { id }) => ({
    ...state,
    news: {
      ...state.news,
      ids: (state.news.ids as string[]).filter((idd) => idd != id),
      entities: Object.assign(
        {},
        ...Object.entries(state.news.entities)
          .filter(([key, value]) => key != id)
          .map(([key, value]) => ({
            [key]: value,
          }))
      ),
    },
  }))
);
