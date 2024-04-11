package com.loans.money.repository.bill;

import com.loans.money.entity.Bill;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Repository
public class BillRepositoryImpl implements BillRepository{

    private final BillRepositoryJpa billRepositoryJpa;
    @Override
    public List<Bill> allBill() {
        return billRepositoryJpa.findAll();
    }

    @Override
    public Optional<Bill> findBillById(Long id) {
        return billRepositoryJpa.findById(id);
    }

    @Override
    public Bill saveBill(Bill bill) {
        return billRepositoryJpa.save(bill);
    }

    @Override
    public Boolean deleteBillById(Long id) {
        return findBillById(id).map(bill -> {
            billRepositoryJpa.delete(bill);
            return true;
        }).orElse(false);
    }
}
