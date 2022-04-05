import { Component, OnInit } from '@angular/core';
import { asyncScheduler, Observable, scheduled, tap } from 'rxjs';
import { StoryEntity } from '../../models/story.entity';
import { Store } from '@ngrx/store';
import { AppState } from '../../store/state/app.state';
import { selectSelectedStory } from '../../store/selectors/stories.selector';
import { selectIsAdmin } from '../../store/selectors/user.selector';
import { deleteStory } from '../../store';
import { go } from '../../store/actions/router.actions';

@Component({
  selector: 'app-details-core',
  templateUrl: './details-core.component.html',
  styleUrls: ['./details-core.component.css'],
})
export class DetailsCoreComponent implements OnInit {
  story$: Observable<StoryEntity | undefined> = scheduled([], asyncScheduler);
  isAdmin$: Observable<boolean | undefined> = scheduled([], asyncScheduler);

  constructor(private store: Store<AppState>) {}

  ngOnInit(): void {
    this.story$ = this.store.select(selectSelectedStory);
    this.isAdmin$ = this.store.select(selectIsAdmin);
  }

  onDeleteStory(id: string) {
    this.store.dispatch(deleteStory({ id }));
    this.store.dispatch(go({ url: '/dashboard' }));
  }

  onOpenEditor(id: string) {
    this.store.dispatch(go({ url: `/editor/${id}` }));
  }
}
