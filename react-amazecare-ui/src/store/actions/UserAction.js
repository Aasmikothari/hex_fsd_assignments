//src/store/actions/UserAction.js

export const setUserDetails = (dispatch) => (user) => {

    dispatch({
        'payload' : user,
        'type' : 'SET_USER_DETAILS'
    })

}

export const deleteUserDetails = (dispatch) => {
    dispatch({
        'payload': "",
        'type': 'DELETE_USER_DETAILS'
    })
}

/**
 * user = {
 *      username: "severus@gmail.com",
 *      role: "AUTHOR"
 * }
 * 
 * const dispatch = useDispatch(); 
 * setUserDetails(dispatch)(user)
 *                -> creating a hook in a component 
 *                   saving it in a variable and then calling it
 * 
 * this gets attached to action variable=>
 * 
 * {
 *      'payload' : user,
 *      'type' : 'SET_USER_DETAILS'
 * }
 *       
 */