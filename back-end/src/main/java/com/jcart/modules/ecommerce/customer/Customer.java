package com.jcart.modules.ecommerce.customer;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="customers")
public class Customer {

	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phone;

}
