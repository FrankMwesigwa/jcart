import React, { Component } from 'react';
import {Switch, Route, Redirect } from 'react-router-dom';

import Header from './layout/Header';
import SideBar from './layout/SideBar';
import Dashboard from './layout/Dashboard';

import PermissionList from './security/permissions/PermissionList';

import RolesList from './security/roles/RolesList';
import CreateRole from './security/roles/CreateRole';

import UsersList from './security/users/UsersList';
import CreateUser from './security/users/CreateUser';

import BatchList from './modules/batch/BatchList';
import AddBatch from './modules/batch/AddBatch';
import EditBatch from './modules/batch/EditBatch';

class App extends Component {

  render() {
    return (
      <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">
          <Header />
          <SideBar />
          
          <div class="content-wrapper">
            <Switch>
              <Route exact path="/home"  component={Dashboard}/>
              <Route exact path="/permissions"  component={PermissionList}/>
              <Route exact path="/roles/new"  component={CreateRole}/>
              <Route exact path="/users/new"  component={CreateUser}/>
              <Route exact path="/roles"  component={RolesList}/>
              <Route exact path="/users"  component={UsersList}/>
              <Route exact path="/batch"  component={BatchList}/>
              <Route exact path="/batch/new"  component={AddBatch}/>
              <Route exact path="/batch/:id"  component={EditBatch}/>
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


