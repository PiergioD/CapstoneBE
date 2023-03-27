package com.example.capstoneBE.service;



import com.example.capstoneBE.payload.LoginDto;
import com.example.capstoneBE.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
