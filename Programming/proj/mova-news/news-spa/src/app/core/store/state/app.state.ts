import {RouterState} from "@ngrx/router-store";
import {StoriesState, initialStoriesState} from "./stories.state";
import {initialAuthenticationState, AuthenticationState} from "./authentication.state";

export interface AppState
{
  router: RouterState,
  stories: StoriesState,
  authentication: AuthenticationState,
}
