const initialState = {
    permissions: [],
    addperm:null,
    loading: false,
    error: false
};

export default function (state = initialState, action) {
    switch (action.type) {             
      case "GETPERM_LOADING": {
        return {...state, loading : true, error : false,}
      }      
      case "GETPERM_SUCCESS": {
        return {...state, loading : false, permissions : action.payload,}
      }            
      case "GETPERM_FAILED": {
        return {...state, loading : false, error : action.payload.error,}
      }
      case "ADDPERM_SUCCESS": {
        return {...state, loading : false, addperm : action.payload,}
      }
          
    }
    return state
}