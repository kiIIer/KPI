import {createAction, props} from '@ngrx/store';
import {CalculateRequestModel} from '../../models/calculateRequest.model';
import {DimensionModel} from '../../models/dimension.model';
import {ErrorModel} from '../../models/Error.model';
import {ParameterModel} from '../../models/parameter.model';

export const loadResult = createAction('[Table] Load Result', props<{ request: CalculateRequestModel }>());
export const loadResultSuccesses = createAction('[Table] Load Result Successes', props<{ dimension: DimensionModel }>());
export const loadResultFail = createAction('[Table] Load Result Fail', props<{ error: ErrorModel }>());

export const addParameter = createAction('[Table] Add Parameter', props<{ paramName: string, params: ParameterModel[] }>());
export const removeParameter = createAction('[Table] Remove Parameter', props<{ paramName: string, params: ParameterModel[] }>());
