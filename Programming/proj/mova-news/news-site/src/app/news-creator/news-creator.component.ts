import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {RestCommunicatorService} from "../rest-communicator.service";
import {IArticle} from "../entities/IArticle";
import {Observable} from "rxjs";

@Component({
  selector: 'app-news-creator',
  templateUrl: './news-creator.component.html',
  styleUrls: ['./news-creator.component.css']
})
export class NewsCreatorComponent implements OnInit
{

  creatorForm: FormGroup = new FormGroup({});
  response: Observable<IArticle> | undefined;

  constructor(
    private formBuilder: FormBuilder,
    private service: RestCommunicatorService
  )
  {
  }

  ngOnInit(): void
  {
    let config = {
      'title': [null, Validators.required],
      'article': [null, Validators.required]
    }
    this.creatorForm = this.formBuilder.group(config)
  }

  submit()
  {
    if (!this.creatorForm.valid)
    {
      return;
    }

    const article = {
      title: this.creatorForm.value.title,
      article: this.creatorForm.value.article,
    } as IArticle;

    this.response = this.service.postArticle(article)
  }

}
