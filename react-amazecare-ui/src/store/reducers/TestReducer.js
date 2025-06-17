//src/store/reducers/TestReducer.js
const initialState = {
  tests: [],
};

const TestReducer = (state = initialState, action) => {
  console.log("In TestReducer...");
  console.log(action);

  if (action.type === "FETCH_ALL_TESTS") {
    return {
      ...state,
      tests: action.payload,
    };
  }

  return state;
};

export default TestReducer;