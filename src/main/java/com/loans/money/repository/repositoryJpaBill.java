package com.loans.money.repository;

import com.loans.money.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repositoryJpaBill extends JpaRepository<Bill, Long> {
}
