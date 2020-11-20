package model;

import java.io.Serializable;

public class CartBean implements Serializable{
	private String name;
	private int price;
	private int quantity;
	private int procd;





	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getProcd() {
		return procd;
	}
	public void setProcd(int procd) {
		this.procd = procd;
	}


}
