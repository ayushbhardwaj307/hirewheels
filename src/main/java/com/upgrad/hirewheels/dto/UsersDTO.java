package com.upgrad.hirewheels.dto;

import lombok.Data;

@Data
public class UsersDTO {
    String firstName;
    String lastName;
    String email;
    String password;
    String mobileNo;
    double walletMoney;
    int userRoleId;
    public String getEmail() {
        return email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
