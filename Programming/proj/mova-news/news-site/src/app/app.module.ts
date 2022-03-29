import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatIconModule} from "@angular/material/icon";
import {MatButtonModule} from "@angular/material/button";
import {ToolbarComponent} from './toolbar/toolbar.component';
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {MatTooltipModule} from "@angular/material/tooltip";
import {MatMenuModule} from "@angular/material/menu";
import {MatRadioModule} from "@angular/material/radio";
import {MatAutocompleteModule} from "@angular/material/autocomplete";
import {ReactiveFormsModule} from "@angular/forms";
import {AppRoutingModule} from './app-routing.module';
import {NewsDashboardComponent} from './news-dashboard/news-dashboard.component';
import {MatCardModule} from "@angular/material/card";
import {MatListModule} from "@angular/material/list";
import {NewsDetailsComponent} from './news-details/news-details.component';
import {RestCommunicatorService} from "./rest-communicator.service";
import {HttpClientModule} from "@angular/common/http";
import { NewsCreatorComponent } from './news-creator/news-creator.component';

@NgModule({
  declarations: [
    AppComponent,
    ToolbarComponent,
    NewsDashboardComponent,
    NewsDetailsComponent,
    NewsCreatorComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatTooltipModule,
    MatMenuModule,
    MatRadioModule,
    MatAutocompleteModule,
    ReactiveFormsModule,
    AppRoutingModule,
    MatCardModule,
    HttpClientModule,
    MatListModule,
  ],
  providers: [RestCommunicatorService],
  bootstrap: [AppComponent]
})
export class AppModule
{
}
