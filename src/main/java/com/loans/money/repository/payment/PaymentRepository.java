package com.loans.money.repository.payment;

import com.loans.money.entity.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository {
    List<Payment> allPayment();
    Optional<Payment> findPaymentById(Long id);
    Payment savePayment(Payment payment);
    Payment savePaymentWithBill(Long loanId, Double amount_payment);
    Payment updatePayment (Long id, Payment payment);
    Boolean deletePayment (Long id);
}
