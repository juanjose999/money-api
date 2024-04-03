package com.loans.money.repository;

import com.loans.money.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryJpaClients extends JpaRepository<Client, Long> {
}
