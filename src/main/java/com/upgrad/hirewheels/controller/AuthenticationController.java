package com.upgrad.hirewheels.controller;

import com.upgrad.hirewheels.dto.*;
import com.upgrad.hirewheels.entities.User;
import com.upgrad.hirewheels.exception.DuplicateUserDetailsException;
import com.upgrad.hirewheels.exception.GlobalExceptionHandler;
import com.upgrad.hirewheels.exception.UserRoleNotFoundException;
import com.upgrad.hirewheels.service.UserService;
import com.upgrad.hirewheels.util.DTOEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class AuthenticationController{

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public ResponseEntity userSignUp(@RequestBody UsersDTO userDTO) throws GlobalExceptionHandler, UserRoleNotFoundException, DuplicateUserDetailsException {
        ResponseEntity responseEntity = null;
        User user = userService.createUser(userDTO);
        if (user != null) {
            CustomResponse response = new CustomResponse(new Date(), "User Successfully Signed Up.", 200);
            responseEntity = new ResponseEntity(response, HttpStatus.OK);
        }
        return responseEntity;
    }

    @PostMapping("/users/access-token")
    public ResponseEntity userLogin(@RequestBody LoginDTO loginDTO) throws Exception {
        ResponseEntity responseEntity;
        UserDetail userDetail = new UserDetail();
            User inputUserDetails = userService.getUserDetails(loginDTO);
            if (inputUserDetails == null) {
                CustomResponse response = new CustomResponse(new Date(), "User Login Not Happened Successfully.", 403);
                responseEntity = new ResponseEntity(response, HttpStatus.NOT_FOUND);
                return responseEntity;
            }
            userDetail.setUserId(inputUserDetails.getUserId());
            userDetail.setFirstName(inputUserDetails.getFirstName());
            userDetail.setLastName(inputUserDetails.getLastName());
            userDetail.setEmail(inputUserDetails.getEmail());
            userDetail.setMobileNumber(inputUserDetails.getMobileNo());
            userDetail.setWalletMoney(inputUserDetails.getWalletMoney());
            userDetail.setRoleName(inputUserDetails.getUserRole().getRoleName());
            userDetail.setSuccessMessage("User Successfully Logged In.");
            return new ResponseEntity(userDetail, HttpStatus.OK);
    }

}
