const initialState = {
    batches: [],
    addbatch:null,
    loading: false,
    error: false
};

export default function (state = initialState, action) {
    switch (action.type) {             
      case "GETBATCHES_LOADING": {
        return {...state, loading : true, error : false,}
      }      
      case "GETBATCHES_SUCCESS": {
        return {...state, loading : false, batches : action.payload,}
      }            
      case "GETBATCHES_FAILED": {
        return {...state, loading : false, error : action.payload.error,}
      }
      case "ADDBATCH_SUCCESS": {
        return {...state, loading : false, addbatch   : action.payload,}
      }
          
    }
    return state
}