import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {StoryEntity} from "../../models/story.entity";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit
{

  @Input() loading: boolean | null = null;
  @Input() nextPage: string | undefined | null;
  @Input() stories: (StoryEntity | undefined)[] | null = [];
  @Input() idAdmin: boolean | null = null;
  @Output() loadMoreEvent: EventEmitter<any> = new EventEmitter<any>();
  @Output() openDetailsEvent: EventEmitter<string> = new EventEmitter<string>();
  @Output() openEditorEvent: EventEmitter<string> = new EventEmitter<string>();
  @Output() deleteStoryEvent: EventEmitter<string> = new EventEmitter<string>();

  constructor()
  {
  }

  ngOnInit(): void
  {
  }

  loadMore()
  {
    this.loadMoreEvent.emit();
  }

  openDetails(id: string)
  {
    this.openDetailsEvent.emit(id);
  }

  openEditor(id: string)
  {
    this.openEditorEvent.emit(id);
  }

  deleteStory(id: string)
  {
    this.deleteStoryEvent.emit(id);
  }

}
