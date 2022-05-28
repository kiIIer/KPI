import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  RouterStateSnapshot,
  UrlTree,
} from '@angular/router';
import {
  asyncScheduler,
  catchError,
  filter,
  map,
  Observable,
  scheduled,
  switchMap,
  take,
  tap,
} from 'rxjs';
import { AppState } from '../store/state/app.state';
import { Store } from '@ngrx/store';
import {
  selectDashboardIds,
  selectLoaded,
  selectStoryEntityIds,
} from '../store/selectors/stories.selector';
import { loadStories } from '../store';

@Injectable({ providedIn: 'root' })
export class StoriesGuard implements CanActivate {
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
    return this.store.select(selectDashboardIds).pipe(
      tap((ids: string[] | number[]) => {
        if (ids.length == 0) {
          this.store.dispatch(loadStories());
        }
      }),
      filter((ids: string[] | number[]) => ids.length != 0),
      map((ids: string[] | number[]) => true)
    );
  }
}
