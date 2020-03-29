package com.tiagohs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiagohs.model.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {

}
