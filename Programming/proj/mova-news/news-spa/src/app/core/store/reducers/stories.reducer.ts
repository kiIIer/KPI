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
  loadSearchStories,
  loadSearchStoriesSuccesses,
  clearSearch,
} from '../actions';
import { StoryEntity } from '../../models/story.entity';

export const storiesReducer = createReducer(
  initialStoriesState,
  on(loadStories, loadSearchStories, (state: StoriesState) => ({
    ...state,
    loading: true,
    loaded: false,
  })),
  on(clearSearch, (state: StoriesState) => ({
    ...state,
    searchState: {
      ...state.searchState,
      nextPage: undefined,
      ids: [],
    },
  })),
  on(loadSearchStoriesSuccesses, (state: StoriesState, { page }) => ({
    ...state,
    loading: false,
    loaded: true,
    searchState: {
      ...state.searchState,
      nextPage:
        typeof page._links === 'undefined'
          ? undefined
          : page._links.nextPage.href,
      ids: [
        ...(state.searchState.ids as string[]),
        ...page.entityModels.map((entity: StoryEntity) => entity.id),
      ],
    },
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
  on(loadStoriesSuccesses, (state: StoriesState, { page }) => ({
    ...state,
    loading: false,
    loaded: true,
    dashboardState: {
      ...state.dashboardState,
      nextPage:
        typeof page._links === 'undefined'
          ? undefined
          : page._links.nextPage.href,
      ids: [
        ...(state.news.ids as string[]),
        ...page.entityModels.map((entity: StoryEntity) => entity.id),
      ],
    },
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
    dashboardState: {
      ...state.dashboardState,
      ids: [...(state.news.ids as string[]), story.id],
    },
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
    dashboardState: {
      ...state.dashboardState,
      ids: [...(state.news.ids as string[]), story.id],
    },
    news: {
      ...state.news,
      ids: [...(state.news.ids as string[]), story.id],
      entities: {
        ...state.news.entities,
        [story.id]: {
          ...(state.news.entities[story.id] as StoryEntity),
          ...story,
        },
      },
    },
  })),
  on(deleteStorySuccesses, (state: StoriesState, { id }) => ({
    ...state,
    dashboardState: {
      ...state.dashboardState,
      ids: (state.news.ids as string[]).filter((idd) => idd != id),
    },
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
