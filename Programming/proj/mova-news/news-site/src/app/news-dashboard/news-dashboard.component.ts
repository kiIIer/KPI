import {Component, OnInit} from '@angular/core';
import {RestCommunicatorService} from "../rest-communicator.service";
import {IPagedTitles} from "../entities/response/IPagedTitles";
import {Observable} from "rxjs";
import {ITitle} from "../entities/response/ITitle";
import {ILinks} from "../entities/response/ILinks";

@Component({
  selector: 'app-news-dashboard',
  templateUrl: './news-dashboard.component.html',
  styleUrls: ['./news-dashboard.component.css']
})
export class NewsDashboardComponent implements OnInit
{
  titles: Observable<IPagedTitles> | undefined
  entityModels: ITitle[] = []
  links: ILinks | undefined

  constructor(
    private service: RestCommunicatorService
  )
  {
  }

  ngOnInit(): void
  {
    this.titles = this.service.getPagedTitles()
    this.titles.subscribe(titles =>
    {
      this.entityModels.push(...titles.entityModels);
      console.log(titles)
      this.links = titles._links
    })
  }

  loadMore(): void
  {
    this.titles = this.service.getPagedTitlesFromLink(this.links?.nextPage.href!)
    this.titles.subscribe(titles =>
    {
      this.entityModels.push(...titles.entityModels);
      console.log(titles)
      this.links = titles._links
    })
  }

}
