import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {NewsDashboardComponent} from "./news-dashboard/news-dashboard.component";
import {NewsDetailsComponent} from "./news-details/news-details.component";
import {NewsCreatorComponent} from "./news-creator/news-creator.component";


const routes: Routes = [
  {path: '', redirectTo: '/dashboard', pathMatch: 'full'},
  {path: 'dashboard', component: NewsDashboardComponent},
  {path: 'details/:id', component: NewsDetailsComponent},
  {path: 'creator', component: NewsCreatorComponent}
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule],
})
export class AppRoutingModule
{
}
