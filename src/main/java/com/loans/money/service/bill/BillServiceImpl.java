package com.loans.money.service.bill;

import com.loans.money.dto.bill.BillDto;
import com.loans.money.dto.bill.BillMapper;
import com.loans.money.dto.bill.BillResponseDto;
import com.loans.money.entity.Bill;
import com.loans.money.repository.bill.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;
    @Override
    public List<BillResponseDto> allBill() {
        List<BillResponseDto> billResponseDto = new ArrayList<>();
        billRepository.allBill().forEach(bill -> billResponseDto.add(BillMapper.billToBillResponseDto(bill)));
        return billResponseDto;
    }

    @Override
    public Optional<BillResponseDto> findBillById(Long id) {
        Optional<Bill> findBill = billRepository.findBillById(id);
        return findBill.map(BillMapper::billToBillResponseDto);
    }

    @Override
    public BillResponseDto saveBill(BillDto billDto) {
        return BillMapper.billToBillResponseDto(billRepository.saveBill(BillMapper.billDtoBill(billDto)));
    }

    @Override
    public Boolean deleteBillById(Long id) {
        return billRepository.deleteBillById(id);
    }
}
