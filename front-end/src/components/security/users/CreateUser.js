import React, {Component} from 'react';

class CreateUser extends Component {

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
  <div class="box box-warning">
                <div class="box-header with-border">
                  <h3 class="box-title">Create New User</h3>
                </div>
                <div class="box-body">
                  <form role="form" >
                    <div class="form-group">
                      <label>Name</label>
                      <input type="text" class="form-control" name="name" placeholder="Enter User Name"/>
                    </div>
                    
                    <div class="form-group">
                      <label>Email</label>
                      <input type="text" class="form-control" name="email" placeholder="Enter User Email"/>
                    </div>
                    
                    <div class="form-group">
                      <label>Password</label>
                      <input type="password" class="form-control" name="password" placeholder="Enter password"/>
                    </div>
					
					<div class="form-group">
						<label>Roles</label>
						<div>
						  <p>
						    <input type="checkbox"/>
						    <label text="${role.name}">Role</label>
						  </p>
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

export default CreateUser;