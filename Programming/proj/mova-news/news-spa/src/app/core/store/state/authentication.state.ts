import { User } from '@auth0/auth0-angular';

export interface AuthenticationState {
  isLoggedIn: boolean;
  isAdmin: boolean;
  userProfile: User | null;
}

export const initialAuthenticationState: AuthenticationState = {
  userProfile: null,
  isLoggedIn: false,
  isAdmin: false,
};
