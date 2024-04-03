package com.loans.money.repository;

import com.loans.money.entity.Loans;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repositoryJpaLoads extends JpaRepository<Loans, Long> {
}
