import { createSlice } from "@reduxjs/toolkit";

export const sessionSlice = createSlice({
    name: 'session',
    initialState: {
      auth: false
    },
    reducers: {
        addAuth: (state, action) => {
          state.auth = action.payload.auth;
        }
    },
  })
  
  // Action creators are generated for each case reducer function
  export const { addAuth } = sessionSlice.actions;
  
  export default sessionSlice.reducer;