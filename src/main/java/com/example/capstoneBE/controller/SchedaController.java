package com.example.capstoneBE.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.capstoneBE.entity.Scheda;
import com.example.capstoneBE.entity.User;
import com.example.capstoneBE.security.JwtTokenProvider;
import com.example.capstoneBE.service.SchedaService;
import com.example.capstoneBE.service.UserService;

@RestController

@RequestMapping("api/capstone/scheda")
public class SchedaController {

	
	
	@Autowired SchedaService service;
	@Autowired JwtTokenProvider provider;
	@Autowired UserService serviceUser;
	
	// create
	@PostMapping("dashboard/{id}/create")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<Scheda> postScheda(@PathVariable Long id, @RequestBody Scheda s){
		
		User user= serviceUser.getbyId(id);
		s.setUtente(user);
		
		
		service.createScheda(s);
		return new ResponseEntity<>(s,HttpStatus.OK);
		
		
	}
	
	
	 //get all schede con sorting dato dall utente(per nome o per data)
    @GetMapping("/page/{page}/{sortBy}")
    @PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
    public Page<Scheda> getAllScheda(@RequestHeader(name = "Authorization")String token,@PathVariable int page, @RequestParam(defaultValue = "10") int size, @PathVariable String sortBy) {
        
    	
    	
    
    	
    	
    	//TODO mi logga di nuovo il token! come lo recupero sto user?
//    	String username=provider.getUsername(token);
//    	System.out.println(username);
    	Pageable sorting= PageRequest.of(page, size, Sort.by(sortBy));
        return service.getAll(sorting);
    }
	
	// get by id
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<Scheda> getSchedaById(@PathVariable long id){
        return  new ResponseEntity<>(service.getbyId(id), HttpStatus.OK);
    }
	
    
    //modifica
    @PutMapping("/update/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<Scheda> updateScheda(@PathVariable Long id, @RequestBody Scheda schedaToUpdate ) {
		
    	Scheda schedaEsistente = service.getbyId(id);
    	
    	schedaEsistente.setNome(schedaToUpdate.getNome());
    
    	
    	return new ResponseEntity<Scheda>(service.updateScheda(schedaEsistente), HttpStatus.OK);
	}
    
    
    
    
  //delete
    @DeleteMapping ("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<Scheda> deleteCliente(@PathVariable long id){

        
        return new ResponseEntity<>(service.deleteById(id), HttpStatus.OK);}
    
    
    //cerca per data
    @GetMapping("/data/{data}/{page}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Page<Scheda> getByUltimoContatto(@PathVariable LocalDate data,@PathVariable int page, @RequestParam(defaultValue = "10") int size,@RequestParam(defaultValue="id") String sortBy){
    	Pageable sorting= PageRequest.of(page, size, Sort.by(sortBy));
    	return service.cercaTramiteData(data, sorting);
    }
    
    
    // cerca per parte del nome
    @GetMapping("/nome/{nome}/{page}")
    @PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
    public Page<Scheda> getByNome(@PathVariable String nome,@PathVariable int page, @RequestParam(defaultValue = "10") int size,@RequestParam(defaultValue="id") String sortBy){
    	Pageable sorting= PageRequest.of(page, size, Sort.by(sortBy));
    	return service.cercaTramiteNome(nome, sorting);
    }
    
    
  
    
	
}
