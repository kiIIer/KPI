import { Component, OnInit } from '@angular/core';
import { AppState } from '../../store/state/app.state';
import { select, Store } from '@ngrx/store';
import { asyncScheduler, Observable, scheduled, tap } from 'rxjs';
import {
  selectCurrentUserProfile,
  selectIsLoggedIn,
} from '../../store/selectors/authentication.selector';
import { go, goWithExtras } from '../../store/actions/router.actions';
import { clearSearch, loadSearchStories, trySearch } from '../../store';
import { selectCurrentRoute } from '../../store/selectors/router.selector';
import { AuthService } from '@auth0/auth0-angular';
import { checkAuth, login, logout } from '../../store/actions/auth.actions';

@Component({
  selector: 'app-toolbar-core',
  templateUrl: './toolbar-core.component.html',
  styleUrls: ['./toolbar-core.component.css'],
})
export class ToolbarCoreComponent implements OnInit {
  userName$: Observable<string | undefined> = scheduled([], asyncScheduler);
  loggedIn$: Observable<boolean> = scheduled([], asyncScheduler);
  profile$: Observable<any> = scheduled([], asyncScheduler);

  constructor(private store: Store<AppState>) {}

  ngOnInit(): void {
    this.loggedIn$ = this.store.select(selectIsLoggedIn);
    this.profile$ = this.store.select(selectCurrentUserProfile);

  }

  onGoHome() {
    this.store.dispatch(go({ url: '/dashboard' }));
  }

  onLogIn() {
    this.store.dispatch(login());
  }

  onLogOut() {
    this.store.dispatch(logout());
  }

  onSearch(q: string) {
    this.store.dispatch(clearSearch());
    this.store.dispatch(trySearch({ q }));
  }
}
