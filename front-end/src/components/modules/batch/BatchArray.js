import React, {Component} from 'react';
import {Field, FieldArray, reduxForm} from 'redux-form';
import {connect} from 'react-redux'

class BatchArray extends Component {

  constructor(props) {
    super(props);
    this.state = {
        branches: []
    };
  }


  render() {

    const { handleSubmit, pristine, reset, submitting ,loading } = this.props;

    if (loading) {
        return <div className="info-message">
            <p>Loading...</p>
        </div>;
      }

      const renderAccounts = ({ fields, meta: { error, submitFailed } }) => (
        <ul>
          <li>
            <button type="button" onClick={() => fields.push({})} class="btn btn-primary">Add Account Details</button>
            {submitFailed && error && <span>{error}</span>}
          </li>
          {fields.map((account, index) => (
            <li key={index}>
              <button type="button" title="Remove Account" class="btn btn-danger" onClick={() => fields.remove(index)}>Remove Account</button>
              <h4>Account #{index + 1}</h4>
                <div class="form-group">
                    <label>Fisrt Name</label>
                    <Field name={`${account}.firstName`} component="input" type="text" placeholder="Enter Role Name" class="form-control" />
                </div>
                <div class="form-group">
                    <label>Fisrt Name</label>
                    <Field name={`${account}.lastName`} component="input" type="text" placeholder="Enter Role Name" class="form-control" />
                </div>
            </li>
          ))}
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
                <div class="box-header with-border">
                  <h3 class="box-title">Create New Batch</h3>
                </div>
                <div class="box-body">

            <form onSubmit={handleSubmit}>
                    <div class="form-group">
                        <label>Name</label>
                        <Field name="clubName" component="input" type="text" class="form-control" />
                    </div>
                    <div class="form-group">
                        <label>Name</label>
                        <Field name="description" component="input" type="text" class="form-control"/>
                    </div>
                    <FieldArray name="members" component={renderAccounts} />
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
      loading: state.batch.loading
      };
  }


const FieldArraysForm = reduxForm({form: 'fieldArrays',})(BatchArray);
export default connect(mapStateToProps)(FieldArraysForm);