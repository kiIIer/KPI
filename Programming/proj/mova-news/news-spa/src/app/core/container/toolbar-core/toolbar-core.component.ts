import { Component, OnInit } from '@angular/core';
import { AppState } from '../../store/state/app.state';
import { Store } from '@ngrx/store';
import { asyncScheduler, Observable, scheduled } from 'rxjs';
import {
  selectIsLogined,
  selectUserName,
} from '../../store/selectors/user.selector';
import { go } from '../../store/actions/router.actions';
import { logIn, logOut } from '../../store/actions/user.actions';

@Component({
  selector: 'app-toolbar-core',
  templateUrl: './toolbar-core.component.html',
  styleUrls: ['./toolbar-core.component.css'],
})
export class ToolbarCoreComponent implements OnInit {
  userName$: Observable<string | undefined> = scheduled([], asyncScheduler);
  isLogined$: Observable<boolean> = scheduled([], asyncScheduler);

  constructor(private store: Store<AppState>) {}

  ngOnInit(): void {
    this.userName$ = this.store.select(selectUserName);
    this.isLogined$ = this.store.select(selectIsLogined);
  }

  onGoHome() {
    this.store.dispatch(go({ url: '/dashboard' }));
  }

  onLogIn() {
    this.store.dispatch(logIn());
  }

  onLogOut() {
    this.store.dispatch(logOut());
  }

  onSearch(q: string) {
    console.log(q);
  }
}
