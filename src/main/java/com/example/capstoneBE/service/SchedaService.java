package com.example.capstoneBE.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import com.example.capstoneBE.entity.Esercizio;
import com.example.capstoneBE.entity.Scheda;
import com.example.capstoneBE.entity.User;
import com.example.capstoneBE.repository.SchedaRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class SchedaService {

	
	@Autowired SchedaRepository repo;
	
	
	
	//crea
	public Scheda createScheda(Scheda s) {
		repo.save(s);
		return s;
	}
	
	
	// crea tutte
	public void creaAll(List<Scheda> list) {
		repo.saveAll(list);
	}
	
	
	
	// leggi tutte
		public Page<Scheda> getAll(Pageable sorting) {
			return repo.findAll(sorting);
		}
	
	
		
		// modifica scheda
		public Scheda updateScheda(Scheda d) {
			
			
			
		
			
			repo.save(d);
			return d;
		}	
		
		
		
	//get by id
	public Scheda getbyId(Long id) {
		return repo.findById(id).orElseThrow(()-> new EntityNotFoundException("la scheda con questo id non esiste!"));
	}
	
	
	
	
	
	// delete
	public Scheda deleteById(Long id) {
		Scheda scheda = getbyId(id);
		repo.deleteById(id);
		return scheda;
		
	}
	// cerca una scheda in base ad utente
	public List<Scheda> cercaTramiteUtente(Optional<User> utentePreso){
		
		return repo.findByUtente(utentePreso);
		
	}
	
	
	
	// da mettere--> ordina una scheda in base al gruppo muscolare richiesto
	
	
	// da mettere ordina per data 
	public Page<Scheda> ordinaPerData(Pageable pageable){
		var listedSortedByData=repo.findByOrderByData();
		Page<Scheda> sortedSchedaPage= PageableExecutionUtils.getPage(listedSortedByData, pageable, ()->listedSortedByData.size());
		return sortedSchedaPage;
	}
	
	
	//metodino per fitlrare per data specifica
	public Page<Scheda> cercaTramiteData(LocalDate date,Pageable pageable){
		var listaFiltrataPerData= repo.findByData(date);
		Page<Scheda> schedeConDataUguale= PageableExecutionUtils.getPage(listaFiltrataPerData, pageable, ()->listaFiltrataPerData.size());
		return schedeConDataUguale;}
		
		
		
		// filtra per nome containing
	public Page<Scheda> cercaTramiteNome(String nome,Pageable pageable){
		var listFiltrataperNome= repo.findByNomeContaining(nome);
		Page<Scheda> schedePerNome=PageableExecutionUtils.getPage(listFiltrataperNome, pageable, ()->listFiltrataperNome.size());
		return schedePerNome;
	}
		
	
	// eliminmo la scheda tramite user
	  @Transactional
	    public void deleteScheda(Long schedaId, Long userId) {
	        repo.deleteScheda(schedaId, userId);
	    }
}
