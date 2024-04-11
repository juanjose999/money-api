package com.loans.money.controller;

import com.loans.money.dto.client.ClientDto;
import com.loans.money.dto.client.ClientResponseDto;
import com.loans.money.entity.Client;
import com.loans.money.service.client.ClientService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/client")
@CrossOrigin("*")
public class ClientController {

    private final  ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientResponseDto>> allClients(){
        return ResponseEntity.ok(clientService.allClients());
    }

    @GetMapping("/{idClient}")
    public ResponseEntity<ClientResponseDto> findClientById(@PathVariable Long idClient){
        return ResponseEntity.of(clientService.findClientById(idClient));
    }

    @GetMapping("name/{keyword}")
    public ResponseEntity<List<ClientResponseDto>> findClientByName(@PathVariable String keyword){
        return ResponseEntity.of(clientService.findByFirst_nameOrLast_nameContaining(keyword));
    }

    @PostMapping("/save/{idAdmin}")
    public ResponseEntity<ClientResponseDto> saveNewClient(@PathVariable Integer idAdmin,@RequestBody ClientDto clientDto){
        ClientResponseDto savedClient = clientService.saveClient(clientDto,idAdmin);
        return ResponseEntity.ok(savedClient);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteClientById(@PathVariable  Long id){
        return new ResponseEntity<>(clientService.deleteClientById(id),HttpStatus.OK);
    }
}
