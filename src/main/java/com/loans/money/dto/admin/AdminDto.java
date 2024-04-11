package com.loans.money.dto.admin;

import com.loans.money.entity.Client;
import com.loans.money.entity.Role;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static com.loans.money.entity.Role.ADMIN;
@Getter
@Setter
@NoArgsConstructor
public class AdminDto {
    private String full_name;
    private String password_admin;
    private Enum<Role> role = ADMIN;
    private List<Client> client_list;

    public AdminDto(String full_name, String password_admin) {
        this.full_name = full_name;
        this.password_admin = password_admin;
        this.role = getRole();
        client_list =new ArrayList<>();
    }


}
