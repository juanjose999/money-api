package com.loans.money.repository.bill;

import com.loans.money.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepositoryJpa extends JpaRepository<Bill, Long> {
}
