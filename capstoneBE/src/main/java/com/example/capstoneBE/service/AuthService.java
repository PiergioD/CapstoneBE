package com.example.capstoneBE.service;



import com.example.capstoneBE.payload.JWTAuthResponse;
import com.example.capstoneBE.payload.LoginDto;
import com.example.capstoneBE.payload.RegisterDto;

public interface AuthService {
    
	JWTAuthResponse login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
