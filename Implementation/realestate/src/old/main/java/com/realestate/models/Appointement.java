package com.realestate.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appointment")
public class Appointement {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="date")
	private String date;
	
	@Column(name="id_client")
	private int id_client;
	
	@Column(name="id_agent")
	private int id_agent;
	
	@Column(name="id_lodgement")
	private int id_lodgement;
	
	@Column(name="agent_confirmed")
	private int agent_confirmed;
	
	@Column(name="client_confirmed")
	private int client_confirmed;
	
	@Column(name="review")
	private String review;
	
	public Appointement() {
		super();
	}
	
	public Appointement(int id, String date, int id_client, int id_agent, int id_lodgement, int agent_confirmed, int client_confirmed, String review) {
		this.id = id;
		this.date = date;
		this.id_agent = id_agent;
		this.id_client = id_client;
		this.id_lodgement = id_lodgement;
		this.client_confirmed = client_confirmed;
		this.agent_confirmed = agent_confirmed;
		this.review = review;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public int getId_agent() {
		return id_agent;
	}

	public void setId_agent(int id_agent) {
		this.id_agent = id_agent;
	}

	public int getId_lodgement() {
		return id_lodgement;
	}

	public void setId_lodgement(int id_lodgement) {
		this.id_lodgement = id_lodgement;
	}

	public int getAgent_confirmed() {
		return agent_confirmed;
	}

	public void setAgent_confirmed(int agent_confirmed) {
		this.agent_confirmed = agent_confirmed;
	}

	public int getClient_confirmed() {
		return client_confirmed;
	}

	public void setClient_confirmed(int client_confirmed) {
		this.client_confirmed = client_confirmed;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
	
}
