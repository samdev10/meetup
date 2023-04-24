import { createSlice } from '@reduxjs/toolkit'


export const eventSlice = createSlice({
  name: 'eventGroup',
  initialState: {
    events: []
  },
  reducers: {
    addEvents: (state, action) => {
      state.events = action.payload.events;
    }
  },
})

// Action creators are generated for each case reducer function
export const { addEvents } = eventSlice.actions;

export default eventSlice.reducer;
