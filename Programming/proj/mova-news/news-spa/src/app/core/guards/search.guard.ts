import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  RouterStateSnapshot,
  UrlTree,
} from '@angular/router';
import { Store } from '@ngrx/store';
import { AppState } from '../store/state/app.state';
import {
  asyncScheduler,
  catchError,
  filter,
  map,
  Observable,
  pipe,
  scheduled,
  switchMap,
  tap,
  withLatestFrom,
} from 'rxjs';
import {
  selectDashboardIds,
  selectNextSearchPage,
  selectSearchIds,
} from '../store/selectors/stories.selector';
import { loadSearchStories, loadStories } from '../store';
import {
  selectQueryParam,
  selectRouteParam,
  selectRouteParams,
} from '../store/selectors/router.selector';

@Injectable({ providedIn: 'root' })
export class SearchGuard implements CanActivate {
  constructor(private store: Store<AppState>) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ):
    | Observable<boolean | UrlTree>
    | Promise<boolean | UrlTree>
    | boolean
    | UrlTree {
    return this.checkStore().pipe(
      switchMap(() => scheduled<boolean>([true], asyncScheduler)),
      catchError(() => scheduled<boolean>([false], asyncScheduler))
    );
  }

  checkStore(): Observable<boolean> {
    return this.store.select(selectSearchIds).pipe(
      withLatestFrom(this.store.select(selectQueryParam('q'))),
      tap(([ids, q]) => {
        console.log(q);
        if (ids.length == 0) {
          this.store.dispatch(loadSearchStories({ q: q! }));
        }
      }),
      filter(([ids, _]) => ids.length != 0),
      map(() => true)
    );
  }
}
