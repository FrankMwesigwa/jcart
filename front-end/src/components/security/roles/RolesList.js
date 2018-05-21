import React, {Component} from 'react';
import { Link } from 'react-router-dom';
import {connect} from "react-redux";
import { getRoles } from '../../../actions/RolesActions';

class RolesList extends Component {

	constructor(props) {
    super(props);
    this.state = {
      roles: []
    };
  }

  componentDidMount() {
    this.props.dispatch(getRoles());
}

  render() {
		const { roles, loading, errorMessage } = this.props;

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
  <div class="row">
			<div class="col-md-12">
				<div class="box">
					<div class="box-header">
						<h3 class="box-title">List of Roles</h3>
						<div class="box-tools">
							<div class="input-group" style={{width:'150px'}}>
                            <Link to="/roles/new" class="btn btn-sm btn-default">
                                <i class="fa fa-plus-circle"></i> New Role
                            </Link>
							</div>
						</div>
					</div>
					<div class="box-body table-responsive no-padding">
						<table class="table table-hover">
						<thead>
							<tr>
								<th>Id</th>
								<th>Role Name</th>
								<th>Description</th>
                <th>Permissions</th>
							</tr>
							</thead>
							<tbody>
                      {
                        roles.map(role => (
                        <tr key={role.id}>
                          <td>{role.id}</td>
                          <td>{role.name}</td>
                          <td>{role.description}</td>
                          <td>{role.permissions}</td>
                          <td><Link class="btn btn-sm btn-default" to={`/roles/${role.id}`}>
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
  roles: state.role.roles,
  loading: state.role.loading,
  errorMessage: state.role.error
});

export default connect(mapStateToProps)(RolesList);