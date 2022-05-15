import { RouterEffects } from './router.effects';
import { StoriesEffects } from './stories.effects';
import { ErrorsEffects } from './errors.effects';
import {AuthenticationEffects} from './authentication.effects';

export const effects = [RouterEffects, StoriesEffects, ErrorsEffects, AuthenticationEffects];
