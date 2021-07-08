package com.cg.furniture.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Orders")
@SequenceGenerator(name ="my_order_seq",sequenceName = "ORDER_SEQ",initialValue = 50001,allocationSize = 1)
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "my_order_seq")
	private int orderId;
	private String furnitureName;
	private String orderDate;
	private double orderPrice;
	@OneToOne
	private Bill bill;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customerId")
	private Customer customer;
	@OneToOne
	private Furniture furniture;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getFurnitureName() {
		return furnitureName;
	}
	public void setFurnitureName(String furnitureName) {
		this.furnitureName = furnitureName;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public double getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", furnitureName=" + furnitureName + ", orderDate=" + orderDate
				+ ", orderPrice=" + orderPrice + "]";
	}
}
