import { Component, OnInit } from '@angular/core';
import { asyncScheduler, filter, Observable, scheduled, tap } from 'rxjs';
import { StoryEntity } from '../../models/story.entity';
import { AppState } from '../../store/state/app.state';
import { Store } from '@ngrx/store';
import { selectSelectedStory } from '../../store/selectors/stories.selector';
import { saveStory } from '../../store';
import { go } from '../../store/actions/router.actions';

@Component({
  selector: 'app-editor-core',
  templateUrl: './editor-core.component.html',
  styleUrls: ['./editor-core.component.css'],
})
export class EditorCoreComponent implements OnInit {
  story$: Observable<StoryEntity> = scheduled([], asyncScheduler);

  constructor(private store: Store<AppState>) {}

  ngOnInit(): void {
    this.story$ = this.store.select(selectSelectedStory);
  }

  onSave(story: StoryEntity) {
    this.store.dispatch(saveStory({ story }));
  }
}
