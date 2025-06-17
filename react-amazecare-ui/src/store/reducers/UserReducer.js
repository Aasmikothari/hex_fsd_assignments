//src/store/reducers/UserReducer

const initialState={
    username: "",
    role: ""
}

const UserReducer = (state = initialState,action) => {

    if (action.type === "SET_USER_DETAILS"){ //for login
        let user = action.payload;
        return{
            ...state,
            username: user.username,
            role: user.role
        }
    }

    if (action.type === "DELETE_USER_DETAILS") {  //for logout
        return {
            ...state,
            username: "",
            role: ""
        }
    }

    return state;

}

export default UserReducer;

/**
 * reducer fn has 2 args : state & action
 * 
 * 1. state: to begin with state -> has username & role as ""
 * 
 *    state.username=""
 *    state.role=""
 * 
 * This state will go in the redux stire. So you will have an object like this:
 *  {
 *      username: "",
 *      role: ""
 *  }
 * 
 * 2. action: when the API will be called from action file,
 *    it will dispatch an object that comes and gets saved in this action variable.
 * 
 */