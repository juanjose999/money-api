package com.loans.money.service.payment;

import com.loans.money.dto.payment.PaymentDto;
import com.loans.money.dto.payment.PaymentMapper;
import com.loans.money.dto.payment.PaymentResponseDto;
import com.loans.money.entity.Bill;
import com.loans.money.entity.Client;
import com.loans.money.entity.Loan;
import com.loans.money.entity.Payment;
import com.loans.money.repository.admin.AdminRepository;
import com.loans.money.repository.bill.BillRepository;
import com.loans.money.repository.client.ClientRepository;
import com.loans.money.repository.loan.LoanRepository;
import com.loans.money.repository.payment.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{

    private final PaymentRepository paymentRepository;
    @Override
    public List<PaymentResponseDto> allPayment() {
        List<PaymentResponseDto> listPayment = new ArrayList<>();
        paymentRepository.allPayment().forEach(payment -> listPayment.add(PaymentMapper.paymentToPaymentResponseDto(payment)));
        return listPayment;
    }

    @Override
    public Optional<PaymentResponseDto> findPaymentById(Long id) {
        Optional<Payment> findPayment = paymentRepository.findPaymentById(id);
        return findPayment.map(PaymentMapper::paymentToPaymentResponseDto);
    }

    @Override
    public PaymentResponseDto savePayment(Long loanId, Double amount_payment) {
        return PaymentMapper.paymentToPaymentResponseDto(paymentRepository.savePaymentWithBill(loanId,amount_payment));
    }
    @Override
    public PaymentResponseDto updatePayment(Long id, PaymentDto paymentDto) {
        return PaymentMapper.paymentToPaymentResponseDto(paymentRepository.updatePayment(id, PaymentMapper.paymentDtoToPayment(paymentDto)));
    }
    @Override
    public Boolean deletePayment(Long id) {
        return paymentRepository.deletePayment(id);
    }
}
