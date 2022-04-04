import {EntityState} from "@ngrx/entity";
import {StoryEntity} from "../../entities/story.entity";

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
      ids: ['one'],
      entities: {
        ['one']: {id: 'one', title: 'first', article: 'in state', dateCreated: 0}
      }
    },
    loading: false,
    loaded: false,
    nextPage: 'http://localhost:8080/titles',
  }
