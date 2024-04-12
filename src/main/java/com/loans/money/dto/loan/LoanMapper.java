package com.loans.money.dto.loan;

import com.loans.money.dto.payment.PaymentMapper;
import com.loans.money.dto.payment.PaymentResponseDto;
import com.loans.money.entity.Loan;
import com.loans.money.entity.Payment;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;

public class LoanMapper {

    public static Loan loanDtoToLoan(LoanDto loanDto){
        return new Loan(
                loanDto.getLoan(),
                loanDto.getInterest(),
                loanDto.getDate_loan()
        );
    }

    public static LoanResponseDto loanToLoanResponseDto (Loan loan){
        List<Payment> payments = loan.getPayments();
        List<PaymentResponseDto> payment =  new ArrayList<>();
        payments.forEach(p -> payment.add(PaymentMapper.paymentToPaymentResponseDto(p)));
        return new LoanResponseDto(
                loan.getLoan(),
                loan.getInterest(),
                loan.getDate_loan(),
                payment
        );

    }
}
