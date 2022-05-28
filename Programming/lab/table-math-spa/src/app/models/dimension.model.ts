import {Dictionary} from '@ngrx/entity';

export interface DimensionModel
{
  value: number | null,
  dimensions: Dictionary<DimensionModel> | null,
  parameterName: string | null,
}
