import {Component, OnInit} from '@angular/core';
import {asyncScheduler, Observable, scheduled} from "rxjs";
import {StoryEntity} from "../../entities/story.entity";
import {Store} from "@ngrx/store";
import {AppState} from "../../store/state/app.state";
import {selectSelectedStory, selectStoryEntity} from "../../store/selectors/stories.selector";

@Component({
  selector: 'app-details-core',
  templateUrl: './details-core.component.html',
  styleUrls: ['./details-core.component.css']
})
export class DetailsCoreComponent implements OnInit
{

  story$: Observable<StoryEntity | undefined> = scheduled([], asyncScheduler);

  constructor(
    private store: Store<AppState>,
  )
  {
  }

  ngOnInit(): void
  {
    this.story$ = this.store.select(selectSelectedStory);
  }

}
