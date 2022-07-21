package com.wipro.project.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "orders")
public class Payment {
	
	@Id
	private String id;
	
	private String noc,cardno;
	private Date expiry;
	private int cvv;
	private String street,city,state;
	private int pincode;
	
	public Payment() {
		
	}

	public Payment(String id, String noc, String cardno, Date expiry, int cvv, String street, String city, String state,
			int pincode) {
		this.id = id;
		this.noc = noc;
		this.cardno = cardno;
		this.expiry = expiry;
		this.cvv = cvv;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNoc() {
		return noc;
	}

	public void setNoc(String noc) {
		this.noc = noc;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public Date getExpiry() {
		return expiry;
	}

	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	} 

}

