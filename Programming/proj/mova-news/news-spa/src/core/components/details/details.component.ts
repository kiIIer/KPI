import {Component, Input, OnInit} from '@angular/core';
import {StoryEntity} from "../../models/story.entity";

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit
{

  @Input() story: StoryEntity | undefined | null;

  constructor()
  {
  }

  ngOnInit(): void
  {
  }

}
