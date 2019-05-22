package com.adam.cms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@JsonProperty("id")
	private int customerid;
	@JsonProperty("FirstName")
	private String customerFirstName;
	@JsonProperty("LastName")
	private String customerLastName;
	@JsonProperty("Email")
	private String customerEmail;

	public int getCustomerid() {
		return customerid;
	} 
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getCustomerFirstName() {
		return customerFirstName;
	}
	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}
	public String getCustomerLastName() {
		return customerLastName;
	}
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
	
}
