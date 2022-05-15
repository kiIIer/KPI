import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { deleteStory, loadStories } from '../../store';
import { asyncScheduler, Observable, of, scheduled } from 'rxjs';
import {
  selectLoading,
  selectSortedDashboardStoryEntities,
  selectNextPage,
} from '../../store/selectors/stories.selector';
import { AppState } from '../../store/state/app.state';
import { StoryEntity } from '../../models/story.entity';
import { Router } from '@angular/router';
import { go } from '../../store/actions/router.actions';
import { selectIsAdmin } from '../../store/selectors/authentication.selector';

@Component({
  selector: 'app-dashboard-core',
  templateUrl: './dashboard-core.component.html',
  styleUrls: ['./dashboard-core.component.css'],
})
export class DashboardCoreComponent implements OnInit {
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
    this.news$ = this.store.select(selectSortedDashboardStoryEntities);
    this.nextPage$ = this.store.select(selectNextPage);
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
