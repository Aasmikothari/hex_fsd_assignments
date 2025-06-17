// src/store/reducers/DoctorReducer.js
const initialState = {
  doctor: null,
};

const DoctorReducer = (state = initialState, action) => {
  if (action.type === "FETCH_DOCTOR_PROFILE") {
    return {
      ...state,
      doctor: action.payload,
    };
  }
  return state;
};

export default DoctorReducer;