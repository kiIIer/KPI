import {createAction, props} from "@ngrx/store";

export const loadResult = createAction('[Table] Load Result')
export const loadResultSuccesses = createAction('[Table] Load Result Successes')
export const loadResultFail = createAction('[Table] Load Result Fail')

export const addParameter = createAction('[Table] Add Parameter', props<{ paramName: string }>())
export const removeParameter = createAction('[Table] Remove Parameter')
