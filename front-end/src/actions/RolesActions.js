import axios from 'axios';
import { URL, TOKEN } from './ActionTypes';

export const getRoles = () => {
    return dispatch => {
        dispatch({type: "GETROLES_LOADING"});
        axios.get(`${URL}/roles`, {
            headers: {"Authorization": `${TOKEN}`}
        })
            .then( response => {
               dispatch({type: "GETROLES_SUCCESS", payload: response.data})
            } )
            .catch( error => {
                dispatch({type: "GETROLES_FAILED", payload: error})
            } );
    };
};

export const getPermissions = () => {
    return dispatch => {
        axios.get(`${URL}/roles/perms`, {
            headers: {"Authorization": `${TOKEN}`}
        })
            .then( response => {
               dispatch({type: "GETPERMS_SUCCESS", payload: response.data})
            } )
            .catch( error => {
                dispatch({type: "GETROLES_FAILED", payload: error})
            } );
    };
};

export const addRole = (values, history) => {
    return dispatch => {
        dispatch({type: "GETROLES_LOADING"});
        axios.post(`${URL}/roles`,values, {
            headers: {"Authorization": `${TOKEN}`}
        })
            .then( response => {
               dispatch({type: "ADDROLES_SUCCESS"})
               history.push('/roles');
            } )
            .catch( error => {
                dispatch({type: "GETROLES_FAILED", payload: error})
            } );
    };
};