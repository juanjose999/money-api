package com.loans.money.repository.loan;

import com.loans.money.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoanRepositoryJpa extends JpaRepository<Loan, Long> {

}
