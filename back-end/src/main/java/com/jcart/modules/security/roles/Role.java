package com.jcart.modules.security.roles;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.jcart.modules.security.permissions.Permission;

import lombok.Data;


@Entity
@Data
@Table(name="roles")
public class Role
{
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;

	private String name;
	private String description;

	@ManyToMany
	  @JoinTable(
	      name="role_permission",
	      joinColumns={@JoinColumn(name="role_id", referencedColumnName="id")},
	      inverseJoinColumns={@JoinColumn(name="perm_id", referencedColumnName="id")})
	  private Set<Permission> permissions;

	
}
