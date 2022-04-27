import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatCardModule} from "@angular/material/card";
import {TableCoreComponent} from './containers/table-core/table-core.component';
import {TableComponent} from './components/table/table.component';
import {MatFormFieldModule} from "@angular/material/form-field";
import {ReactiveFormsModule} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";
import {StoreModule} from "@ngrx/store";
import {tableReducer} from "./store/reducers/table.reducer";
import {EffectsModule} from "@ngrx/effects";
import {TableEffects} from "./store/effects/table.effects";
import {StoreDevtools, StoreDevtoolsModule} from "@ngrx/store-devtools";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    TableCoreComponent,
    TableComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    StoreModule.forRoot({
      table: tableReducer,
    }),
    EffectsModule.forRoot([TableEffects]),
    StoreDevtoolsModule.instrument(),
    MatCardModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatInputModule,
    MatButtonModule,
    MatIconModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule
{
}
