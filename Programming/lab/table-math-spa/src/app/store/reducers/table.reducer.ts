import {createReducer, on} from '@ngrx/store';
import {tableInitialState, TableState} from '../state/table.state';
import {addParameter, loadResultFail, loadResultSuccesses, removeParameter} from '../actions/table.actions';
import {ParameterModel} from '../../models/parameter.model';

export const tableReducer = createReducer(
  tableInitialState,
  on(addParameter, (state: TableState, {paramName, params}) =>
    ({
      ...state,
      parameters: {
        ...state.parameters,
        ids: [
          ...(state.parameters.ids as string[]),
          paramName,
        ],
        entities: Object.assign(Object.assign({}, ...params.map(
          (param: ParameterModel) => ({[param.name]: param}),
        )), {[paramName]: {}}),
      },
    }),
  ),
  on(removeParameter, (state: TableState, {paramName, params}) =>
    ({
      ...state,
      parameters: {
        ...state.parameters,
        ids: (state.parameters.ids as string[]).filter((existingParamNames: string) => existingParamNames != paramName),
        entities: Object.assign(
          {},
          ...params
            .filter((param: ParameterModel) => param.name != paramName)
            .map((param: ParameterModel) => ({
              [param.name]: {...param},
            })),
        ),
      },
    }),
  ),
  on(loadResultSuccesses, (state: TableState, {dimension}) => ({
    ...state,
    result: dimension,
  })),
  on(loadResultFail, (state: TableState, {error}) => ({
    ...state,
    errors: error,
  })),
);
