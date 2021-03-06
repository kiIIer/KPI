import {EntityState} from '@ngrx/entity';
import {ParameterModel} from '../../models/parameter.model';
import {DimensionModel} from '../../models/dimension.model';
import {ErrorModel} from '../../models/Error.model';

export interface TableState
{
  polish: string,
  parameters: EntityState<ParameterModel>,
  result: DimensionModel | undefined,
  errors: ErrorModel | undefined
}

export const tableInitialState: TableState = {
  polish: '+ 2 a',
  parameters: {
    ids: ['a'],
    entities: {
      ['a']: {
        name: 'a',
        lowBound: 0,
        highBound: 10,
        step: 1,
      },
    },
  },
  result: undefined,
  errors: undefined,
};
