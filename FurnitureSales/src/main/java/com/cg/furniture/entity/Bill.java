package com.cg.furniture.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name ="my_bill_seq",sequenceName = "BILL_SEQ",initialValue = 90001,allocationSize = 1)
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "my_bill_seq")
	private int billId;
	private String billingAddress;
	private LocalDateTime billDate;
	@OneToOne
	private Order order;
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	public LocalDateTime getBillDate() {
		return billDate;
	}
	public void setBillDate(LocalDateTime billDate) {
		this.billDate = billDate;
	}
}
