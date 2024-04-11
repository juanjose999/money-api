package com.loans.money.repository.client;

import com.loans.money.dto.client.ClientDto;
import com.loans.money.dto.client.ClientMapper;
import com.loans.money.entity.Admin;
import com.loans.money.entity.Client;
import com.loans.money.entity.Loan;
import com.loans.money.repository.admin.AdminRepository;
import com.loans.money.repository.loan.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Repository
public class ClientRepositoryImpl implements ClientRepository{


    private final ClientRepositoryJpa clientRepositoryJpa;
    private final AdminRepository adminRepository;
    private final LoanRepository loanRepository;

    @Override
    public List<Client> allClients() {
        return clientRepositoryJpa.findAll();
    }

    @Override
    public Optional<Client> findClientById(Long id) {
        return clientRepositoryJpa.findById(id);
    }

    @Override
    public Optional<List<Client>> findByFirst_nameOrLast_nameContaining(String keyword) {
        return Optional.ofNullable(clientRepositoryJpa.findByFirstNameOrLastNameContaining(keyword));
    }

    @Override
    public List<Client> findAdminById(Integer idAdmin) {
        List<Client> clientList = allClients();
        List<Client> clientsIncludes = new ArrayList<>();
        for (Client c : clientList){
            if(c.getAdmin().getId_admin().equals(idAdmin)){
                clientsIncludes.add(c);
            }
        }
        return clientsIncludes;
    }

//    @Override
//    public Client saveClient(Client client) {
//        return clientRepositoryJpa.save(client);
//    }

    public Client saveClientWithLoan(Client client, Integer idAdmin){
        Client savedClient = clientRepositoryJpa.save(client);
        List<Loan> loans = new ArrayList<>();
        for (Loan lo : client.getLoans_list()){
            Loan save = loanRepository.saveLoan(lo);
            save.setClient_data(savedClient);
            loans.add(save);
        }
        // Buscar el administrador en base al ID obtenido
        Admin findAdmin = adminRepository.findAdmin(idAdmin)
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        // Asignar el administrador al cliente y la lista de loans con su id
        savedClient.setAdmin(findAdmin);
        savedClient.setLoans_list(loans);

        // Llamar a saveLoands con los préstamos para generar sus valores
        loanRepository.updateDetailsLoan(savedClient, loans);

        return savedClient;
    }

    @Override
    public Client updateClient(Long id, Client client) {
        return findClientById(id).map(existing -> {
            existing.setFirstName(client.getFirstName());
            existing.setLastName(client.getLastName());
            existing.setPhone_number(client.getPhone_number());
            existing.setLoans_list(client.getLoans_list());
            return clientRepositoryJpa.save(existing);
        }).orElse(null);
    }

    @Override
    public Boolean deleteClientById(Long id) {
        return findClientById(id).map(client -> {
            clientRepositoryJpa.delete(client);
            return true;
        }).orElse(false);
    }
}
