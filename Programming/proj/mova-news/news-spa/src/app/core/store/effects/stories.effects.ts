import { Injectable } from '@angular/core';
import { StoryWorkerService } from '../../services/story-worker.service';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import {
  deleteStory,
  deleteStorySuccesses,
  loadArticle,
  loadArticleSuccesses,
  loadNewsSuccesses,
  loadStories,
  loadStory,
  loadStorySuccesses,
  saveStory,
  saveStorySuccesses,
} from '../actions';
import {
  catchError,
  map,
  mergeMap,
  of,
  switchMap,
  tap,
  withLatestFrom,
} from 'rxjs';
import { StoriesState } from '../state/stories.state';
import { Store } from '@ngrx/store';
import { selectNextPage } from '../selectors/stories.selector';
import { AppState } from '../state/app.state';
import { PagedStories } from '../../models/response/PagedStories';
import { StoryEntity } from '../../models/story.entity';
import { HttpResponse } from '@angular/common/http';
import { go } from '../actions/router.actions';

@Injectable()
export class StoriesEffects {
  loadStories$ = createEffect(() => {
    return this.actions$.pipe(
      ofType(loadStories),
      withLatestFrom(this.store.select(selectNextPage)),
      mergeMap(([_, nextPage]) =>
        this.service.getPagedStories(nextPage!).pipe(
          // tap((page: PagedStories) => (page._links.nextPage = undefined)),
          map((page: PagedStories) => loadNewsSuccesses({ page: page }))
        )
      )
    );
  });

  loadStory$ = createEffect(() => {
    return this.actions$.pipe(
      ofType(loadStory),
      mergeMap((action) =>
        this.service
          .getStory(action.id)
          .pipe(
            map((story: StoryEntity) => loadStorySuccesses({ story: story }))
          )
      )
    );
  });

  loadArticle$ = createEffect(() => {
    return this.actions$.pipe(
      ofType(loadArticle),
      mergeMap((action) =>
        this.service
          .getArticle(action.id)
          .pipe(
            map((story: StoryEntity) =>
              loadArticleSuccesses({ article: story.article!, id: story.id })
            )
          )
      )
    );
  });

  publishStory$ = createEffect(() => {
    return this.actions$.pipe(
      ofType(saveStory),
      mergeMap((action) =>
        (typeof action.story.id === 'undefined'
          ? this.service.postStory(action.story)
          : this.service.patchStory(action.story)
        ).pipe(map((story: StoryEntity) => saveStorySuccesses({ story })))
      )
    );
  });

  storyRedirect$ = createEffect(() => {
    return this.actions$.pipe(
      ofType(saveStorySuccesses),
      map((action) => go({ url: `/details/${action.story.id}` }))
    );
  });

  deleteStory$ = createEffect(() => {
    return this.actions$.pipe(
      ofType(deleteStory),
      mergeMap((action) =>
        this.service
          .deleteStory(action.id)
          .pipe(
            map((response: HttpResponse<Object>) =>
              deleteStorySuccesses({ id: action.id })
            )
          )
      )
    );
  });

  constructor(
    private actions$: Actions,
    private service: StoryWorkerService,
    private store: Store<AppState>
  ) {}
}
