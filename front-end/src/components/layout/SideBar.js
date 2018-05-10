import React, {Component} from 'react';
import { connect } from "react-redux"
import { Link } from 'react-router-dom';

class SideBar extends Component {

  render() {
  
    return (

      <section class="sidebar">
      <div class="user-panel">
        <div class="pull-left image">
          <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image"/>
        </div>
        <div class="pull-left info">
          <p></p>
          <a href=""><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>

      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search..."/>
          <span class="input-group-btn">
              <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
              </button>
            </span>
        </div>
      </form>

      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">Main Navigation</li>
        
        <li class="active"><a href="#"><i class="fa fa-dashboard"></i> <span>Dashboard</span></a></li>
        <li class="treeview">
          <a href="#"><i class="fa fa-pie-chart"></i> <span>Batch</span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
          </a>
          <ul class="treeview-menu">
            <li><Link to="/batch"><i className="fa fa-circle-o"></i>Manage Batch</Link></li>
            <li><Link to="/addbatch"><i className="fa fa-circle-o"></i>Add Batch</Link></li>
            <li><a href="#"><i class="fa fa-circle-o"></i>Batch Reports</a></li>
          </ul>
        </li>

        <li class="treeview">
          <a href="#"><i class="fa fa-table"></i> <span>Accounts</span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="#"><i class="fa fa-circle-o"></i>Manage Accounts</a></li>
            <li><a href="#"><i class="fa fa-circle-o"></i>Manage Accounts</a></li>
            <li><a href="#"><i class="fa fa-circle-o"></i>Accounts Reports</a></li>
          </ul>
        </li>

        <li class="treeview">
          <a href="#"><i class="fa fa-calendar"></i> <span>Tracker</span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="#"><i class="fa fa-circle-o"></i>Manage Tracker</a></li>
            <li><a href="#"><i class="fa fa-circle-o"></i>Tracker Reports</a></li>
          </ul>
        </li>

        <li class="treeview">
          <a href="#"><i class="fa fa-gears"></i> <span>System Masters</span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
          </a>
          <ul class="treeview-menu">
            <li><Link to="/user"><i className="fa fa-circle-o"></i>Manage Users</Link></li>
            <li><a href="#"><i class="fa fa-circle-o"></i>View Tracker</a></li>
            <li><a href="#"><i class="fa fa-circle-o"></i>Tracker Reports</a></li>
          </ul>
        </li>

      </ul>
    
    </section>
    )
  }
}

export default connect ( null )(SideBar);