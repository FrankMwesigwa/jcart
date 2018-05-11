import React, {Component} from 'react';
import { connect } from "react-redux"
import { Link } from 'react-router-dom';

class SideBar extends Component {

  render() {
  
    return (

      <aside class="main-sidebar">
        <section class="sidebar">

          <div class="user-panel">
            <div class="pull-left image">
              <img src="/assets/dist/img/user.png" class="img-circle" alt="User Image"/>
            </div>
            <div class="pull-left info">
              <p><span>Frank Mwesigwa</span></p>
              <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
          </div>

          <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
              <input type="text" name="q" class="form-control" placeholder="Search..."/>
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i></button>
              </span>
            </div>
          </form>

          <ul class="sidebar-menu">
            <li><a href="#" href="'/home'"><i class="fa fa-home"></i> <span>Home</span></a></li>
            <li><a href="#" href="'/categories'"><i class="fa fa-folder-open"></i> <span>Categories</span></a></li>
            <li><a href="#" href="'/products'"><i class="fa fa-file"></i> <span>Products</span></a></li>
            <li><a href="#" href="'/orders'"><i class="fa fa-cart-arrow-down"></i> <span>Orders</span></a></li>
            <li><a href="#" href="'/customers'"><i class="fa fa-smile-o"></i> <span>Customers</span></a></li>
            <li><a href="#" href="'/users'"><i class="fa fa-users"></i> Users</a></li>
            <li><a href="#" href="'/roles'"><i class="fa fa-user"></i> Roles</a></li>
            <li><a href="#" href="'/permissions'"><i class="fa fa-shield"></i> Permissions</a></li>         
          </ul>
        </section>
      </aside>
    )
  }
}

export default connect ( null )(SideBar);