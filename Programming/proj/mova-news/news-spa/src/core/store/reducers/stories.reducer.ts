import {createReducer, on} from "@ngrx/store";
import {StoriesState, initialStoriesState} from "../state/stories.state";
import {
  loadStories,
  loadNewsFail,
  loadNewsSuccesses,
  loadArticleSuccesses,
  loadArticle,
  loadStory,
  loadStorySuccesses
} from "../actions";
import {StoryEntity} from "../../models/story.entity";

export const storiesReducer = createReducer(
  initialStoriesState,
  on(loadStories, (state: StoriesState) => ({...state, loading: true, loaded: false})),
  on(loadNewsSuccesses, (state: StoriesState, {page}) => ({
    ...state,
    loading: false,
    loaded: true,
    nextPage: (typeof page._links.nextPage === "undefined") ? undefined : page._links.nextPage.href,
    news: {
      ...state.news,
      ids: [...state.news.ids as string[], ...page.entityModels.map((entity: StoryEntity) => entity.id)],
      entities: Object.assign({...state.news.entities}, ...page.entityModels.map((entity: StoryEntity) => ({[entity.id]: entity}))),
    }
  })),
  on(loadNewsFail, (state: StoriesState) => ({...state, loading: false, loaded: false})),
  on(loadStory, (state: StoriesState) => ({...state, loading: true, loaded: false})),
  on(loadStorySuccesses, (state: StoriesState, {story}) => ({
    ...state,
    loading: false,
    loaded: true,
    news: {
      ...state.news,
      entities: {
        ...state.news.entities,
        [story.id]: story,
      },
    },
  })),
  on(loadArticle, (state: StoriesState) => ({...state, loading: true, loaded: false})),
  on(loadArticleSuccesses, (state: StoriesState, {id, article}) => ({
    ...state,
    loading: false,
    loaded: true,
    news: {
      ...state.news,
      entities: {
        ...state.news.entities,
        [id]: {
          ...state.news.entities[id] as StoryEntity,
          article: article
        },
      },
    },
  }))
);
