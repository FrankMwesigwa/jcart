package com.jcart.modules.ecommerce.order;

import com.jcart.modules.ecommerce.address.Address;
import com.jcart.modules.ecommerce.customer.Customer;
import com.jcart.modules.ecommerce.payment.Payment;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Data
@Table(name="orders")
public class Order
{
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;

	private String orderNumber;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="order")
    private Set<OrderItem> items;

	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="cust_id")
	private Customer customer;

	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="delivery_addr_id")
	private Address deliveryAddress;

	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="billing_addr_id")
	private Address billingAddress;

	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="payment_id")
	private Payment payment;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;
	
	public Order()
	{
		this.items = new HashSet<OrderItem>();
		this.status = OrderStatus.NEW;
		this.createdOn = new Date();
	}
	
	public BigDecimal getTotalAmount()
	{
		BigDecimal amount = new BigDecimal("0.0");
		for (OrderItem item : items)
		{
			amount = amount.add(item.getSubTotal());
		}
		return amount;
	}
	
}
