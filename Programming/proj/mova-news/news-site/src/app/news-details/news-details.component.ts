import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {IArticle} from "../entities/IArticle";
import {RestCommunicatorService} from "../rest-communicator.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-news-details',
  templateUrl: './news-details.component.html',
  styleUrls: ['./news-details.component.css']
})
export class NewsDetailsComponent implements OnInit
{
  id: any;
  article: Observable<IArticle> | undefined

  constructor(
    private route: ActivatedRoute,
    private service: RestCommunicatorService
  )
  {
  }

  ngOnInit(): void
  {
    this.getArticle()
  }

  getArticle(): void
  {
    const id = this.route.snapshot.paramMap.get('id')
    this.article = this.service.getNews(id!)
  }

}
