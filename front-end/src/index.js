import React from 'react';
import ReactDOM from 'react-dom';
import {Router, Switch, Route } from 'react-router-dom';
import { Provider } from 'react-redux';
import { createStore, applyMiddleware } from 'redux';
import reduxThunk from 'redux-thunk';
import createHistory from 'history/createBrowserHistory';

import reducers from './reducers/index';
import App from './components/App';
import Login from './components/auth/Login';

const history = createHistory();   

const createStoreWithMiddleware = applyMiddleware(reduxThunk)(createStore);
const store = createStoreWithMiddleware(reducers);

ReactDOM.render(
    <Provider store={store}>
        <Router history={history}>
        <div>
                <Switch>
                    <Route exact path="/login" component={Login}/>
                    <Route path="/" component={App} />
                </Switch>
            </div>    
        </Router>
    </Provider>, document.getElementById('root')
);

