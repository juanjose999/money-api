package com.loans.money.service.bill;

import com.loans.money.dto.bill.BillDto;
import com.loans.money.dto.bill.BillResponseDto;
import com.loans.money.entity.Bill;

import java.util.List;
import java.util.Optional;

public interface BillService {
    List<BillResponseDto> allBill();
    Optional<BillResponseDto> findBillById(Long id);
    BillResponseDto saveBill (BillDto billDto);
    Boolean deleteBillById(Long id);
}
