package com.loans.money.repository;

import com.loans.money.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryJpaPayments extends JpaRepository<Payment, Long> {
}
