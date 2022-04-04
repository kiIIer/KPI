import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {StoreDevtoolsModule} from '@ngrx/store-devtools';


import {AppComponent} from './app.component';
import {StoreModule} from "@ngrx/store";
import {routerReducer, StoreRouterConnectingModule} from "@ngrx/router-store";
import {RouterModule} from "@angular/router";
import {storiesReducer} from "../core/store";
import {CoreModule} from "../core/core.module";
import {EffectsModule} from "@ngrx/effects";
import {StoriesEffects} from "../core/store/effects/stories.effects";
import {DetailsComponent} from '../core/components/details/details.component';
import {DashboardComponent} from "../core/components/dashboard/dashboard.component";
import {DashboardCoreComponent} from "../core/container/dashboard-core/dashboard-core.component";
import {userReducer} from "../core/store/reducers/user.reducer";
import {RouterEffects} from "../core/store/effects/router.effects";
import {DetailsCoreComponent} from '../core/container/details-core/details-core.component';
import {StoriesGuard} from "../core/guards/stories.guard";
import {StoryGuard} from "../core/guards/story.guard";

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    StoreModule.forRoot({
      stories: storiesReducer,
      router: routerReducer,
      user: userReducer,
    }),
    RouterModule.forRoot([
      {path: '', redirectTo: '/dashboard', pathMatch: 'full'},
      {path: 'dashboard', component: DashboardCoreComponent, canActivate: [StoriesGuard]},
      {path: 'details/:id', component: DetailsCoreComponent, canActivate: [StoryGuard]},
    ]),
    StoreRouterConnectingModule.forRoot(),
    EffectsModule.forRoot([StoriesEffects, RouterEffects]),
    StoreDevtoolsModule.instrument(),
    CoreModule,
  ],
  providers: [],
  exports: [],
  bootstrap: [AppComponent]
})
export class AppModule
{
}
