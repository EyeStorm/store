package com.tiagohs.repository;

import com.tiagohs.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Client, Long> {

  @Query("SELECT COUNT(c) FROM Client c")
  Long getTotalClients();
}
