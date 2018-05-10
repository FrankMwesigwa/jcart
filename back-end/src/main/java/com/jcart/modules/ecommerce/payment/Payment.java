package com.jcart.modules.ecommerce.payment;

import lombok.Data;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Data
@Table(name="payments")
public class Payment {

    @Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

	private String ccNumber;
	private String cvv;
	private BigDecimal amount;
		
}
