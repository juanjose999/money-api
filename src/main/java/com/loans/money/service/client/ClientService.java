package com.loans.money.service.client;

import com.loans.money.dto.client.ClientDto;
import com.loans.money.dto.client.ClientResponseDto;
import com.loans.money.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<ClientResponseDto> allClients();
    Optional<ClientResponseDto> findClientById(Long id);
    Optional<List<ClientResponseDto>> findByFirst_nameOrLast_nameContaining(String keyword);
    ClientResponseDto saveClient(ClientDto clientDto, Integer idAdmin);
    ClientResponseDto updateClient(Long id, ClientDto clientDto);
    Boolean deleteClientById(Long id);
}
