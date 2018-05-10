package com.jcart.modules.ecommerce.order;

import com.jcart.modules.ecommerce.product.Product;
import lombok.Data;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Data
@Table(name="order_items")
public class OrderItem
{

	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;

	private BigDecimal price;
	private int quantity;

	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;

	public BigDecimal getSubTotal()
	{
		return product.getPrice().multiply(new BigDecimal(quantity));
	}
	
}
