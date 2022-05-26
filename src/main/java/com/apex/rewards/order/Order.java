package com.apex.rewards.order;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Order {
	
	private int id;
	private String description;
	private double price;
	private LocalDate date;
	 
	public Order(int id, String description, double price, LocalDate date) {
		this.id = id;
		this.description = description;
		this.price = price;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", description=" + description + ", price=" + price + ", date=" + date + "]";
	}
	
}
