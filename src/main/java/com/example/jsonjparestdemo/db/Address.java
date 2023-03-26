package com.example.jsonjparestdemo.db;

import com.example.jsonjparestdemo.db.Purchaseorder;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "address", schema = "jsonjpa")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "addressid", nullable = false)
	private Integer id;

	@Column(name = "zip")
	private Integer zip;

	@Column(name = "type", length = 100)
	private String type;

	@Column(name = "state", length = 100)
	private String state;

	@Column(name = "street", length = 100)
	private String street;

	@Column(name = "country", length = 100)
	private String country;

	@Column(name = "city", length = 100)
	private String city;

	@Column(name = "name", length = 100)
	private String name;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "purchaseorderid", nullable = false)
	private Purchaseorder purchaseorderid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Purchaseorder getPurchaseorderid() {
		return purchaseorderid;
	}

	public void setPurchaseorderid(Purchaseorder purchaseorderid) {
		this.purchaseorderid = purchaseorderid;
	}

}