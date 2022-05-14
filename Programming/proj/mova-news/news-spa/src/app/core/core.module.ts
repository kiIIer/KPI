import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {DashboardComponent} from './components/dashboard/dashboard.component';
import {DashboardCoreComponent} from "./container/dashboard-core/dashboard-core.component";
import {HttpClientModule} from "@angular/common/http";
import {MatCardModule} from "@angular/material/card";
import {MatButtonModule} from "@angular/material/button";
import {MatProgressSpinnerModule} from "@angular/material/progress-spinner";
import {DetailsComponent} from "./components/details/details.component";
import {RouterModule} from "@angular/router";
import {MatTabsModule} from "@angular/material/tabs";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatIconModule} from "@angular/material/icon";
import {MatProgressBarModule} from "@angular/material/progress-bar";
import {DetailsCoreComponent} from "./container/details-core/details-core.component";
import {MatMenuModule} from "@angular/material/menu";
import {MatToolbarModule} from "@angular/material/toolbar";
import { EditorCoreComponent } from './container/editor-core/editor-core.component';
import { EditorComponent } from './components/editor/editor.component';
import {ReactiveFormsModule} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import { NotFoundComponent } from './components/not-found/not-found.component';
import { ToolbarCoreComponent } from './container/toolbar-core/toolbar-core.component';
import { ToolbarComponent } from './components/toolbar/toolbar.component';
import { SearchCoreComponent } from './container/search-core/search-core.component';


@NgModule({
  declarations: [
    DashboardComponent,
    DashboardCoreComponent,
    DetailsComponent,
    DetailsCoreComponent,
    EditorCoreComponent,
    EditorComponent,
    NotFoundComponent,
    ToolbarCoreComponent,
    ToolbarComponent,
    SearchCoreComponent,
  ],
  exports: [DashboardCoreComponent, ToolbarCoreComponent, ToolbarComponent],
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
    MatProgressBarModule,
    MatMenuModule,
    MatToolbarModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
  ],
})
export class CoreModule {}
