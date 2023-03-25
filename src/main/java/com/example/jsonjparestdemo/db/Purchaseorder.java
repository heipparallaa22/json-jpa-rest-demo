package com.example.jsonjparestdemo.db;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "purchaseorder", schema = "jsonjpa")
public class Purchaseorder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purchaseorderid", nullable = false)
	private Integer id;

	@Column(name = "purchaseordernumber")
	private Integer purchaseordernumber;

	@Column(name = "deliverynotes", length = 100)
	private String deliverynotes;

	@Column(name = "orderdate")
	private LocalDate orderdate;

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

}