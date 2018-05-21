package com.jcart.modules.security.permissions;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Data
@Table(name="permissions")
public class Permission
{
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;

	private String name;
	private String description;
	
}
