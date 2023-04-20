package com.example.capstoneBE.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.capstoneBE.payload.JWTAuthResponse;
import com.example.capstoneBE.payload.LoginDto;
import com.example.capstoneBE.payload.RegisterDto;
import com.example.capstoneBE.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private AuthService authService;

	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	// Build Login REST API

	@PostMapping(value = { "/login", "/signin" })
	public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto loginDto) {

		return ResponseEntity.ok(authService.login(loginDto));
	}

	// Build Register REST API

	@PostMapping(value = { "/register", "/signup" })
	public ResponseEntity<RegisterDto> register(@RequestBody RegisterDto registerDto) {
		String response = authService.register(registerDto);
		return new ResponseEntity<>(registerDto, HttpStatus.CREATED);
	}
}
