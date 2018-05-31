import React, {Component} from 'react';
import {Field, FieldArray, reduxForm} from 'redux-form';
import {connect} from 'react-redux'
import { getBatch, getBranches, getStatus } from '../../../actions/BatchActions';

class EditBatch extends Component {

  constructor(props) {
    super(props);
    this.state = {
        branches: [],
        status: []
    };
  }

  submit = (values) => {
    this.props.dispatch(getBatch(values, this.props.history));
}

componentDidMount() {
  this.props.dispatch(getBranches());
  this.props.dispatch(getStatus());
  this.props.dispatch(getBatch());
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
    const {handleSubmit, pristine, reset, submitting ,loading, errorMessage , branches, status } = this.props;
    
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
                  <h3 class="box-title">Edit Batch Details</h3>
                </div>
                <div class="box-body">
                <form onSubmit={handleSubmit(this.submit.bind(this))}>

                    <div class="form-group">
                      <label>Batch Name</label>
                      <Field name="name" component="input" type="text" placeholder="Enter Batch Name" class="form-control"/>
                      
                    </div>
                    
                    <div class="form-group">
                      <label>Batch Description</label>
                      <Field name="description" component="input" type="textarea" placeholder="Enter Batch Description" class="form-control"/>
                    </div>
					
					<div class="form-group"><label>Branch</label>
              <div>
                  <Field name="branch" component="select" class="form-control">
                      {branches.map(branch => <option value={branch.id} key={branch.id}>{branch.branchname}</option>)}
                  </Field>
					    </div>	
    			</div>

          <div class="form-group"><label>Status</label>
              <div>
                  <Field name="status" component="select" class="form-control">
                      {status.map(s => <option value={s.id} key={s.id}>{s.name}</option>)}
                  </Field>
					    </div>	
    			</div>

					  <div class="box-footer">
                  <button type="submit" disabled={submitting} class="btn btn-primary">Save Batch</button>
                  <button type="button" disabled={pristine || submitting} onClick={reset} class="btn btn-primary">Clear Batch</button>
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
    status: state.batch.status,
    errorMessage: state.batch.error,
    addBatch: state.batch.addBatch
    };
}

const formAddBatch = reduxForm({form: 'editBatch'})(EditBatch);
export default connect(mapStateToProps)(formAddBatch);