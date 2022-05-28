import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { StoryEntity } from '../../models/story.entity';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css'],
})
export class DetailsComponent implements OnInit {
  @Input() story: StoryEntity | undefined | null;
  @Input() isAdmin: boolean | undefined | null = false;
  @Output() openEditorEvent: EventEmitter<string> = new EventEmitter<string>();
  @Output() deleteStoryEvent: EventEmitter<string> = new EventEmitter<string>();

  constructor() {}

  ngOnInit(): void {}

  openEditor(id: string) {
    this.openEditorEvent.emit(id);
  }

  deleteStory(id: string) {
    this.deleteStoryEvent.emit(id);
  }
}
