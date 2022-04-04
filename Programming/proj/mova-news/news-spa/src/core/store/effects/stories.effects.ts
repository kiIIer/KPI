import {Injectable} from "@angular/core";
import {NewsWorkerService} from "../../services/news-worker.service";
import {Actions, createEffect, ofType} from "@ngrx/effects";
import {loadNewsSuccesses, loadStories} from "../actions";
import {map, mergeMap, switchMap, tap, withLatestFrom} from "rxjs";
import {StoriesState} from "../state/stories.state";
import {Store} from "@ngrx/store";
import {selectNextPage} from "../selectors/stories.selector";
import {AppState} from "../state/app.state";
import {PagedStories} from "../../entities/response/PagedStories";

@Injectable()
export class StoriesEffects
{

  loadStories$ = createEffect(
    () =>
    {
      return this.actions$.pipe(
        ofType(loadStories),
        withLatestFrom(this.store.select(selectNextPage)),
        mergeMap(
          ([_, nextPage]) => this.service.getPagedNews(nextPage!).pipe(
            // tap((page: PagedStories) => (page._links.nextPage = undefined)),
            map((page: PagedStories) => (loadNewsSuccesses({page: page}))),
          )
        )
      )
    }
  );

  constructor(
    private actions$: Actions,
    private service: NewsWorkerService,
    private store: Store<AppState>
  )
  {
  }
}
