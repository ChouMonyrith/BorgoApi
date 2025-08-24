package com.rith.borgoappapi.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SignUpRequest {
    private String firstName;
    private String lastName;
    private String name;
    private String email;
    private String phone;
    private LocalDate dateOfBirth;
    private String location;
    private String gender;
    private String photo;
    private String password;
}
