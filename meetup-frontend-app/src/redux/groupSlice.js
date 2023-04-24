import { createSlice } from '@reduxjs/toolkit'


export const groupSlice = createSlice({
  name: 'userGroup',
  initialState: {
    groups: []
  },
  reducers: {
    addGroups: (state, action) => {
      state.groups = action.payload.groups;
    }
  },
})

// Action creators are generated for each case reducer function
export const { addGroups } = groupSlice.actions;

export default groupSlice.reducer;
