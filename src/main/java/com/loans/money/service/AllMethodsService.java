package com.loans.money.service;

import com.loans.money.entity.Bill;
import com.loans.money.entity.Client;
import com.loans.money.entity.Loan;

import java.util.List;
import java.util.Optional;

public interface AllMethodsService {
        Client saveNewClient(Client client);
        List<?> allClients();
        Optional<Client> findClientById(Long idClient);
        Loan saveNewLoan(Loan loan);
        Loan updateLoan(Long idLoan, Loan loan);
        Bill saveNewBill(Bill bill);

}
