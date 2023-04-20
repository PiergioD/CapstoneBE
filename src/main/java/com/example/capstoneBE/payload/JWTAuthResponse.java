package com.example.capstoneBE.payload;

import java.util.List;
import java.util.Set;

import com.example.capstoneBE.entity.Role;
import com.example.capstoneBE.entity.Scheda;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JWTAuthResponse {
	private String username;
	private String email;
	private  Long id;
	private String name;
	private List<Scheda>schede;
	private Set<Role> roles;
    private String accessToken;
    private String tokenType = "Bearer";
}
