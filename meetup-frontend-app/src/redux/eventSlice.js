import { createSlice } from '@reduxjs/toolkit'


export const eventSlice = createSlice({
  name: 'eventGroup',
  initialState: {
    events: []
  },
  reducers: {
    addEvents: (state, action) => {
      state.events = action.payload.events;
    },
    addEvent: (state, action) => {
      state.events = [...state.events , action.payload.event];
    }
  },
})

// Action creators are generated for each case reducer function
export const { addEvents, addEvent } = eventSlice.actions;

export default eventSlice.reducer;
