import {Component, OnInit} from '@angular/core';
import {asyncScheduler, Observable, scheduled, tap} from "rxjs";
import {StoryEntity} from "../../models/story.entity";
import {Store} from "@ngrx/store";
import {AppState} from "../../store/state/app.state";
import {selectSelectedStory, selectStoryEntity} from "../../store/selectors/stories.selector";
import {selectRouteParams} from "../../store/selectors/router.selector";
import {loadArticle, loadStory} from "../../store";

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
