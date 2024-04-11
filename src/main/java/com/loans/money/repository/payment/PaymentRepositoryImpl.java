package com.loans.money.repository.payment;

import com.loans.money.entity.Bill;
import com.loans.money.entity.Client;
import com.loans.money.entity.Loan;
import com.loans.money.entity.Payment;
import com.loans.money.repository.bill.BillRepository;
import com.loans.money.repository.client.ClientRepository;
import com.loans.money.repository.loan.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PaymentRepositoryImpl implements PaymentRepository{

    private final PaymentRepositoryJpa paymentRepositoryJpa;
    private final ClientRepository clientRepository;
    private final LoanRepository loanRepository;
    private final BillRepository billRepository;

    @Override
    public List<Payment> allPayment() {
        return paymentRepositoryJpa.findAll();
    }

    @Override
    public Optional<Payment> findPaymentById(Long id) {
        return paymentRepositoryJpa.findById(id);
    }

    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepositoryJpa.save(payment);
    }
    @Override
    public Payment savePaymentWithBill(Long loanId, Double amount_payment) {
        try {
            if (amount_payment == null) {
                throw new IllegalArgumentException("Amount payment cannot be null");
            }
            // Buscar el préstamo por su ID
            Loan loan = loanRepository.findLoanById(loanId)
                    .orElseThrow(() -> new RuntimeException("Loan not found"));

            Client c = clientRepository.findClientById(loan.getClient_data().getId_client()).orElseThrow(() -> new RuntimeException("client not fount"));

            BigDecimal debt_before_payment = loan.getDebt_total();

            BigDecimal updateLoanTotal = loan.getDebt_total().subtract(BigDecimal.valueOf(amount_payment));
            loan.setDebt_total(updateLoanTotal);

            Payment paymentNew = new Payment(loan, amount_payment);
            loan.getPayments().add(paymentNew);
            paymentNew.setDebt_total_actually(loan.getDebt_total());

            paymentNew.setDebt_before_payment(debt_before_payment);
            // Guardar el cliente y el préstamo en la base de datos
            loanRepository.saveLoan(loan);
            // Guardar el pago en la base de datos
            Payment savedPayment = savePayment(paymentNew);

            saveBill(savedPayment, loan);

            return savedPayment;
        } catch (Exception e) {
            System.err.println("Error saving payment: " + e.getMessage());
            throw new RuntimeException("Error in saving payment", e);
        }
    }

    public void saveBill(Payment savedPayment, Loan loan){
        Bill bill = new Bill(savedPayment);

        double decimalLoan = loan.getLoan().doubleValue();

        bill.setId_loan(savedPayment.getLoan().getId_loan());
        bill.setId_client(savedPayment.getLoan().getClient_data().getId_client());
        StringBuilder fullName = new StringBuilder();
        fullName.append(savedPayment.getLoan().getClient_data().getFirstName()).append(" ");
        fullName.append(savedPayment.getLoan().getClient_data().getLastName());
        bill.setFull_name_client(fullName.toString());
        bill.setLoan_initial(savedPayment.getLoan().getLoan());
        bill.setDebt_before_payment(savedPayment.getDebt_before_payment());
        bill.setAmount_payment(savedPayment.getAmount_Payment());
        BigDecimal bigDecimal = loan.getDebt_total();
        bill.setDebt_actually(bigDecimal);
        bill.setPayment(savedPayment);

        billRepository.saveBill(bill);
        List<Bill> bills = savedPayment.getBill();
        bills.add(bill);
        savedPayment.setBill(bills);

        // Registro de éxito
        System.out.println("Payment saved successfully");
    }

    @Override
    public Payment updatePayment(Long id, Payment payment) {
        return findPaymentById(id).map(existingPayment -> {
            existingPayment.setLoan(payment.getLoan());
            existingPayment.setAmount_Payment(payment.getAmount_Payment());
            return paymentRepositoryJpa.save(existingPayment);
        }).orElse(null);
    }

    @Override
    public Boolean deletePayment(Long id) {
        return findPaymentById(id).map(payment -> {
            paymentRepositoryJpa.delete(payment);
            return true;
        }).orElse(false);
    }
}
