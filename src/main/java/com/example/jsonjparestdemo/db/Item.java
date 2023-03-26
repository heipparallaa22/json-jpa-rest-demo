package com.example.jsonjparestdemo.db;

import com.example.jsonjparestdemo.db.Purchaseorder;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "item", schema = "jsonjpa")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "itemid", nullable = false)
	private Integer id;

	@Column(name = "comment", length = 100)
	private String comment;

	@Column(name = "partnumber", length = 100)
	private String partnumber;

	@Column(name = "productname", length = 100)
	private String productname;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "usprice")
	private Double usprice;

	@Column(name = "shipdate")
	private LocalDate shipdate;

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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getPartnumber() {
		return partnumber;
	}

	public void setPartnumber(String partnumber) {
		this.partnumber = partnumber;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getUsprice() {
		return usprice;
	}

	public void setUsprice(Double usprice) {
		this.usprice = usprice;
	}

	public LocalDate getShipdate() {
		return shipdate;
	}

	public void setShipdate(LocalDate shipdate) {
		this.shipdate = shipdate;
	}

	public Purchaseorder getPurchaseorderid() {
		return purchaseorderid;
	}

	public void setPurchaseorderid(Purchaseorder purchaseorderid) {
		this.purchaseorderid = purchaseorderid;
	}

}