package com.casemodul04.model.dto;

import com.casemodul04.model.Role;
import lombok.Data;

import java.util.List;
@Data
public class AccountToken {
    private String username;
    private String password;
    private String token;

    private List<Role> roles;

    public AccountToken(String username, String password, String token, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.token = token;
        this.roles = roles;
    }
}
