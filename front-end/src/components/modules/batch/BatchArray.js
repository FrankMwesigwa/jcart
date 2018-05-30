import React, {Component} from 'react';
import {Field, FieldArray, reduxForm} from 'redux-form';
import {connect} from 'react-redux'
import { addBatch, getBranches } from '../../../actions/BatchActions';

class BatchArray extends Component {

  constructor(props) {
    super(props);
    this.state = {
        branches: []
    };
  }

  submit = (values) => {
    this.props.dispatch(addBatch(values, this.props.history));
}


  render() {

    const { handleSubmit, pristine, reset, submitting ,loading, errorMessage , branches } = this.props;

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

      const renderAccounts = ({ fields, meta: { error, submitFailed } }) => (
        <ul >
          <li>
            <button type="button" onClick={() => fields.push({})} class="btn btn-success">Add Account Details</button>
            {submitFailed && error && <span>{error}</span>}
          </li>
          {fields.map((account, index) => (
    <li key={index}>
        <div class="box box-default">
                <div class="box-header with-border">
                    <h3 class="box-title">Account : {index + 1}</h3>

                <div class="box-tools pull-right">
                    <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                </div>
                </div>

            <div class="box-body">
                <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Account Number</label>
                        <Field name={`${account}.accountName`} component="input" type="text" placeholder="Enter Role Name" class="form-control" />
                    </div>
                    <div class="form-group">
                        <label>Account Name</label>
                        <Field name={`${account}.accountNo`} component="input" type="text" placeholder="Enter Role Name" class="form-control" />
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Client Code</label>
                        <Field name={`${account}.clientCode`} component="input" type="text" placeholder="Enter Role Name" class="form-control" />
                    </div>
                    <div class="form-group">
                        <label>Account Type</label>
                        <Field name={`${account}.accountType`} component="input" type="text" placeholder="Enter Role Name" class="form-control" />
                    </div>
                </div>
                </div>
          </div>
            <div class="box-footer">
                <button type="button" title="Remove Account" class="btn btn-danger" onClick={() => fields.remove(index)}>Remove Account</button>
            </div>
        </div>   
</li>))}
</ul>
)

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
    <div class="box-header with-border"><h3 class="box-title">Create New Batch</h3></div>
        <div class="box-body">
            <form onSubmit={handleSubmit(this.submit.bind(this))}>

                <div class="box-body">
                <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Branchs</label>
                        <Field name="branchx" component="input" type="text" class="form-control" />
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <Field name="description" component="input" type="text" class="form-control"/>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Name</label>
                        <Field name="name" component="input" type="text" class="form-control"/>
                    </div>
                    <div class="form-group">
						<label>Branches</label>
						<div>
                        <Field name="branch" component="select" class="form-control">
                            {branches.map(branch => <option value={branch.id} key={branch.id}>{branch.branchname}</option>)}
                        </Field>
						</div>	
    				</div>
                </div>
                </div>
                <FieldArray name="accounts" component={renderAccounts} />
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
      errorMessage: state.batch.error,
      addBatch: state.batch.addBatch
      };
  }


const FieldArraysForm = reduxForm({form: 'fieldArrays',})(BatchArray);
export default connect(mapStateToProps)(FieldArraysForm);