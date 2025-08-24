package com.rith.borgoappapi.service;

import com.rith.borgoappapi.dto.LoginRequest;
import com.rith.borgoappapi.dto.LoginResponse;
import com.rith.borgoappapi.dto.SignUpRequest;
import com.rith.borgoappapi.model.User;

public interface AuthService {
    User signUp(SignUpRequest signUpRequest);
    LoginResponse login(LoginRequest loginRequest);
}

