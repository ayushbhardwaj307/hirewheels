package com.upgrad.hirewheels.dto;

import lombok.Data;

@Data
public class LoginDTO {
    String email;
    String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
