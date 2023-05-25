import { createSlice } from "@reduxjs/toolkit";

export const genericModalSlice = createSlice({
  name: "genericModal",
  initialState: {
    showModal: false,
  },
  reducers: {
    closeModal: (state, action) => {
      state.showModal = false;
    },
    showModal: (state, action) => {
      state.showModal = true;
    },
  },
});

// Action creators are generated for each case reducer function
export const { closeModal, showModal } = genericModalSlice.actions;

export default genericModalSlice.reducer;
