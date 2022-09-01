import { createSlice } from '@reduxjs/toolkit'


export const authSlice = createSlice({
  name: 'authUser',
  initialState: {
    authenticated: false,
    user: undefined,
    email: 'santhoshn1099@gmail.com'
  },
  reducers: {
    authenticateUser: (state, action) => {
      // Redux Toolkit allows us to write "mutating" logic in reducers. It
      // doesn't actually mutate the state because it uses the Immer library,
      // which detects changes to a "draft state" and produces a brand new
      // immutable state based off those changes
      state.authenticated = true;
      state.user = action.payload.user;
    },
    addEmail: (state, action) => {
      state.email = action.payload.email;
    }
  },
})

// Action creators are generated for each case reducer function
export const { authenticateUser, addEmail } = authSlice.actions

export default authSlice.reducer
