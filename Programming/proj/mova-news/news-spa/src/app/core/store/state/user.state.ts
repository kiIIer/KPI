export interface UserState {
  isAdmin: boolean;
  userName: string | undefined;
  isLogined: boolean;
}

export const initialUserState: UserState = {
  isAdmin: false,
  userName: undefined,
  isLogined: false,
};
