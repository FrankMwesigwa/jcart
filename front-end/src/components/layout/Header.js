import React, {Component} from 'react';
import { connect } from "react-redux"
import { Link } from 'react-router-dom';

class Header extends Component {

  render() {
   
    return (
      <header class="main-header">

        <a href="#" href="{/home}" class="logo">
          <span class="logo-mini"><b>JC</b></span>
          <span class="logo-lg"><b>JCart Admin</b></span>
        </a>

      <nav class="navbar navbar-static-top" role="navigation">
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          
          
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="/assets/dist/img/user.png" class="user-image" alt="User Image"/>
              <span class="hidden-xs">Frank Mwesigwa</span>
            </a>
            <ul class="dropdown-menu">
              <li class="user-header">
                <img src="/assets/dist/img/user.png" class="img-circle" alt="User Image"/>
                <p>
                  <span>Frank Mwesigwa</span>
                </p>
              </li>

              <li class="user-footer">
                <div class="pull-left">
                  <a href="#" href="{/myAccount}" class="btn btn-default btn-flat">Profile</a>
                </div>
                <div class="pull-right">
                  <button className="btn btn-default btn-flat" ><Link to="/logout">Log out</Link></button>
                </div>
              </li>
            </ul>
          </li>
          <li>
            <a href="" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
          </li>
        </ul>
      </div>
    </nav>
    </header>
    )
  }
}

export default connect ( null )(Header);