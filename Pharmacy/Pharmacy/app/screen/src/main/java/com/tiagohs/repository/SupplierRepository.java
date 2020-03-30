package com.tiagohs.repository;

import com.tiagohs.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

  @Query("SELECT COUNT(s) FROM Supplier s")
  Long getTotalSuppliers();
}
