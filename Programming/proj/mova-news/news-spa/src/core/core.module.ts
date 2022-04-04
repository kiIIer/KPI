import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {DashboardComponent} from './components/dashboard/dashboard.component';
import {DashboardCoreComponent} from "./container/dashboard-core/dashboard-core.component";
import {HttpClientModule} from "@angular/common/http";
import {MatCardModule} from "@angular/material/card";
import {MatButtonModule} from "@angular/material/button";
import {MatProgressSpinnerModule} from "@angular/material/progress-spinner";
import {AppModule} from "../app/app.module";
import {DetailsComponent} from "./components/details/details.component";
import {RouterModule} from "@angular/router";
import {MatTabsModule} from "@angular/material/tabs";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatIconModule} from "@angular/material/icon";
import {MatProgressBarModule} from "@angular/material/progress-bar";
import {DetailsCoreComponent} from "./container/details-core/details-core.component";


@NgModule({
  declarations: [
    DashboardComponent,
    DashboardCoreComponent,
    DetailsComponent,
    DetailsCoreComponent
  ],
  exports: [
    DashboardCoreComponent,
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    MatCardModule,
    MatButtonModule,
    MatProgressSpinnerModule,
    RouterModule,
    MatTabsModule,
    BrowserAnimationsModule,
    MatIconModule,
    MatProgressBarModule
  ]
})
export class CoreModule
{
}
