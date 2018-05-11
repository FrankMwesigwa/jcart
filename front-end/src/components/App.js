import React, { Component } from 'react';
import {Switch, Route, Redirect } from 'react-router-dom';

import Header from './layout/Header';
import SideBar from './layout/SideBar';
import Dashboard from './layout/Dashboard';

class App extends Component {

  render() {
    return (
      <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">
          <Header />
          <aside class="main-sidebar">
            <SideBar />
          </aside>

          <div class="content-wrapper">
            <Switch>
              <Route exact path="/home"  component={Dashboard}/>
              <Redirect from="/" to="/home"/>
            </Switch>
          </div>
    
          <footer class="main-footer">
            <div class="pull-right hidden-xs">
              <b>Version</b> 1.1.0
            </div>
              <strong>Copyright &copy; 2018 <a href="">Housing Finance Bank</a>.</strong> All rights reserved.
          </footer> 
 
        </div>
      </body>
      
    );
  }
}

export default App;


