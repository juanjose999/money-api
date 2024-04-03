package com.loans.money.service.impl;

import com.loans.money.entity.Bill;
import com.loans.money.entity.Client;
import com.loans.money.entity.Loan;
import com.loans.money.repository.AllMethodsRepository;
import com.loans.money.service.AllMethodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ServiceImpl implements AllMethodsService {

    private final AllMethodsRepository allMethodsRepository;

    @Override
    public Client saveNewClient(Client client) {
        return allMethodsRepository.saveNewClient(client);
    }

    @Override
    public List<?> allClients() {
        return allMethodsRepository.allClients();
    }

    @Override
    public Optional<Client> findClientById(Long idClient) {
        return allMethodsRepository.findClientById(idClient);
    }

    @Override
    public Loan saveNewLoan(Loan loan) {
        return allMethodsRepository.saveNewLoan(loan);
    }

    @Override
    public Loan updateLoan(Long idLoan, Loan loan) {
        return allMethodsRepository.updateLoan(idLoan, loan);
    }

    @Override
    public Bill saveNewBill(Bill bill) {
        return allMethodsRepository.saveNewBill(bill);
    }
}
