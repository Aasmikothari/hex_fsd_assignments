const initialState = {
  consultations: []
};

const ConsultationReducer = (state = initialState, action) => {
  console.log("In ConsultationReducer...", action);

  if (action.type === "FETCH_ALL_CONSULTATIONS") {
    return {
      ...state,
      consultations: action.payload
    };
  }

  return state;
};

export default ConsultationReducer;