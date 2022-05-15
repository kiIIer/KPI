import { Component, OnInit } from '@angular/core';
import { checkAuth } from './core/store/actions/auth.actions';
import { Store } from '@ngrx/store';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  title = 'news-spa';

  ngOnInit(): void {
    this.store.dispatch(checkAuth());
  }

  constructor(private store: Store) {}
}
