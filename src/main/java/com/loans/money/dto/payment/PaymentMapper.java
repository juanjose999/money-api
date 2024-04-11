package com.loans.money.dto.payment;

import com.loans.money.dto.bill.BillMapper;
import com.loans.money.dto.bill.BillResponseDto;
import com.loans.money.entity.Bill;
import com.loans.money.entity.Payment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PaymentMapper {

    public static Payment paymentDtoToPayment(PaymentDto paymentDto){
        return new Payment(
                paymentDto.getLoan(),
                paymentDto.getAmount_Payment()
        );
    }

    public static PaymentResponseDto paymentToPaymentResponseDto(Payment payment){
        PaymentResponseDto paymentResponseDto = new PaymentResponseDto();
        paymentResponseDto.setAmount_Payment(payment.getAmount_Payment());
        paymentResponseDto.setLocalDateTime(payment.getLocalDateTime());

        List< BillResponseDto> billResponseDto = new ArrayList<>();
        for(Bill b : payment.getBill()){
            billResponseDto.add(BillMapper.billToBillResponseDto(b));
        }
        paymentResponseDto.setBill(billResponseDto);
        return paymentResponseDto;
    }

}
