package com.loans.money.dto.admin;

import com.loans.money.dto.client.ClientResponseDto;
import com.loans.money.entity.Admin;
import com.loans.money.entity.Client;

import java.util.List;

public class AdminMapper {

    public static Admin adminDtoToAdmin(AdminDto adminDto){
        return new Admin(
                adminDto.getFull_name(),
                adminDto.getPassword_admin()
        );
    }

    public static AdminResponseDto adminToAdminResponseDto (Admin admin, List<ClientResponseDto> clientList){
        return new AdminResponseDto(
                admin.getFull_name(),
                clientList
        );
    }
    public static AdminResponseDto adminToAdminResponseDto (Admin admin){
        return new AdminResponseDto(
                admin.getFull_name()
        );
    }

}
