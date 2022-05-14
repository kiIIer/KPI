import { Component, OnInit } from '@angular/core';
import { asyncScheduler, Observable, scheduled } from 'rxjs';
import { StoryEntity } from '../../models/story.entity';
import { Store } from '@ngrx/store';
import { AppState } from '../../store/state/app.state';
import { Router } from '@angular/router';
import {
  selectLoading,
  selectNextPage,
  selectNextSearchPage,
  selectSortedDashboardStoryEntities,
  selectSortedSearchStoryEntities,
} from '../../store/selectors/stories.selector';
import { selectIsAdmin } from '../../store/selectors/user.selector';
import { deleteStory, loadStories } from '../../store';
import { go } from '../../store/actions/router.actions';

@Component({
  selector: 'app-search-core',
  templateUrl: './search-core.component.html',
  styleUrls: ['./search-core.component.css'],
})
export class SearchCoreComponent implements OnInit {
  news$: Observable<(StoryEntity | undefined)[]> = scheduled(
    [],
    asyncScheduler
  );
  nextPage$: Observable<string | undefined> = scheduled([], asyncScheduler);
  loading$: Observable<boolean> = scheduled([], asyncScheduler);
  idAdmin$: Observable<boolean> = scheduled([], asyncScheduler);

  constructor(private store: Store<AppState>, private router: Router) {}

  ngOnInit(): void {
    this.loading$ = this.store.select(selectLoading);
    this.news$ = this.store.select(selectSortedSearchStoryEntities);
    this.nextPage$ = this.store.select(selectNextSearchPage);
    this.idAdmin$ = this.store.select(selectIsAdmin);
  }

  onLoadMore() {
    this.store.dispatch(loadStories());
  }

  onDeleteStory(id: string) {
    this.store.dispatch(deleteStory({ id }));
  }

  onOpenEditor(id: string) {
    this.store.dispatch(go({ url: `/editor/${id}` }));
  }

  onOpenDetails(id: string) {
    this.store.dispatch(go({ url: `/details/${id}` }));
  }

  onNewStory() {
    this.store.dispatch(go({ url: '/editor/new' }));
  }
}
