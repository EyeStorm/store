package com.tiagohs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiagohs.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
