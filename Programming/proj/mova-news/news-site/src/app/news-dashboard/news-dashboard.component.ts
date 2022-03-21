import {Component, OnInit} from '@angular/core';
import {RestCommunicatorService} from "../rest-communicator.service";
import {IPagedTitles} from "../entities/response/IPagedTitles";
import {Observable} from "rxjs";

@Component({
  selector: 'app-news-dashboard',
  templateUrl: './news-dashboard.component.html',
  styleUrls: ['./news-dashboard.component.css']
})
export class NewsDashboardComponent implements OnInit
{
  titles: Observable<IPagedTitles> | undefined;

  constructor(
    private service: RestCommunicatorService
  )
  {
  }

  ngOnInit(): void
  {
    this.titles = this.service.getPagedTitles()
  }

}
