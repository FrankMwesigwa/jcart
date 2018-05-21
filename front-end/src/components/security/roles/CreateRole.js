import React, {Component} from 'react';
import {Field, reduxForm} from 'redux-form';
import Multiselect from 'react-widgets/lib/Multiselect'
import 'react-widgets/dist/css/react-widgets.css'

import {connect} from 'react-redux'
import { addRole , getPermissions } from '../../../actions/RolesActions';

class CreateRole extends Component {

  constructor(props) {
    super(props);
    this.state = {
      permissions: []
    };
  }

  submit = (values) => {
    this.props.dispatch(addRole(values, this.props.history));
}

componentDidMount() {
  this.props.dispatch(getPermissions());
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
    const {handleSubmit, loading, errorMessage , permissions } = this.props;
    
    if (errorMessage) {
      return <div className="error-message">
          <p>Error! {errorMessage}</p>
      </div>;
    }

  if (loading) {
      return <div className="info-message">
          <p>Loading...</p>
      </div>;
    }
    return (
      <div>

    <section class="content-header">
      <h1>Roles Management</h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> security</a></li>
        <li class="active">roles</li>
      </ol>
    </section>

  <section class="content container-fluid">
  <div class="box box-warning">
                <div class="box-header with-border">
                  <h3 class="box-title">Create New Role</h3>
                </div>
                <div class="box-body">
                <form onSubmit={handleSubmit(this.submit.bind(this))}>

                    <div class="form-group">
                      <label>Name</label>
                      <Field name="name" component="input" type="text" placeholder="Enter Role Name" class="form-control"/>
                      
                    </div>
                    
                    <div class="form-group">
                      <label>Description</label>
                      <Field name="description" component="input" type="textarea" placeholder="Enter Role Description" class="form-control"/>
                    </div>
					
					<div class="form-group">
						<label>Permissions</label>
						<div>
              <select multiple className="form-control" name="permissions">
                  {permissions.map(perm => <option value={perm} key={perm}>{perm}</option>)}
              </select>
						</div>
						
    				</div>
    				
					<div class="box-footer">
	                    <button type="submit" class="btn btn-primary">Submit</button>
	                </div>
                  </form>
                </div>
              </div>

  </section>
</div>
    )
  }
}

const mapStateToProps = state => {
  return {
    loading: state.role.loading,
    permissions: state.role.permissions,
    errorMessage: state.role.error,
    addRole: state.role.addrole
    };
}

const reduxFormRole = reduxForm({form: 'newRole'})(CreateRole);
export default connect(mapStateToProps)(reduxFormRole);