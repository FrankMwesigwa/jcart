import React, {Component} from 'react';
import { Link } from 'react-router-dom';
import {connect} from "react-redux";
import { getPermissions } from '../../../actions/PermissionActions';

class PermissionList extends Component {

	constructor(props) {
    super(props);
    this.state = {
      permissions: []
    };
  }

  componentDidMount() {
    this.props.dispatch(getPermissions());
}


  render() {
		const { permissions, loading, errorMessage } = this.props;

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
      <h1>Permissions Management</h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Security</a></li>
        <li class="active">Permissions</li>
      </ol>
    </section>

  <section class="content container-fluid">
  <div class="row">
			<div class="col-md-12">
				<div class="box">
					<div class="box-header">
						<h3 class="box-title">List of Permissions</h3>
					</div>
					<div class="box-body table-responsive no-padding">
						<table class="table table-hover">
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Description</th>
							</tr>
							</thead>
							<tbody>
                      {
                        permissions.map(perm => (
                        <tr key={perm.id}>
                          <td>{perm.id}</td>
                          <td>{perm.name}</td>
                          <td>{perm.description}</td>
                          <td><Link class="btn btn-sm btn-default" to={`/permissions/${perm.id}`}>
                                <i class="fa fa-edit"></i>Edit</Link>
                          </td>
                        </tr>
                        ))
                      }                      
              </tbody> 

						</table>
					</div>
				</div>
			</div>
		</div>

  </section>
</div>
    )
  }
}

const mapStateToProps = state => ({
  permissions: state.permission.permissions,
  loading: state.permission.loading,
  errorMessage: state.permission.error
});

export default connect(mapStateToProps)(PermissionList);