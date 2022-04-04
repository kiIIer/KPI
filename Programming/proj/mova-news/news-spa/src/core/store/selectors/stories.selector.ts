import {StoriesState} from "../state/stories.state";
import {createSelector} from "@ngrx/store";
import {selectDashboardState} from "./app.selector";
import {Dictionary, EntityState} from "@ngrx/entity";
import {StoryEntity} from "../../models/story.entity";
import {selectRouteParams} from "./router.selector";

export const selectStoriesEntityState = createSelector(selectDashboardState, (state: StoriesState) => state.news);
export const selectStoriesEntityDic = createSelector(selectStoriesEntityState, (state: EntityState<StoryEntity>) => state.entities);
export const selectStoryEntities = createSelector(selectStoriesEntityDic, (state: Dictionary<StoryEntity>) => Object.values(state));
export const selectSelectedStory = createSelector(selectStoriesEntityDic, selectRouteParams, (state: Dictionary<StoryEntity>, {id}) => state[id] ?? {} as StoryEntity);

export const selectStoryEntity = (id: string) => createSelector(selectStoriesEntityState, (state: EntityState<StoryEntity>) => state.entities[id]);


export const selectStoryEntityIds = createSelector(selectStoriesEntityState, (state: EntityState<StoryEntity>) => state.ids);

export const selectLoading = createSelector(selectDashboardState, (state: StoriesState) => state.loading);

export const selectLoaded = createSelector(selectDashboardState, (state: StoriesState) => state.loaded);

export const selectNextPage = createSelector(selectDashboardState, (state: StoriesState) => state.nextPage);

