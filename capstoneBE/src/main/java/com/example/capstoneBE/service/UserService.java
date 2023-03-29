package com.example.capstoneBE.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.capstoneBE.entity.Esercizio;
import com.example.capstoneBE.entity.User;
import com.example.capstoneBE.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired UserRepository repo;
	
	//crea
			public User create(User s) {
				repo.save(s);
				return s;
			}
			
			
			// crea tutte
			public void creaAll(List<User> list) {
				repo.saveAll(list);
			}
			
			
			//get by id
			public User getbyId(Long id) {
				return repo.findById(id).orElseThrow(()-> new EntityNotFoundException("l'Utente con questo id non esiste!"));
			}
			
			
			//put
			public User put(User s) {
				repo.save(s);
				return s;
			}
			
			
			// delete
			public User deleteById(Long id) {
				User es = getbyId(id);
				repo.deleteById(id);
				return es;
				
			}
	
	
}
