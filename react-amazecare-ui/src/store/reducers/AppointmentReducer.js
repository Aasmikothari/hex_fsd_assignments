const initialState = {
  upcoming: [],
  completed: []
};

const AppointmentReducer = (state = initialState, action) => {
  console.log("In AppointmentReducer...", action);

  if (action.type === "FETCH_UPCOMING_APPOINTMENTS") {
    return {
      ...state,
      upcoming: action.payload
    };
  }

  if (action.type === "FETCH_COMPLETED_APPOINTMENTS") {
    return {
      ...state,
      completed: action.payload
    };
  }

  return state;
};

export default AppointmentReducer;