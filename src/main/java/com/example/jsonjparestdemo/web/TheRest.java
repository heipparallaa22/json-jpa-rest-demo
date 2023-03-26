package com.example.jsonjparestdemo.web;

import com.example.jsonjparestdemo.db.Purchaseorder;
import com.example.jsonjparestdemo.db.PurchaseorderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TheRest {

	@Autowired
	PurchaseorderRepository purchaseorderRepository;

	@GetMapping("/order/{id}")
	@ResponseBody

	public ResponseEntity<Purchaseorder> getOrderById(@PathVariable Long id,
													  @RequestHeader String jwt) {

		Purchaseorder purchaseorder = purchaseorderRepository.findById(id).orElse(null);

		if( purchaseorder != null)
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
					.body(purchaseorder);

		else
			return ResponseEntity.notFound().build();
	}

/*
	@GetMapping("/order/{id}")
	@ResponseBody
	public Purchaseorder getOrderById(@PathVariable Long id,
									  @RequestHeader Authorization jwt) {

		Purchaseorder purchaseorder = purchaseorderRepository.findById(id).get();


		return purchaseorder;
	}

*/



}



