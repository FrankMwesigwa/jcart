import React, {Component} from 'react';
import {Field, reduxForm} from 'redux-form';
import Multiselect from 'react-widgets/lib/Multiselect'
import 'react-widgets/dist/css/react-widgets.css'

import {connect} from 'react-redux'
import { addBatch, getBranches } from '../../../actions/BatchActions';

class AddBatch extends Component {

  constructor(props) {
    super(props);
    this.state = {
        branches: []
    };
  }

  submit = (values) => {
    this.props.dispatch(addBatch(values, this.props.history));
}

componentDidMount() {
  this.props.dispatch(getBranches());
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
    const {handleSubmit, loading, errorMessage , branches } = this.props;
    
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
      <h1>User Batch Management</h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> batch</a></li>
        <li class="active">new batch</li>
      </ol>
    </section>

  <section class="content container-fluid">
  <div class="box box-warning">
                <div class="box-header with-border">
                  <h3 class="box-title">Create New Batch</h3>
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
						<label>Branches</label>
						<div>
                        <Field name="branch" component="select" class="form-control">
                            {branches.map(branch => <option value={branch.id} key={branch.id}>{branch.branchname}</option>)}
                        </Field>
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
    loading: state.batch.loading,
    branches: state.batch.branches,
    errorMessage: state.batch.error,
    addBatch: state.batch.addBatch
    };
}

const reduxFormBatch = reduxForm({form: 'newRole'})(AddBatch);
export default connect(mapStateToProps)(reduxFormBatch);