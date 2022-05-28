import { EntityState } from '@ngrx/entity';
import { StoryEntity } from '../../models/story.entity';

export interface StoriesState {
  news: EntityState<StoryEntity>;
  dashboardState: ViewState;
  searchState: ViewState;
  loading: boolean;
  loaded: boolean;
}

export interface ViewState {
  ids: string[];
  nextPage: string | undefined;
}

export const initialStoriesState: StoriesState = {
  news: {
    ids: [],
    entities: {},
  },
  dashboardState: {
    ids: [],
    nextPage: 'http://localhost:8080/titles',
  },
  searchState: {
    ids: [],
    nextPage: undefined,
  },
  loading: false,
  loaded: false,
};
