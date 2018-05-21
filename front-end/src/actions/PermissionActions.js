import axios from 'axios';
import { URL, TOKEN } from './ActionTypes';

export const getPermissions = () => {
    return dispatch => {
        dispatch({type: "GETPERM_LOADING"});
        axios.get(`${URL}/permissions`, {
            headers: {"Authorization": `${TOKEN}`}
        })
            .then( response => {
               dispatch({type: "GETPERM_SUCCESS", payload: response.data})
            } )
            .catch( error => {
                dispatch({type: "GETPERM_FAILED", payload: error})
            } );
    };
};

export const addPermission = (values, history) => {
    return dispatch => {
        dispatch({type: "GETPERM_LOADING"});
        axios.post(`${URL}/batch`,values, {
            headers: {"Authorization": `${TOKEN}`}
        })
            .then( response => {
               dispatch({type: "ADDPERM_SUCCESS"})
               history.push('/batch');
            } )
            .catch( error => {
                dispatch({type: "GETPERM_FAILED", payload: error})
            } );
    };
};