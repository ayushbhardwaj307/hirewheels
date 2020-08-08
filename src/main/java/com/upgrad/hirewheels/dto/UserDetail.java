package com.upgrad.hirewheels.dto;

import lombok.Data;


@Data
public class UserDetail {
    int userId;
    String firstName;
    String lastName;
    String email;
    String mobileNumber;
    double walletMoney;
    String successMessage;
    String roleName;
}
