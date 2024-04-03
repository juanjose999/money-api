package com.loans.money.repository;

import com.loans.money.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryJpaLoads extends JpaRepository<Loan, Long> {
}
