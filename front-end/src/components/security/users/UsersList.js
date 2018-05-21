import React, {Component} from 'react';
import { Link } from 'react-router-dom';

class UsersList extends Component {


  render() {
    return (
      <div>

    <section class="content-header">
      <h1>Users Management</h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> security</a></li>
        <li class="active">users</li>
      </ol>
    </section>

  <section class="content container-fluid">
  <div class="row">
            <div class="col-md-12">
              <div class="box">
                <div class="box-header">
                  <h3 class="box-title">List of Users</h3>
                  <div class="box-tools">
                    <div class="input-group" style={{width:'150px'}}>
                        <Link to="/users/new" class="btn btn-sm btn-default">
                                <i class="fa fa-plus-circle"></i> New User
                        </Link>
                    </div>
                  </div>
                <div class="box-body table-responsive no-padding">
                  <table class="table table-hover">
                    <tr>
                      <th style={{width:'10px'}}>#</th>
                      <th>Name</th>
                      <th>Email</th>
                      <th>Edit</th>
                    </tr>
                    <tr>
                      <td><a href="@{/users/{id}(id=${user.id})}"><span text="${iterStat.count}">1</span></a></td>
                      <td>Name</td>
                      <td>Email</td>
                      <td><a href="@{/users/{id}(id=${user.id})}" class="btn btn-sm btn-default"><i class="fa fa-edit"></i> Edit</a></td>
                    </tr>
                    
                  </table>
                </div>
                
              </div>
              </div>
              </div>
              </div>

  </section>
</div>
    )
  }
}

export default UsersList;