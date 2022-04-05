import {RouterState} from "@ngrx/router-store";
import {StoriesState, initialStoriesState} from "./stories.state";
import {initialUserState, UserState} from "./user.state";

export interface AppState
{
  router: RouterState,
  stories: StoriesState,
  user: UserState,
}
