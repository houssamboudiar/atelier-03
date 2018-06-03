package com.realestate.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@Column(name="type")
	private String type;
	
	@Column(name="name")
	private String name;
	
	@Column(name="f_name")
	private String f_name;
	
	@Column(name="birthdate")
	private String birthdate;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="address")
	private String address;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="blocked")
	private int blocked;
	
	public User() {
		super();
	}
	
	public User(int id, String username, String password, String email, String type, String name, String f_name, String birthdate, String phone, String address, String gender, int blocked) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.type = type;
		this.name = name;
		this.f_name = f_name;
		this.birthdate = birthdate;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
		this.blocked = blocked;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getBlocked() {
		return blocked;
	}

	public void setBlocked(int blocked) {
		this.blocked = blocked;
	}
	
	
	public void infos() {
		System.out.println(this.username);
		System.out.println(this.name);
		System.out.println(this.email);
		System.out.println(this.f_name);
		System.out.println(this.password);
		System.out.println(this.birthdate);
		System.out.println(this.phone);
		System.out.println(this.type);
		System.out.println(this.gender);
		System.out.println(this.address);
	}
	
}
