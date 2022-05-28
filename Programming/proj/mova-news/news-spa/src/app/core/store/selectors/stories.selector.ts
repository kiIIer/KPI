import { StoriesState, ViewState } from '../state/stories.state';
import { createSelector } from '@ngrx/store';
import { selectStoriesState } from './app.selector';
import { Dictionary, EntityState } from '@ngrx/entity';
import { StoryEntity } from '../../models/story.entity';
import { selectRouteParams } from './router.selector';

export const selectStoriesEntityState = createSelector(
  selectStoriesState,
  (state: StoriesState) => state.news
);

export const selectDashboardState = createSelector(
  selectStoriesState,
  (state: StoriesState) => state.dashboardState
);
export const selectSearchState = createSelector(
  selectStoriesState,
  (state: StoriesState) => state.searchState
);
export const selectDashboardIds = createSelector(
  selectDashboardState,
  (state: ViewState) => state.ids
);

export const selectSearchIds = createSelector(
  selectSearchState,
  (state: ViewState) => state.ids
);

export const selectStoriesEntityDic = createSelector(
  selectStoriesEntityState,
  (state: EntityState<StoryEntity>) => state.entities
);
export const selectSortedDashboardStoryEntities = createSelector(
  selectStoriesEntityDic,
  selectDashboardIds,
  (state: Dictionary<StoryEntity>, ids: string[]) =>
    Object.values(state)
      .filter((a: StoryEntity | undefined) => {
        let pass: boolean = false;
        ids.forEach((id: string) => (pass = pass || id == a?.id));
        return pass;
      })
      .sort((a: StoryEntity | undefined, b: StoryEntity | undefined) => {
        if (a?.dateCreated! > b?.dateCreated!) {
          return -1;
        } else if (a?.dateCreated! < b?.dateCreated!) {
          return 1;
        } else {
          return 0;
        }
      })
);
export const selectSortedSearchStoryEntities = createSelector(
  selectStoriesEntityDic,
  selectSearchIds,
  (state: Dictionary<StoryEntity>, ids: string[]) =>
    Object.values(state)
      .filter((a: StoryEntity | undefined) => {
        let pass: boolean = false;
        ids.forEach((id: string) => (pass = pass || id == a?.id));
        return pass;
      })
      .sort((a: StoryEntity | undefined, b: StoryEntity | undefined) => {
        if (a?.dateCreated! > b?.dateCreated!) {
          return -1;
        } else if (a?.dateCreated! < b?.dateCreated!) {
          return 1;
        } else {
          return 0;
        }
      })
);
export const selectSelectedStory = createSelector(
  selectStoriesEntityDic,
  selectRouteParams,
  (state: Dictionary<StoryEntity>, { id }) => state[id] ?? ({} as StoryEntity)
);

export const selectStoryEntity = (id: string) =>
  createSelector(
    selectStoriesEntityState,
    (state: EntityState<StoryEntity>) => state.entities[id]
  );

export const selectStoryEntityIds = createSelector(
  selectStoriesEntityState,
  (state: EntityState<StoryEntity>) => state.ids
);

export const selectLoading = createSelector(
  selectStoriesState,
  (state: StoriesState) => state.loading
);

export const selectLoaded = createSelector(
  selectStoriesState,
  (state: StoriesState) => state.loaded
);

export const selectNextPage = createSelector(
  selectDashboardState,
  (state: ViewState) => state.nextPage
);

export const selectNextSearchPage = createSelector(
  selectSearchState,
  (state: ViewState) => state.nextPage
);
