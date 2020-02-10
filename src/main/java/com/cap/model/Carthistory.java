package com.cap.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cart_history")
public class Carthistory {

	private String name;
	private String brand;
	private String madein;
	private String modelName;
	private float price;
	@Id
	private int quantity;
	
	public Carthistory() {}
	
	public Carthistory(String name, String brand, String madein, String modelName, float price, int quantity) {
		super();
		this.name = name;
		this.brand = brand;
		this.madein = madein;
		this.modelName = modelName;
		this.price = price;
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getMadein() {
		return madein;
	}
	public void setMadein(String madein) {
		this.madein = madein;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Carthistory [name=" + name + ", brand=" + brand + ", madein=" + madein + ", modelName=" + modelName
				+ ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	
	
}
