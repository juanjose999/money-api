package com.loans.money.dto.loan;

import com.loans.money.dto.payment.PaymentResponseDto;
import com.loans.money.entity.Client;
import com.loans.money.entity.Payment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class LoanResponseDto {
    private Client client_data;
    private BigDecimal loan;
    private String date_loan;
    private double interest;
    private double debt_interests_month;
    private Integer months_debt;
    private BigDecimal debt_total;
    private boolean is_active = true;
    private List<PaymentResponseDto> payments;

    public LoanResponseDto( BigDecimal loan, double interest, String date_loan) {
        this.client_data = getClient_data();
        this.loan = loan;
        this.interest = interest;
        this.date_loan = date_loan;
        this.debt_interests_month = getDebt_interests_month();
        this.months_debt = getMonths_debt();
        this.debt_total = getDebt_total();
        this.payments = getPayments();
        this.is_active = true;
    }
}
