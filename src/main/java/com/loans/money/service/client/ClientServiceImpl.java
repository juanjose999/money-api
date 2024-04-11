package com.loans.money.service.client;

import com.loans.money.dto.admin.AdminMapper;
import com.loans.money.dto.client.ClientDto;
import com.loans.money.dto.client.ClientMapper;
import com.loans.money.dto.client.ClientResponseDto;
import com.loans.money.dto.loan.LoanMapper;
import com.loans.money.dto.loan.LoanResponseDto;
import com.loans.money.entity.Admin;
import com.loans.money.entity.Client;
import com.loans.money.entity.Loan;
import com.loans.money.repository.admin.AdminRepository;
import com.loans.money.repository.client.ClientRepository;
import com.loans.money.repository.loan.LoanRepository;
import com.loans.money.service.client.ClientService;
import com.loans.money.service.loan.LoanService;
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
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final AdminRepository adminRepository;
    private final LoanRepository loanRepository;
    private final LoanService loanService;
    @Override
    public List<ClientResponseDto> allClients() {
        List<ClientResponseDto> clientResponseDto = new ArrayList<>();
        clientRepository.allClients().forEach(client -> clientResponseDto.add(ClientMapper.clientToClientResponseDto(client)));
        return clientResponseDto;
    }

    @Override
    public Optional<ClientResponseDto> findClientById(Long id) {
        Optional<Client> findClient = clientRepository.findClientById(id);
        if(findClient.isPresent()){
            return Optional.of(ClientMapper.clientToClientResponseDto(findClient.get()));
        }else throw new RuntimeException("Error in find client by id.");
    }

    @Override
    public Optional<List<ClientResponseDto>> findByFirst_nameOrLast_nameContaining(String keyword) {
        List<Client> findByName = clientRepository.findByFirst_nameOrLast_nameContaining(keyword).orElse(null);
        List<ClientResponseDto> clientList = new ArrayList<>();
        if (findByName !=null) {
            for(Client c : findByName){
                clientList.add(ClientMapper.clientToClientResponseDto(c));
            }
        }
        return Optional.of(clientList);
    }
    @Override
    public ClientResponseDto saveClient(ClientDto clientDto, Integer idAdmin) {
        Client client = clientRepository.saveClientWithLoan(ClientMapper.clientDtoToClient(clientDto), idAdmin);
        return ClientMapper.clientToClientResponseDto(client);
    }

    @Override
    public ClientResponseDto updateClient(Long id, ClientDto clientDto) {
        return ClientMapper.clientToClientResponseDto(clientRepository.updateClient(id, ClientMapper.clientDtoToClient(clientDto)));
    }

    @Override
    public Boolean deleteClientById(Long id) {
        return clientRepository.deleteClientById(id);
    }
}
