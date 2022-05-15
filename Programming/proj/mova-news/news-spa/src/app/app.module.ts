import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { StoreDevtoolsModule } from '@ngrx/store-devtools';

import { AppComponent } from './app.component';
import { StoreModule } from '@ngrx/store';
import { routerReducer, StoreRouterConnectingModule } from '@ngrx/router-store';
import { RouterModule } from '@angular/router';
import { storiesReducer } from './core/store';
import { CoreModule } from './core/core.module';
import { EffectsModule } from '@ngrx/effects';
import { StoriesEffects } from './core/store/effects/stories.effects';
import { DashboardCoreComponent } from './core/container/dashboard-core/dashboard-core.component';
import { authenticationReducer } from './core/store/reducers/authentication.reducer';
import { RouterEffects } from './core/store/effects/router.effects';
import { DetailsCoreComponent } from './core/container/details-core/details-core.component';
import { StoriesGuard } from './core/guards/stories.guard';
import { StoryGuard } from './core/guards/story.guard';
import { EditorCoreComponent } from './core/container/editor-core/editor-core.component';
import { effects } from './core/store/effects';
import { NotFoundComponent } from './core/components/not-found/not-found.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { AuthGuard } from './core/guards/auth.guard';
import { SearchCoreComponent } from './core/container/search-core/search-core.component';
import { SearchGuard } from './core/guards/search.guard';
import { AuthHttpInterceptor, AuthModule } from '@auth0/auth0-angular';
import { HTTP_INTERCEPTORS } from '@angular/common/http';

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    StoreModule.forRoot({
      stories: storiesReducer,
      router: routerReducer,
      authentication: authenticationReducer,
    }),
    RouterModule.forRoot([
      { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
      {
        path: 'dashboard',
        component: DashboardCoreComponent,
        canActivate: [StoriesGuard],
      },
      {
        path: 'search',
        component: SearchCoreComponent,
        canActivate: [SearchGuard],
      },
      {
        path: 'details/:id',
        component: DetailsCoreComponent,
        canActivate: [StoryGuard],
      },
      {
        path: 'editor/new',
        component: EditorCoreComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'editor/:id',
        component: EditorCoreComponent,
        canActivate: [StoryGuard, AuthGuard],
      },
      { path: 'not-found', component: NotFoundComponent },
    ]),
    AuthModule.forRoot({
      domain: 'k1ller.eu.auth0.com',
      clientId: 'NLsuYFOc1TxdzMasdlrygctbKkdtrLfG',
      redirectUri: window.location.origin,
      audience: 'http://localhost:8080/',
      scope: 'modify:stories',
      httpInterceptor: {
        allowedList: [
          {
            uri: 'http://localhost:8080/*',
            httpMethod: 'POST',
            tokenOptions: {
              audience: 'http://localhost:8080/',
              scope: 'modify:stories',
            },
          },
          {
            uri: 'http://localhost:8080/*',
            httpMethod: 'PATCH',
            tokenOptions: {
              audience: 'http://localhost:8080/',
              scope: 'modify:stories',
            },
          },
          {
            uri: 'http://localhost:8080/*',
            httpMethod: 'DELETE',
            tokenOptions: {
              audience: 'http://localhost:8080/',
              scope: 'modify:stories',
            },
          },
        ],
      },
    }),
    StoreRouterConnectingModule.forRoot(),
    EffectsModule.forRoot(effects),
    StoreDevtoolsModule.instrument(),
    CoreModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
  ],
  providers: [
    AuthHttpInterceptor,
    { provide: HTTP_INTERCEPTORS, useClass: AuthHttpInterceptor, multi: true },
  ],
  exports: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
