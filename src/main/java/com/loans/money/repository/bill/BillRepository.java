package com.loans.money.repository.bill;

import com.loans.money.entity.Bill;

import java.util.List;
import java.util.Optional;

public interface BillRepository {
    List<Bill> allBill();
    Optional<Bill> findBillById(Long id);
    Bill saveBill (Bill bill);
    Boolean deleteBillById(Long id);
}
