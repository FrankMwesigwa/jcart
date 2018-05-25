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
                        <label>Minimal</label>
                        <Field name={`${account}.firstName`} component="input" type="text" placeholder="Enter Role Name" class="form-control" />
                    </div>
                    <div class="form-group">
                        <label>Disabled</label>
                        <Field name={`${account}.lastName`} component="input" type="text" placeholder="Enter Role Name" class="form-control" />
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Multiple</label>
                        <Field name={`${account}.firstName`} component="input" type="text" placeholder="Enter Role Name" class="form-control" />
                    </div>
                    <div class="form-group">
                        <label>Disabled Result</label>
                        <Field name={`${account}.lastName`} component="input" type="text" placeholder="Enter Role Name" class="form-control" />
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
            <form onSubmit={handleSubmit}>

                <div class="box-body">
                <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Minimal</label>
                        <Field name="name" component="input" type="text" class="form-control" />
                    </div>
                    <div class="form-group">
                        <label>Disabled</label>
                        <Field name="description" component="input" type="text" class="form-control"/>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Multiple</label>
                        <Field name="description" component="input" type="text" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label>Disabled Result</label>
                        <Field name="description" component="input" type="text" class="form-control"/>
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
      loading: state.batch.loading
      };
  }


const FieldArraysForm = reduxForm({form: 'fieldArrays',})(BatchArray);
export default connect(mapStateToProps)(FieldArraysForm);