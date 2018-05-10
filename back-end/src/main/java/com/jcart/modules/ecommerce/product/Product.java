package com.jcart.modules.ecommerce.product;

import com.jcart.modules.ecommerce.category.Category;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Data
@Table(name="products")
public class Product {

	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;

	private String sku;
	private String name;
	private String description;
	private BigDecimal price = new BigDecimal("0.0");
	private String imageUrl;
	private boolean disabled;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn = new Date();
	
	@ManyToOne
	@JoinColumn(name="cat_id")
	private Category category;
	
}
