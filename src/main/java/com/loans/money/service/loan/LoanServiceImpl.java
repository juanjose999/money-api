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
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LoanServiceImpl implements LoanService{
    private final LoanRepository loanRepository;
    @Override
    public List<LoanResponseDto> allLoans() {
        return loanRepository.allLoans().stream()
                .map(this::mapToLoanResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<LoanResponseDto> findLoanById(Long id) {
        return loanRepository.findLoanById(id).map(this::mapToLoanResponseDto);
    }

    private LoanResponseDto mapToLoanResponseDto(Loan loan) {
        LoanResponseDto loanResponseDto = new LoanResponseDto();
        loanResponseDto.setLoan(loan.getLoan());
        loanResponseDto.setDate_loan(loan.getDate_loan());
        loanResponseDto.setInterest(loan.getInterest());
        loanResponseDto.setDebt_interests_month(loan.getDebt_interests_month());
        loanResponseDto.setMonths_debt(loan.getMonths_debt());
        loanResponseDto.setDebt_total(loan.getDebt_total());
        List<PaymentResponseDto> paymentResponseDtos = loan.getPayments().stream()
                .map(PaymentMapper::paymentToPaymentResponseDto)
                .collect(Collectors.toList());
        loanResponseDto.setPayments(paymentResponseDtos);
        return loanResponseDto;
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
