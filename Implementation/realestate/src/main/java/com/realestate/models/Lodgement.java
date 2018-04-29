package com.realestate.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lodgement")
public class Lodgement {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="address")
	private String address;
	
	@Column(name="state")
	private String state;
	
	@Column(name="surface")
	private double surface;
	
	@Column(name="type")
	private String type;
	
	@Column(name="locale")
	private String locale;
	
	@Column(name="price")
	private double price;
	
	@Column(name="reserved")
	private int reserved;
	
	public Lodgement() {
		super();
	}
	
	public Lodgement(int id, String address, double surface, String type, String locale, double price, int reserved) {
		this.id = id;
		this.surface = surface;
		this.address = address;
		this.type = type;
		this.locale = locale;
		this.price = price;
		this.reserved = reserved;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public double getSurface() {
		return surface;
	}

	public void setSurface(double surface) {
		this.surface = surface;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getReserved() {
		return reserved;
	}

	public void setReserved(int reserved) {
		this.reserved = reserved;
	}
	
		
}
