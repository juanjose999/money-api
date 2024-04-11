package com.loans.money.service.payment;

import com.loans.money.dto.payment.PaymentDto;
import com.loans.money.dto.payment.PaymentResponseDto;
import com.loans.money.entity.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    List<PaymentResponseDto> allPayment();
    Optional<PaymentResponseDto> findPaymentById(Long id);
    PaymentResponseDto savePayment(Long loanId, Double amount_payment);
    PaymentResponseDto updatePayment (Long id, PaymentDto payment);
    Boolean deletePayment (Long id);
}
