package com.example.jsonjparestdemo.db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseorderRepository extends JpaRepository<Purchaseorder, Long> {
}
