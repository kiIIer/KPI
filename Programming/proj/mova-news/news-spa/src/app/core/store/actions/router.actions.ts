import { createAction, props } from '@ngrx/store';
import { NavigationExtras } from '@angular/router';

export const go = createAction('[Router] Go', props<{ url: string }>());
export const goWithExtras = createAction(
  '[Router] Go With Extras',
  props<{ url: string; extras: NavigationExtras }>()
);
