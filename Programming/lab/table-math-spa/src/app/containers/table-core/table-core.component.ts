import {Component, OnInit} from '@angular/core';
import {TableState} from "../../store/state/table.state";
import {Store} from "@ngrx/store";
import {asyncScheduler, map, Observable, scheduled, tap} from "rxjs";
import {ControlsConfigModel} from "../../models/controlsConfig.model";
import {getParameterFormConfigsMap} from "../../store/selectors/table.selector";
import {AppState} from "../../store/state/app.state";
import {FormBuilder, FormGroup} from "@angular/forms";
import {Dictionary} from "@ngrx/entity";
import {addParameter, loadResult, removeParameter} from "../../store/actions/table.actions";
import {CalculateRequestModel} from "../../models/calculateRequest.model";

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
        {
          let newMap: Map<string, FormGroup> = new Map<string, FormGroup>();
          for (let entry of Object.entries(map))
          {
            let group = this.formBuilder.group(entry[1]);
            newMap.set(entry[0], group);
          }
          return newMap;
        }
      ),
      tap((a) => console.log(a)),
    );
  }

  onAddParameter(paramName: string)
  {
    this.store.dispatch(addParameter({paramName}));
  }

  onDeleteParameter(paramName: string)
  {
    this.store.dispatch(removeParameter({paramName}));
  }

  onLoadResult(request: CalculateRequestModel)
  {
    this.store.dispatch(loadResult({request}));
  }

}
