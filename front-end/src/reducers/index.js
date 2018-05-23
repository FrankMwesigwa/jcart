import { combineReducers } from 'redux';
import { routerReducer } from 'react-router-redux'
import { reducer as FormReducer } from 'redux-form';
import AuthReducer from './authReducer';
import RolesReducer from './rolesReducer';
import PermissionReducer from './permissionReducer';
import rolesReducer from './rolesReducer';
import batchReducer from './batchReducer';

const rootReducer = combineReducers({
    form: FormReducer,
    auth: AuthReducer,
    permission: PermissionReducer,
    role: rolesReducer,
    batch: batchReducer

});

export default rootReducer;