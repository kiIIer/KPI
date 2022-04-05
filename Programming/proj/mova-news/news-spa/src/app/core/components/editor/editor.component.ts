import {
  Component,
  EventEmitter,
  Input,
  NgZone,
  OnInit,
  Output,
  ViewChild,
} from '@angular/core';
import { StoryEntity } from '../../models/story.entity';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CdkTextareaAutosize } from '@angular/cdk/text-field';
import { take } from 'rxjs';

@Component({
  selector: 'app-editor',
  templateUrl: './editor.component.html',
  styleUrls: ['./editor.component.css'],
})
export class EditorComponent implements OnInit {
  @Input() story: StoryEntity | null | undefined;

  @Output() save: EventEmitter<StoryEntity> = new EventEmitter<StoryEntity>();

  storyForm: FormGroup | undefined;

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit(): void {
    this.storyForm = this.formBuilder.group({
      ['title']: [this.story!.title, Validators.required],
      ['article']: [this.story!.article, Validators.required],
    });
  }

  submit() {
    this.story = { ...this.story, ...(this.storyForm!.value as StoryEntity) };
    console.log(this.story);
    this.save.emit(this.story);
  }
}
