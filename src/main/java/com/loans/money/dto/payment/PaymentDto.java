package com.loans.money.dto.payment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.loans.money.entity.Bill;
import com.loans.money.entity.Loan;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {

    private LocalDateTime localDateTime;
    private Loan loan;
    private BigDecimal debt_before_payment;
    private Double amount_Payment;
    private BigDecimal debt_total_actually;
    private List<Bill> bill;

    public PaymentDto( Loan loan, Double amount_Payment) {
        this.localDateTime = LocalDateTime.now();
        this.loan = loan;
        this.debt_before_payment = getDebt_before_payment();
        this.amount_Payment = amount_Payment;
        this.debt_total_actually = getDebt_total_actually();
        this.bill = new ArrayList<>();
    }
}
