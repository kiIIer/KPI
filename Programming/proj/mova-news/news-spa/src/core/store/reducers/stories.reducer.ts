import {createReducer, on} from "@ngrx/store";
import {StoriesState, initialStoriesState} from "../state/stories.state";
import {loadStories, loadNewsFail, loadNewsSuccesses} from "../actions";
import {PagedStories} from "../../entities/response/PagedStories";
import {StoryEntity} from "../../entities/story.entity";
import {Dictionary} from "@ngrx/entity";

export const storiesReducer = createReducer(
  initialStoriesState,
  on(loadStories, (state: StoriesState) => ({...state, loading: true, loaded: false})),
  on(loadNewsSuccesses, (state: StoriesState, {page}) => ({
    ...state,
    loading: false,
    loaded: true,
    nextPage: (typeof page._links.nextPage === "undefined")? undefined : page._links.nextPage.href,
    news: {
      ...state.news,
      ids: [...state.news.ids as string[], ...page.entityModels.map((entity: StoryEntity) => entity.id)],
      entities: Object.assign({...state.news.entities}, ...page.entityModels.map((entity: StoryEntity) => ({[entity.id]: entity}))),
    }
  })),
  on(loadNewsFail, (state: StoriesState) => ({...state, loading: false, loaded: false}))
);
