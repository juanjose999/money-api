package com.loans.money.dto.bill;

import com.loans.money.entity.Bill;

public class BillMapper {

    public static Bill billDtoBill(BillDto billDto){
        Bill bill = new Bill();
        bill.setDateBill(billDto.getDateBill());
        bill.setId_loan(billDto.getId_loan());
        bill.setId_client(billDto.getId_client());
        bill.setFull_name_client(billDto.getFull_name_client());
        bill.setLoan_initial(billDto.getLoan_initial());
        bill.setAmount_payment(billDto.getAmount_payment());
        bill.setDebt_actually(billDto.getDebt_actually());
        return bill;
    }

    public static BillResponseDto billToBillResponseDto(Bill bill){
        BillResponseDto billResponseDto = new BillResponseDto();
        billResponseDto.setDateBill(bill.getDateBill());
        billResponseDto.setFull_name_client(bill.getFull_name_client());
        billResponseDto.setLoan_initial(bill.getLoan_initial());
        billResponseDto.setAmount_payment(bill.getAmount_payment());
        billResponseDto.setDebt_total_actually(bill.getDebt_actually());
        return billResponseDto;
    }

}
