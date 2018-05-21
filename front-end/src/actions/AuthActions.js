import axios from 'axios'
import {AUTHENTICATED, UNAUTHENTICATED, AUTHENTICATION_ERROR, URL} from './ActionTypes';

export const  logInAction = ({email,password}, history) => {
  return async(dispatch) => {
    try {
      const res = await axios.post(`${URL}/auth/login`, {email, password});

      dispatch({type: AUTHENTICATED});
      localStorage.setItem('user', res.data.token);
      history.go('/');
    } catch (error) {
      dispatch({
        type: AUTHENTICATION_ERROR,
        payload: 'Problem with: ' + error
      });
    }
  };
}

export const logOutAction = () => {
  localStorage.clear();
  return {type: UNAUTHENTICATED};

}
