import React, {Component} from 'react';
import { connect } from 'react-redux'
import {Field, reduxForm} from 'redux-form';
import {logInAction} from '../../../actions/AuthActions'

class Login extends Component {

  submit = (values) => {
    this.props.dispatch(logInAction(values, this.props.history));
  }

  errorMessage() {
    if (this.props.errorMessage) {
      return (
        <div className="error-message">
          <p>{this.props.errorMessage}</p>
        </div>
      );
    }
  }

  render() {
    const {handleSubmit} = this.props;
    
    return (
      <body class="hold-transition login-page">
      <div class="login-box">
      <div class="login-logo">
        <a href="#">JCart Admin</a>
      </div>
      <div class="login-box-body">
        <p class="login-box-msg">Sign in to start your session</p>
        
        <form onSubmit={handleSubmit(this.submit.bind(this))}>
        {this.errorMessage()}

          <div class="form-group has-feedback">
            <Field name="email" className="form-control" component="input" type="text" placeholder="Email"/>
            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
          </div>
          <div class="form-group has-feedback">
            <Field name="password" className="form-control" component="input" type="password" placeholder="Password"/>
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

const mapStateToProps = (state) => {
  return { 
    errorMessage: state.auth.error 
  };
}

const reduxFormLogin = reduxForm({form: 'login'})(Login);
export default connect(mapStateToProps)(reduxFormLogin);
