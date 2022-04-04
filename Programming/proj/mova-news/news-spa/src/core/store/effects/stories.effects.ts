import {Injectable} from "@angular/core";
import {NewsWorkerService} from "../../services/news-worker.service";
import {Actions, createEffect, ofType} from "@ngrx/effects";
import {
  loadArticle,
  loadArticleSuccesses,
  loadNewsSuccesses,
  loadStories,
  loadStory,
  loadStorySuccesses
} from "../actions";
import {map, mergeMap, switchMap, tap, withLatestFrom} from "rxjs";
import {StoriesState} from "../state/stories.state";
import {Store} from "@ngrx/store";
import {selectNextPage} from "../selectors/stories.selector";
import {AppState} from "../state/app.state";
import {PagedStories} from "../../models/response/PagedStories";
import {StoryEntity} from "../../models/story.entity";

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
          ([_, nextPage]) => this.service.getPagedStories(nextPage!).pipe(
            // tap((page: PagedStories) => (page._links.nextPage = undefined)),
            map((page: PagedStories) => (loadNewsSuccesses({page: page}))),
          )
        )
      )
    }
  );

  loadStory$ = createEffect(
    () =>
    {
      return this.actions$.pipe(
        ofType(loadStory),
        mergeMap(
          (action) => this.service.getStory(action.id).pipe(
            map((story: StoryEntity) => (loadStorySuccesses({story: story}))),
          )
        )
      )
    }
  );

  loadArticle$ = createEffect(
    () =>
    {
      return this.actions$.pipe(
        ofType(loadArticle),
        tap((action) => console.log(action)),
        mergeMap(
          (action) => this.service.getArticle(action.id).pipe(
            map((story: StoryEntity) => (loadArticleSuccesses({article: story.article!, id: story.id}))),
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
