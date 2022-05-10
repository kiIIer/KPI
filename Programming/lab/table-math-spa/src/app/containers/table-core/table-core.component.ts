import {Component, OnInit} from '@angular/core';
import {Store} from '@ngrx/store';
import {asyncScheduler, map, Observable, scheduled, tap} from 'rxjs';
import {ControlsConfigModel} from '../../models/controlsConfig.model';
import {getError, getParameterFormConfigsMap, getResult} from '../../store/selectors/table.selector';
import {AppState} from '../../store/state/app.state';
import {FormBuilder, FormGroup} from '@angular/forms';
import {addParameter, loadResult, removeParameter} from '../../store/actions/table.actions';
import {CalculateRequestModel} from '../../models/calculateRequest.model';
import {ErrorModel} from '../../models/Error.model';
import {DimensionModel} from '../../models/dimension.model';
import {TreeNodeModel} from '../../models/TreeNode.model';

@Component({
  selector: 'app-table-core',
  templateUrl: './table-core.component.html',
  styleUrls: ['./table-core.component.css'],
})
export class TableCoreComponent implements OnInit
{
  configs$: Observable<Map<string, FormGroup>> = scheduled([], asyncScheduler);
  error$: Observable<ErrorModel | undefined> = scheduled([], asyncScheduler);
  result$: Observable<TreeNodeModel | null | undefined> = scheduled([], asyncScheduler);

  constructor(
    private store: Store<AppState>,
    private formBuilder: FormBuilder,
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
        },
      ),
      tap((a) => console.log(a)),
    );
    this.error$ = this.store.select(getError);
    this.result$ = this.store.select(getResult).pipe(
      map((dimension: DimensionModel | undefined) =>
      {
        console.log(dimension);
        let children: TreeNodeModel[] = [];
        if (!!dimension)
        {
          for (let key in dimension!.dimensions)
          {
            children.push(this.createNode(dimension!.dimensions[key]!, key as unknown as number, dimension!.parameterName!));
          }
        }

        console.log(children);
        return {name: 'result', children: children};
      }),
    );
  }

  createNode(dimension: DimensionModel, value: number, name: string): TreeNodeModel
  {
    let children: TreeNodeModel[] = [];
    for (let key in dimension.dimensions)
    {
      children.push(this.createNode(dimension.dimensions[key]!, key as unknown as number, dimension!.parameterName!));
    }

    if (!dimension.dimensions)
    {
      children.push({name: dimension.value!, children: null});
    }

    return {
      name: `${name}: ${value}`,
      children: children,
    };
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
