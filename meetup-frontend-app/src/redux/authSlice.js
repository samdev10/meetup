import { createSlice } from '@reduxjs/toolkit'


export const authSlice = createSlice({
  name: 'authUser',
  initialState: {
    authenticated: false,
    user: undefined,
    email: 'santhoshn1099@gmail.com',
  },
  reducers: {
    authenticateUser: (state, action) => {
      // Redux Toolkit allows us to write "mutating" logic in reducers. It
      // doesn't actually mutate the state because it uses the Immer library,
      // which detects changes to a "draft state" and produces a brand new
      // immutable state based off those changes
      const res = action.payload;
      state.authenticated = true;
      state.user = { email: res.username, firstname: undefined, lastname: undefined, id: undefined };
      state.email = res.username;
      console.log(res);

      //get token from response
      const token  =  res.token;

      //set JWT token to local
       localStorage.setItem("token", token);
    },
    addEmail: (state, action) => {
      state.email = action.payload.email;
    }
  },
})

// Action creators are generated for each case reducer function
export const { authenticateUser, addEmail } = authSlice.actions

export default authSlice.reducer
