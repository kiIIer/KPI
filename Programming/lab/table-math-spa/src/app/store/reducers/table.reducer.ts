import {createReducer, on} from "@ngrx/store";
import {tableInitialState, TableState} from "../state/table.state";
import {addParameter} from "../actions/table.actions";

export const tableReducer = createReducer(
  tableInitialState,
  on(addParameter, (state: TableState) =>
  {
    return state;
  })
)
