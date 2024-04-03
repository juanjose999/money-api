package com.loans.money.repository;

import com.loans.money.entity.Payments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repositoryJpaPayments extends JpaRepository<Payments, Long> {
}
