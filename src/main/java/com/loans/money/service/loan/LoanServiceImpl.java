package com.loans.money.service.loan;

import com.loans.money.dto.loan.LoanDto;
import com.loans.money.dto.loan.LoanMapper;
import com.loans.money.dto.loan.LoanResponseDto;
import com.loans.money.dto.payment.PaymentMapper;
import com.loans.money.dto.payment.PaymentResponseDto;
import com.loans.money.entity.Client;
import com.loans.money.entity.Loan;
import com.loans.money.entity.Payment;
import com.loans.money.repository.loan.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class LoanServiceImpl implements LoanService{
    private final LoanRepository loanRepository;
    @Override
    public List<LoanResponseDto> allLoans() {
        List<Loan> loanList = loanRepository.allLoans();
        List<LoanResponseDto> loanResponseDto = new ArrayList<>();
        for(Loan l : loanList){
            LoanResponseDto loanNew = new LoanResponseDto();
            loanNew.setLoan(l.getLoan());
            loanNew.setDate_loan(l.getDate_loan());
            loanNew.setInterest(l.getInterest());
            loanNew.setDebt_interests_month(loanNew.getDebt_interests_month());
            loanNew.setDebt_interests_month(l.getDebt_interests_month());
            loanNew.setMonths_debt(l.getMonths_debt());
            loanNew.setDebt_total(l.getDebt_total());
            List<Payment> payments = l.getPayments();
            List<PaymentResponseDto> pdto = new ArrayList<>();
            for(Payment p : payments){
                PaymentResponseDto paymentNew = PaymentMapper.paymentToPaymentResponseDto(p);
                pdto.add(paymentNew);
            }
            loanNew.setPayments(pdto);
            loanResponseDto.add(loanNew);
        }
        return loanResponseDto;
    }

    @Override
    public Optional<LoanResponseDto> findLoanById(Long id) {
        Loan l= loanRepository.findLoanById(id).get();
        LoanResponseDto loanNew = new LoanResponseDto();
        loanNew.setLoan(l.getLoan());
        loanNew.setDate_loan(l.getDate_loan());
        loanNew.setInterest(l.getInterest());
        loanNew.setDebt_interests_month(loanNew.getDebt_interests_month());
        loanNew.setDebt_interests_month(l.getDebt_interests_month());
        loanNew.setMonths_debt(l.getMonths_debt());
        loanNew.setDebt_total(l.getDebt_total());
        List<Payment> payments = l.getPayments();
        List<PaymentResponseDto> pdto = new ArrayList<>();
        for(Payment p : payments){
            PaymentResponseDto paymentNew = PaymentMapper.paymentToPaymentResponseDto(p);
            pdto.add(paymentNew);
        }
        loanNew.setPayments(pdto);
        return Optional.of(loanNew);
    }

    @Override
    public LoanResponseDto saveLoan(LoanDto loanDto) {
        return LoanMapper.loanToLoanResponseDto(loanRepository.saveLoan(LoanMapper.loanDtoToLoan(loanDto)));
    }
    @Override
    public LoanResponseDto updateLoan(Long id, LoanDto loanDto) {
        return LoanMapper.loanToLoanResponseDto(loanRepository.updateLoan(id, LoanMapper.loanDtoToLoan(loanDto)));
    }

    @Override
    public Boolean deleteLoanById(Long id) {
        return loanRepository.deleteLoanById(id);
    }
}
