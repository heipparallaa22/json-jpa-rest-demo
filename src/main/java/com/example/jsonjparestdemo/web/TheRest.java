package com.example.jsonjparestdemo.web;

import com.example.jsonjparestdemo.db.Purchaseorder;
import com.example.jsonjparestdemo.db.PurchaseorderRepository;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TheRest {

	@Autowired
	PurchaseorderRepository purchaseorderRepository;

	@GetMapping("/order/{id}")
	@ResponseBody
	public Purchaseorder getOrderById(@PathVariable Long id,
									  @RequestHeader Authorization jwt) {

		Purchaseorder purchaseorder = purchaseorderRepository.findById(id).get();


		return purchaseorder;
	}




}



