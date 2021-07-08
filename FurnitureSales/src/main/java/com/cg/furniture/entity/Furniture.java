package com.cg.furniture.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name ="my_furniture_seq",sequenceName = "FURNITURE_SEQ",initialValue = 801001,allocationSize = 1)
public class Furniture {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "my_furniture_seq")
	private int furnitureId;
	private String furnitureName;
	private double furniturePrice;
	private String furnitureCategory;
	private String usedDuration;
	private String customerName;
	private String description;
	
	@OneToOne
	private Order order;
	public int getFurnitureId() {
		return furnitureId;
	}
	public void setFurnitureId(int furnitureId) {
		this.furnitureId = furnitureId;
	}
	public String getFurnitureName() {
		return furnitureName;
	}
	public void setFurnitureName(String furnitureName) {
		this.furnitureName = furnitureName;
	}
	public double getFurniturePrice() {
		return furniturePrice;
	}
	public void setFurniturePrice(double furniturePrice) {
		this.furniturePrice = furniturePrice;
	}
	public String getFurnitureCategory() {
		return furnitureCategory;
	}
	public void setFurnitureCategory(String furnitureCategory) {
		this.furnitureCategory = furnitureCategory;
	}
	public String getUsedDuration() {
		return usedDuration;
	}
	public void setUsedDuartion(String usedDuration) {
		this.usedDuration = usedDuration;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
