export const AUTHENTICATED = 'authenticated_user';
export const UNAUTHENTICATED = 'unauthenticated_user';
export const AUTHENTICATION_ERROR = 'authentication_error';

export const URL = 'http://localhost:8007';
export const USER = localStorage.getItem('user');
export const TOKEN =  `Bearer ` + localStorage.getItem('user');