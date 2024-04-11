package com.loans.money.dto.payment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.loans.money.dto.bill.BillResponseDto;
import com.loans.money.entity.Bill;
import com.loans.money.entity.Loan;
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
public class PaymentResponseDto {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime localDateTime;
    @JsonIgnore
    private Loan loan;
    @JsonIgnore
    private BigDecimal debt_before_payment;

    private Double amount_Payment;
    @JsonIgnore
    private BigDecimal debt_total_actually;
    private List<BillResponseDto> bill;

    public PaymentResponseDto( Loan loan, Double amount_Payment, List<BillResponseDto> bill) {
        this.localDateTime = LocalDateTime.now();
        this.loan = loan;
        this.amount_Payment = amount_Payment;
        this.bill = bill;
    }

}
