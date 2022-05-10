import {createSelector} from '@ngrx/store';
import {getTableState} from './app.selector';
import {TableState} from '../state/table.state';
import {FormGroup, Validators} from '@angular/forms';
import {Dictionary, EntityState} from '@ngrx/entity';
import {ParameterModel} from '../../models/parameter.model';
import {state} from '@angular/animations';
import {ControlsConfigModel} from '../../models/controlsConfig.model';


export const getEntityState = createSelector(
  getTableState,
  (state: TableState) =>
  {
    console.log({state});
    return state.parameters;
  },
);

export const getParameterMap = createSelector(
  getEntityState,
  (state: EntityState<ParameterModel>) => state.entities,
);

export const getParameterFormConfigsMap = createSelector(
  getParameterMap,
  (state: Dictionary<ParameterModel>) =>
  {
    let configs: Map<string, ControlsConfigModel> = new Map<string, ControlsConfigModel>();

    for (const name of Object.keys(state))
    {
      let parameter: ParameterModel = state[name]!;

      configs = {
        ...configs,
        [name]: {
          ['name']: [name, [Validators.required]],
          ['lowBound']: [parameter.lowBound, [Validators.required, Validators.pattern('^[0-9]+\\.?[0-9]*$')]],
          ['highBound']: [parameter.highBound, [Validators.required, Validators.pattern('^[0-9]+\\.?[0-9]*$')]],
          ['step']: [parameter.step, [Validators.required, Validators.pattern('^[0-9]+\\.?[0-9]*$')]],
        },
      };
    }
    console.log(configs);
    return configs;
  },
);


export const getError = createSelector(getTableState, (state: TableState) => state.errors);
export const getResult = createSelector(getTableState, (state: TableState) => state.result);
