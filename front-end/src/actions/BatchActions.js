import axios from 'axios';
import { URL, TOKEN } from './ActionTypes';

export const getBatchList = () => {
    return dispatch => {
        dispatch({type: "GETBATCHES_LOADING"});
        axios.get(`${URL}/api/batch`, {
            headers: {"Authorization": `${TOKEN}`}
        })
            .then( response => {
               dispatch({type: "GETBATCHES_SUCCESS", payload: response.data})
            } )
            .catch( error => {
                dispatch({type: "GETBATCHES_FAILED", payload: error})
            } );
    };
};