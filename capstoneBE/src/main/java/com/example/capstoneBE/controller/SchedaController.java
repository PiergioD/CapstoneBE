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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.capstoneBE.entity.Scheda;
import com.example.capstoneBE.service.SchedaService;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("api/capstone/scheda")
public class SchedaController {

	
	
	@Autowired SchedaService service;
	
	
	
	// create
	@PostMapping("/create")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Scheda> postScheda(@RequestBody Scheda s){
		
		service.createScheda(s);
		return new ResponseEntity<>(s,HttpStatus.OK);
		
		
	}
	
	
	 //get all schede con sorting dato dall utente(per nome o per data)
    @GetMapping("/page/{page}/{sortBy}")
    @PreAuthorize("hasRole('USER')")
    public Page<Scheda> getAllScheda(@PathVariable int page, @RequestParam(defaultValue = "10") int size, @PathVariable String sortBy) {
        Pageable sorting= PageRequest.of(page, size, Sort.by(sortBy));
        return service.getAll(sorting);
    }
	
	// get by id
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Scheda> getClienteById(@PathVariable long id){
        return  new ResponseEntity<>(service.getbyId(id), HttpStatus.OK);
    }
	
    
    //modifica
    @PutMapping("/update/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Scheda> updateScheda(@PathVariable Long id, @RequestBody Scheda schedaToUpdate ) {
		
    	Scheda schedaEsistente = service.getbyId(id);
    	
    	schedaEsistente.setNome(schedaToUpdate.getNome());
    
    	
    	return new ResponseEntity<Scheda>(service.updateScheda(schedaEsistente), HttpStatus.OK);
	}
    
    
    
    
  //delete
    @DeleteMapping ("/delete/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Scheda> deleteCliente(@PathVariable long id){

        
        return new ResponseEntity<>(service.deleteById(id), HttpStatus.OK);}
    
    
    //cerca per data
    @GetMapping("/data/{data}/{page}")
    @PreAuthorize("hasRole('USER')")
    public Page<Scheda> getByUltimoContatto(@PathVariable LocalDate data,@PathVariable int page, @RequestParam(defaultValue = "10") int size,@RequestParam(defaultValue="id") String sortBy){
    	Pageable sorting= PageRequest.of(page, size, Sort.by(sortBy));
    	return service.cercaTramiteData(data, sorting);
    }
    
    
    // cerca per parte del nome
    @GetMapping("/nome/{nome}/{page}")
    @PreAuthorize("hasRole('USER')")
    public Page<Scheda> getByNome(@PathVariable String nome,@PathVariable int page, @RequestParam(defaultValue = "10") int size,@RequestParam(defaultValue="id") String sortBy){
    	Pageable sorting= PageRequest.of(page, size, Sort.by(sortBy));
    	return service.cercaTramiteNome(nome, sorting);
    }
    
    
  
    
	
}