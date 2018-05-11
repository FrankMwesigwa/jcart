import React, {Component} from 'react';
import {Field, reduxForm} from 'redux-form';
import { connect } from 'react-redux'

class Login extends Component {


  render() {
    
    return (
      <body class="hold-transition login-page">
      <div class="login-box">
      <div class="login-logo">
        <a href="#">JCart Admin</a>
      </div>
      <div class="login-box-body">
        <p class="login-box-msg">Sign in to start your session</p>
        
        <form action="home" method="post">
          <div class="form-group has-feedback">
            <input type="email" class="form-control" name="username" placeholder="Email"/>
            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
          </div>
          <div class="form-group has-feedback">
            <input type="password" class="form-control" name="password" placeholder="Password"/>
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
          </div>
          <div class="row">
            <div class="form-group col-xs-offset-8 col-xs-4">
              <button type="submit" class="btn btn-primary btn-block btn-flat" >Log In</button>
            </div>
          </div>
        </form>
        
        <a href="forgotPwd" href="/forgotPwd" >I forgot my password</a><br/>
        
      </div>
    </div>
    </body>
    );
  }
}

const reduxFormLogin = reduxForm({form: 'login'})(Login);
export default connect(null)(reduxFormLogin);
