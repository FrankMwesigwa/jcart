package com.jcart.modules.security.users;

import javax.persistence.*;

import com.jcart.modules.security.roles.Role;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name="users")
public class User
{
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;

	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;

	@ManyToMany(cascade=CascadeType.MERGE)
	@JoinTable(
	      name="user_role",
	      joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
	      inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="id")})
	private Set<Role> roles;


}
