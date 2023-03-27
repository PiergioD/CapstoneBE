package com.example.capstoneBE.service;

import java.util.List;

import org.modelmapper.internal.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener.ErrorEscalating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import com.example.capstoneBE.entity.Esercizio;
import com.example.capstoneBE.entity.GruppiMuscolari;
import com.example.capstoneBE.entity.Scheda;
import com.example.capstoneBE.repository.EsercizioRepository;

import jakarta.persistence.EntityNotFoundException;

public class EsercizioService {

	@Autowired EsercizioRepository repo;
	
	
	
	//crea
		public Esercizio create(Esercizio s) {
			repo.save(s);
			return s;
		}
		
		
		// crea tutte
		public void creaAll(List<Esercizio> list) {
			repo.saveAll(list);
		}
		
		
		//get by id
		public Esercizio getbyId(Long id) {
			return repo.findById(id).orElseThrow(()-> new EntityNotFoundException("l'esercizio con questo id non esiste!"));
		}
		
		
		//put
		public Esercizio put(Esercizio s) {
			repo.save(s);
			return s;
		}
		
		
		// delete
		public Esercizio deleteById(Long id) {
			Esercizio es = getbyId(id);
			repo.deleteById(id);
			return es;
			
		}
	
		
		
		//metodino per cercare per gruppo muscolare
		public Page<Esercizio> cercaTramiteMuscolo(GruppiMuscolari muscolo,Pageable pageable){
			var listFiltrataperMuscolo= repo.findByMuscolo(muscolo);
			Page<Esercizio> eserciziPerMuscolo=PageableExecutionUtils.getPage(listFiltrataperMuscolo, pageable, ()->listFiltrataperMuscolo.size());
			return eserciziPerMuscolo;
		}
		
		// metodino per cercare per parte del nome esercizio
		public Page<Esercizio> cercaTramiteNome(String nome,Pageable pageable){
			var listFiltrataperNome= repo.findByNomeContaining(nome);
			Page<Esercizio> eserciziPerNome=PageableExecutionUtils.getPage(listFiltrataperNome, pageable, ()->listFiltrataperNome.size());
			return eserciziPerNome;
		}
		
//		// metodino per cercare tramite nome scheda 
//	public Page<Esercizio> cercaTramiteNomeScheda(String nome,Pageable pageable){
//		var listFiltrataPerNomeScheda = repo.getEsercizioByScheda(nome);
//		Page<Esercizio> eserciziPerNomeScheda=PageableExecutionUtils.getPage(listFiltrataPerNomeScheda, pageable, ()->listFiltrataPerNomeScheda.size());
//		return eserciziPerNomeScheda;}
		
		
	
		
		
	
}
