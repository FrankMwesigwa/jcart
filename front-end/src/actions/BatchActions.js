import axios from 'axios';
import { URL, TOKEN } from './ActionTypes';

export const getBatchList = () => {
    return dispatch => {
        dispatch({type: "LOADING_BATCH"});
        axios.get(`${URL}/batch`, {
            headers: {"Authorization": `${TOKEN}`}
        })
            .then( response => {
               dispatch({type: "GET_BATCHES", payload: response.data})
            } )
            .catch( error => {
                dispatch({type: "FAILED_BATCH", payload: error})
            } );
    };
};

export const addBatch = (values, history) => {
    return dispatch => {
        dispatch({type: "LOADING_BATCH"});
        axios.post(`${URL}/batch`,values, {
            headers: {"Authorization": `${TOKEN}`}
        })
            .then( response => {
               dispatch({type: "ADD_BATCH"})
               history.push('/batch');
            } )
            .catch( error => {
                dispatch({type: "FAILED_BATCH", payload: error})
            } );
    };
};

export const getBranches = () => {
    return dispatch => {
        axios.get(`${URL}/batch/branches`, {
            headers: {"Authorization": `${TOKEN}`}
        })
            .then( response => {
               dispatch({type: "GET_BRANCHES", payload: response.data})
            } )
            .catch( error => {
                dispatch({type: "FAILED_BATCH", payload: error})
            } );
    };
};