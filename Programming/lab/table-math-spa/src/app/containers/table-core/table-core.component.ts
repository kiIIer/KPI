import {Component, OnInit} from '@angular/core';
import {TableState} from "../../store/state/table.state";
import {Store} from "@ngrx/store";
import {asyncScheduler, map, Observable, scheduled} from "rxjs";
import {ControlsConfigModel} from "../../models/controlsConfig.model";
import {getParameterFormConfigsMap} from "../../store/selectors/table.selector";
import {AppState} from "../../store/state/app.state";
import {FormBuilder, FormGroup} from "@angular/forms";
import {Dictionary} from "@ngrx/entity";

@Component({
  selector: 'app-table-core',
  templateUrl: './table-core.component.html',
  styleUrls: ['./table-core.component.css']
})
export class TableCoreComponent implements OnInit
{
  configs$: Observable<Map<string, FormGroup>> = scheduled([], asyncScheduler);

  constructor(
    private store: Store<AppState>,
    private formBuilder: FormBuilder
  )
  {
  }

  ngOnInit(): void
  {
    this.configs$ = this.store.select(getParameterFormConfigsMap).pipe(
      map((map: Map<string, ControlsConfigModel>) =>
        Object.assign({}, ...Array.from(map).map(
          ([name, value]) => [name, this.formBuilder.group(value)]
        ))
      )
    );
  }

  onAddParameter(paramName: string)
  {
    // this.store.dispatch(addParameter({paramName}));
  }

}
