import {createAction, props} from "@ngrx/store";

export const go = createAction('[Router] Go', props<{ url: string }>());
