package com.loans.money.repository.client;

import com.loans.money.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClientRepositoryJpa extends JpaRepository<Client, Long> {
    @Query("SELECT c FROM Client c WHERE c.firstName LIKE %:keyword% OR c.lastName LIKE %:keyword%")
    List<Client> findByFirstNameOrLastNameContaining(@Param("keyword") String keyword);


}
