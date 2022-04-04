import {Injectable} from "@angular/core";
import {ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree} from "@angular/router";
import {Store} from "@ngrx/store";
import {AppState} from "../store/state/app.state";
import {
  asyncScheduler,
  catchError,
  filter, map,
  mergeMap,
  Observable,
  scheduled,
  skipWhile,
  switchMap,
  take,
  tap
} from "rxjs";
import {
  selectLoaded,
  selectSelectedStory,
  selectStoriesEntityDic,
  selectStoryEntity
} from "../store/selectors/stories.selector";
import {loadArticle, loadStories, loadStory} from "../store";
import {selectCurrentRoute, selectRouteParams} from "../store/selectors/router.selector";
import {StoryEntity} from "../models/story.entity";
import {Dictionary} from "@ngrx/entity";

@Injectable({providedIn: "root"})
export class StoryGuard implements CanActivate
{
  constructor(
    private store: Store<AppState>
  )
  {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree
  {
    return this.checkForStory().pipe(
      catchError(() => scheduled([false], asyncScheduler)),
    );
  }

  checkForStory(): Observable<boolean>
  {
    return this.store.select(selectRouteParams).pipe(
      switchMap(({id}) => this.store.select(selectStoryEntity(id)).pipe(
          map((story: StoryEntity | undefined) => ({story, id})),
          tap(({story, id}) =>
          {
            if (typeof story === 'undefined')
            {
              this.store.dispatch(loadStory({id}));
            }
          }),
          filter(({story}) => !(typeof story === 'undefined')),
          tap(({story, id}) =>
          {
            if (typeof story?.article === 'undefined')
            {
              this.store.dispatch(loadArticle({id}));
            }
          }),
          filter(({story}) => !(typeof story?.article === 'undefined')),
          map(() => true),
        )
      ),
    );
  }

}
