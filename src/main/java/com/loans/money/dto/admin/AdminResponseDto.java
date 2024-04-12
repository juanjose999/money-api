package com.loans.money.dto.admin;

import com.loans.money.dto.client.ClientResponseDto;
import com.loans.money.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AdminResponseDto {
    private String full_name;
    private  List<ClientResponseDto> client_list;
    public AdminResponseDto(String full_name, List<ClientResponseDto> clientList) {
        this.full_name = full_name;
        this.client_list = clientList.isEmpty() ? new ArrayList<>():clientList;
    }
    public AdminResponseDto(String full_name) {
        this.full_name = full_name;
        client_list = new ArrayList<>();
    }

}
