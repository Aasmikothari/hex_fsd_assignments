// src/store/reducers/MedicalRecordReducer.js
const initialState = {
  records: [],
};

const MedicalRecordReducer = (state = initialState, action) => {
  console.log("In MedicalRecordReducer...");
  console.log(action);

  if (action.type === "FETCH_DOCTOR_MEDICAL_RECORDS") {
    return {
      ...state,
      records: action.payload,
    };
  }

  return state;
};

export default MedicalRecordReducer;