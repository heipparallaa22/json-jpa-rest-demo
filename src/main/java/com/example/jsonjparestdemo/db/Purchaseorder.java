package com.example.jsonjparestdemo.db;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "purchaseorder", schema = "jsonjpa")
public class Purchaseorder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purchaseorderid", nullable = false)
	private Integer id;

	@Column(name = "purchaseordernumber")
	private Integer purchaseordernumber;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerid")
	private Customer customerid;

	@Column(name = "deliverynotes", length = 100)
	private String deliverynotes;

	@Column(name = "orderdate")
	private LocalDate orderdate;

	@OneToMany(mappedBy = "purchaseorderid")
	private Set<Item> items = new LinkedHashSet<>();

	@OneToMany(mappedBy = "purchaseorderid")
	private Set<Address> addresses = new LinkedHashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPurchaseordernumber() {
		return purchaseordernumber;
	}

	public void setPurchaseordernumber(Integer purchaseordernumber) {
		this.purchaseordernumber = purchaseordernumber;
	}

	public Customer getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Customer customerid) {
		this.customerid = customerid;
	}

	public String getDeliverynotes() {
		return deliverynotes;
	}

	public void setDeliverynotes(String deliverynotes) {
		this.deliverynotes = deliverynotes;
	}

	public LocalDate getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(LocalDate orderdate) {
		this.orderdate = orderdate;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

}