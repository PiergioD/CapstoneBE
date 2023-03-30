package com.example.capstoneBE.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.capstoneBE.entity.Esercizio;
import com.example.capstoneBE.entity.Scheda;
import com.example.capstoneBE.entity.User;
import com.example.capstoneBE.service.EsercizioService;
import com.example.capstoneBE.service.SchedaService;
import com.example.capstoneBE.service.UserService;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("api/capstone/utente")
public class UserController {

	@Autowired UserService service;
	@Autowired SchedaService serviceScheda;
	@Autowired EsercizioService serviceEse;
	
	
	
	// prendimi le schede da username
	@GetMapping("/scheda/{username}")
    @PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
	public ResponseEntity<List<Scheda>> getSchedeUser(@PathVariable String username){
		
		Optional<User> utentePreso=service.cercaTramiteNome(username);
		List<Scheda> schedePrese= serviceScheda.cercaTramiteUtente(utentePreso);
		
		
		return new ResponseEntity<>(schedePrese,HttpStatus.OK);
	}
	
	
	// TODO cercami esercizi di una certa scheda secondo id
	 @GetMapping("/{userId}/schede/{schedaId}/esercizi")
	 @PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
	    public Set<Esercizio> getEserciziBySchedaAndUtente(@PathVariable Long userId, @PathVariable Long schedaId) {
	        return serviceEse.getEserciziBySchedaAndUtente(userId, schedaId);
	    }
	
	
	// cerca per username
    @GetMapping("/username/{username}")
    @PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
    public ResponseEntity<Optional<User>> getUserbyUsername(@PathVariable String username){
    	return new ResponseEntity<>(service.cercaTramiteNome(username),HttpStatus.OK);
    }
    
	// cerca per email
    @GetMapping("/email/{email}")
    @PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
    public ResponseEntity<Optional<User>> getUserbyEmail(@PathVariable String email){
    	return new ResponseEntity<>(service.cercaTramiteNome(email),HttpStatus.OK);
    }
	
	
	// get by id
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
    public ResponseEntity<User> getUtenteById(@PathVariable long id){
        return  new ResponseEntity<>(service.getbyId(id), HttpStatus.OK);
    }
	
    
   
    
   //delete un esercizio tramite id utente, id scheda e id esercizio
    @DeleteMapping("/{userId}/delete/schede/{schedaId}/esercizi/{esercizioId}")
    @PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
    public ResponseEntity<?> deleteEsercizio(@PathVariable("userId") Long userId, @PathVariable("schedaId") Long schedaId, @PathVariable("esercizioId") Long esercizioId) {
        serviceEse.deleteEsercizio(esercizioId, userId, schedaId);
        return ResponseEntity.ok().build();
    }
    
    
    // delete una scheda tramite id utente e id scheda
    @DeleteMapping("/{userId}/delete/schede/{schedaId}")
    @PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
    public ResponseEntity<?> deleteScheda(@PathVariable("userId") Long userId, @PathVariable("schedaId") Long schedaId) {
        serviceScheda.deleteScheda(schedaId, userId);
        return ResponseEntity.ok().build();
    }
    
    
    //TODO user modifica un esercizio
    
    //TODO user modifica una scheda
    
    
  //delete
    @DeleteMapping ("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
    public ResponseEntity<User> deleteUtente(@PathVariable long id){

        
        return new ResponseEntity<>(service.deleteById(id), HttpStatus.OK);}
	
	
}
