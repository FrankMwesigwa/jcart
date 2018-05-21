const initialState = {
    roles: [],
    permissions: [],
    addrole:null,
    loading: false,
    error: false
};

export default function (state = initialState, action) {
    switch (action.type) {             
      case "GETROLES_LOADING": {
        return {...state, loading : true, error : false,}
      }      
      case "GETROLES_SUCCESS": {
        return {...state, loading : false, roles : action.payload,}
      }            
      case "GETROLES_FAILED": {
        return {...state, loading : false, error : action.payload.error,}
      }
      case "ADDROLES_SUCCESS": {
        return {...state, loading : false, addrole   : action.payload,}
      }
      case "GETPERMS_SUCCESS": {
        return {...state, loading : false, permissions   : action.payload,}
      }
          
    }
    return state
}