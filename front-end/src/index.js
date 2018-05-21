import React from 'react';
import ReactDOM from 'react-dom';
import {Router, Switch, Route } from 'react-router-dom';
import { Provider } from 'react-redux';
import { createStore, applyMiddleware } from 'redux';
import reduxThunk from 'redux-thunk';
import createHistory from 'history/createBrowserHistory';
import { AUTHENTICATED, USER } from './actions/ActionTypes';

import reducers from './reducers/index';
import App from './components/App';
import Login from './components/security/auth/Login';
import Logout from './components/security/auth/Logout'
import UserAuthentication from './components/security/auth/UserAuthentication';
import NoUserAuthentication from './components/security/auth/NoUserAuthentication';

const history = createHistory();   

const createStoreWithMiddleware = applyMiddleware(reduxThunk)(createStore);
const store = createStoreWithMiddleware(reducers);

if (USER) {
    store.dispatch({ type: AUTHENTICATED });
}

ReactDOM.render(
    <Provider store={store}>
        <Router history={history}>
        <div>
                <Switch>
                    <Route exact path="/login" component={NoUserAuthentication(Login)}/>
                    <Route path="/logout" component={NoUserAuthentication(Logout)}/>
                    <Route path="/" component={UserAuthentication(App)} />
                </Switch>
            </div>    
        </Router>
    </Provider>, document.getElementById('root')
);

