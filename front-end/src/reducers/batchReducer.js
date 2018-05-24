const initialState = {
    batches: [],
    branches: [],
    addbatch:null,
    loading: false,
    error: false
};

export default function (state = initialState, action) {
    switch (action.type) {             
      case "LOADING_BATCH": {
        return {...state, loading : true, error : false,}
      }      
      case "GET_BATCHES": {
        return {...state, loading : false, batches : action.payload,}
      }            
      case "FAILED_BATCH": {
        return {...state, loading : false, error : action.payload.error,}
      }
      case "ADD_BATCH": {
        return {...state, loading : false, addbatch : action.payload,}
      }
      case "GET_BRANCHES": {
        return {...state, loading : false, branches : action.payload,}
      }
          
    }
    return state
}