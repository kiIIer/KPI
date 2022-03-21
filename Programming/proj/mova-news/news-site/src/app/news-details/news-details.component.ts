import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {IArticle} from "../entities/IArticle";

@Component({
  selector: 'app-news-details',
  templateUrl: './news-details.component.html',
  styleUrls: ['./news-details.component.css']
})
export class NewsDetailsComponent implements OnInit
{
  id: any;
  article: IArticle

  constructor(
    private route: ActivatedRoute,
  )
  {
    this.article = {
      id: this.id,
      title: 'Ukrains victory',
      article: 'Today Russia signed capidfskljsdflkjsdfkljfjsdlkfjslkdfjlksdjflksdjflksdjflsdkflsdkkfjlskljdfskljdsfkljdfsssssssssssssssssssssssssssflksdjflsdjflksdjflksdjflksdjflksdfjdkfjaslkdfjasldkfjalsdhvoxjlcbnv eqwukvhgapsdjvnqelruoghasljvnqwo;ughasljvbnaeovherljvhadofihwerlvjah;ljvabdflobine  liuqerhvnakdhfvg;.f blaiuodjhlvn bdsvhlbh;viljnsb zdv kbfluovwdjlb .kbfuaovwjldnab .skbfvlhdbsaf dkvjlfoh;vlwjbas.dfklvdba .klfhvljwbaf.d klauhv;wiljbda.f kbflguhvjdbaf. sklufhvjabs.fdk tulation',
      dateCreated: BigInt(1)
    }

  }

  ngOnInit(): void
  {
    this.getArticle()
  }

  getArticle(): void
  {
    const id = this.route.snapshot.paramMap.get('id')
    this.id = id
  }

}
