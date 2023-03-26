package com.example.jsonjparestdemo.db;

import com.example.jsonjparestdemo.db.Purchaseorder;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "customer", schema = "jsonjpa")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerid", nullable = false)
	private Integer id;

	@Column(name = "email", length = 100)
	private String email;

	@Column(name = "id", length = 100)
	private String id1;

	@Column(name = "mobile")
	private Integer mobile;

	@Column(name = "name", length = 100)
	private String name;

	@JsonManagedReference
	@OneToMany(mappedBy = "customerid")
	private Set<Purchaseorder> purchaseorders = new LinkedHashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId1() {
		return id1;
	}

	public void setId1(String id1) {
		this.id1 = id1;
	}

	public Integer getMobile() {
		return mobile;
	}

	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Purchaseorder> getPurchaseorders() {
		return purchaseorders;
	}

	public void setPurchaseorders(Set<Purchaseorder> purchaseorders) {
		this.purchaseorders = purchaseorders;
	}

}