import {EntityState} from "@ngrx/entity";
import {ParameterModel} from "../../models/parameter.model";

export interface TableState
{
  polish: string,
  parameters: EntityState<ParameterModel>,
  result: number | undefined
}

export const tableInitialState: TableState = {
  polish: '',
  parameters: {
    ids: [],
    entities: {}
  },
  result: undefined
}
