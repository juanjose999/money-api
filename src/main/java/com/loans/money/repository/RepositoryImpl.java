package com.loans.money.repository;

import com.loans.money.entity.Bill;
import com.loans.money.entity.Client;
import com.loans.money.entity.Loan;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RepositoryImpl implements AllMethodsRepository {

    private final RepositoryAdminJpa repositoryAdminJpa;
    private final RepositoryJpaClients repositoryJpaClients;
    private final RepositoryJpaBill repositoryJpaBill;
    private final RepositoryJpaPayments repositoryJpaPayments;
    private final RepositoryJpaLoads repositoryJpaLoads;


    @Override
    public Client saveNewClient(Client client) {
        return repositoryJpaClients.save(client);
    }

    @Override
    public List<?> allClients() {
        return repositoryJpaClients.findAll();
    }

    @Override
    public Optional<Client> findClientById(Long idClient) {
        return repositoryJpaClients.findById(idClient);
    }

    @Override
    public Loan saveNewLoan(Loan loan) {
        return repositoryJpaLoads.save(loan);
    }

    @Override
    public Loan updateLoan(Long idLoan, Loan loan) {
        Optional<Loan> findById = repositoryJpaLoads.findById(idLoan);
        if(findById.isPresent()){
            Loan existingLoan = findById.get();
            existingLoan.setClientData(loan.getClientData());
            existingLoan.setAmountmoney(loan.getAmountmoney());
            existingLoan.setInterest(loan.getInterest());
            existingLoan.setIsactive(loan.isIsactive());
            existingLoan.setPayment(loan.getPayment());
            return repositoryJpaLoads.save(existingLoan);
        }else{
            throw new RuntimeException("Loan not found.");
        }
    }

    @Override
    public Bill saveNewBill(Bill bill) {
        return repositoryJpaBill.save(bill);
    }
}
