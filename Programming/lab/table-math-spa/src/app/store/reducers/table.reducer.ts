import {createReducer, on} from "@ngrx/store";
import {tableInitialState, TableState} from "../state/table.state";
import {addParameter, loadResultSuccesses, removeParameter} from "../actions/table.actions";

export const tableReducer = createReducer(
  tableInitialState,
  on(addParameter, (state: TableState, {paramName}) =>
    ({
      ...state,
      parameters: {
        ...state.parameters,
        ids: [
          ...(state.parameters.ids as string[]),
          paramName
        ],
        entities: Object.assign({...state.parameters.entities}, {
          [paramName]: {
            name: paramName,
            lowBound: 0,
            highBound: 1,
            step: 1
          }
        })
      }
    })
  ),
  on(removeParameter, (state: TableState, {paramName}) =>
    ({
      ...state,
      parameters: {
        ...state.parameters,
        ids: (state.parameters.ids as string[]).filter((existingParamNames: string) => existingParamNames != paramName),
        entities: Object.assign(
          {},
          ...Object.entries(state.parameters.entities)
            .filter(([key, value]) => key != paramName)
            .map(([key, value]) => ({
              [key]: value,
            }))
        ),
      }
    })
  ),
  on(loadResultSuccesses, (state: TableState, {dimension}) => ({
    ...state,
    result: dimension
  }))
)
