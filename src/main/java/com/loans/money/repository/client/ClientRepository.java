package com.loans.money.repository.client;

import com.loans.money.entity.Admin;
import com.loans.money.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    List<Client> allClients();
    Optional<Client> findClientById(Long id);
    Optional<List<Client>> findByFirst_nameOrLast_nameContaining(String keyword);
    List<Client>findAdminById(Integer idAdmin);
//    Client saveClient(Client client);
    Client saveClientWithLoan(Client client, Integer idAdmin);
    Client updateClient(Long id, Client client);
    Boolean deleteClientById(Long id);


}
