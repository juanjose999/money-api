package com.loans.money.repository.payment;

import com.loans.money.entity.Loan;
import com.loans.money.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepositoryJpa extends JpaRepository<Payment, Long> {
}
