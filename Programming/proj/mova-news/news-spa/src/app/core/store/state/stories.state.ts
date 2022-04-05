import {EntityState} from "@ngrx/entity";
import {StoryEntity} from "../../models/story.entity";

export interface StoriesState
{
  news: EntityState<StoryEntity>
  loading: boolean,
  loaded: boolean,
  nextPage: string | undefined,
}

export const initialStoriesState: StoriesState =
  {
    news: {
      ids: [],
      entities: {}
    },
    loading: false,
    loaded: false,
    nextPage: 'http://localhost:8080/titles',
  }
