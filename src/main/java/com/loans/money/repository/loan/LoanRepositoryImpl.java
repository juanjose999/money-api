package com.loans.money.repository.loan;

import com.loans.money.entity.Client;
import com.loans.money.entity.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class LoanRepositoryImpl implements LoanRepository {

    @Autowired
    private LoanRepositoryJpa loanRepositoryJpa;

    @Override
    public List<Loan> allLoans() {
        return loanRepositoryJpa.findAll();
    }

    @Override
    public Optional<Loan> findLoanById(Long id) {
        return loanRepositoryJpa.findById(id);
    }

    @Override
    public Loan saveLoan(Loan loan) {
        return loanRepositoryJpa.save(loan);
    }

    @Override
    public Loan updateLoan(Long id, Loan loan) {
        return findLoanById(id).map(existingLoan -> {
            existingLoan.setLoan(loan.getLoan());
            existingLoan.setInterest(loan.getInterest());
            existingLoan.setDate_loan(loan.getDate_loan());
            existingLoan.setDebt_interests_month(loan.getDebt_interests_month());
            existingLoan.setMonths_debt(loan.getMonths_debt());
            existingLoan.setDebt_total(loan.getDebt_total());
            return saveLoan(existingLoan);
        }).orElse(null);
    }

    public void updateDetailsLoan(Client client, List<Loan> loanList){
        List<Loan> loans = new ArrayList<>();
        for(Loan loan : loanList){
            BigDecimal decimalLoan = loan.getLoan();
            double interestMonth = (loan.getInterest() * (decimalLoan.doubleValue() / 100));
            loan.setDebt_interests_month(interestMonth);

            LocalDate localDateLoan = LocalDate.parse(loan.getDate_loan(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Period period = Period.between(localDateLoan, LocalDate.now());
            int months_debt = period.getMonths();
            if (period.getDays()>0){
                months_debt++;
            }
            loan.setMonths_debt(months_debt);
            BigDecimal interest_debt = BigDecimal.valueOf(interestMonth * months_debt);
            BigDecimal debt_total = decimalLoan.add(interest_debt);
            loan.setDebt_total(debt_total);
            loans.add(saveLoan(loan));
        }
        client.setLoans_list(loans);
    }

    @Override
    public Boolean deleteLoanById(Long id) {
        return findLoanById(id).map(loan -> {
            loanRepositoryJpa.delete(loan);
            return true;
        }).orElse(false);
    }

}
