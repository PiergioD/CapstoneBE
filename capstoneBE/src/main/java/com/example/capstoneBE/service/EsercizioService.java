package com.example.capstoneBE.service;

import java.util.List;
import java.util.Set;

import org.modelmapper.internal.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener.ErrorEscalating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import com.example.capstoneBE.entity.Esercizio;
import com.example.capstoneBE.entity.GruppiMuscolari;
import com.example.capstoneBE.entity.Scheda;
import com.example.capstoneBE.repository.EsercizioRepository;
import com.example.capstoneBE.repository.SchedaRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class EsercizioService {

	@Autowired
	EsercizioRepository repo;
	
	@Autowired SchedaRepository repoScheda;

	// crea
	public Esercizio create(Esercizio s) {
		repo.save(s);
		return s;
	}

	// crea tutte
	public void creaAll(List<Esercizio> list) {
		repo.saveAll(list);
	}

	// leggi tutte
	public Page<Esercizio> getAll(Pageable sorting) {
		return repo.findAll(sorting);
	}

	// modifica esercizio
	public Esercizio updateEsercizio(Esercizio d) {
		repo.save(d);
		return d;
	}

	// get by id
	public Esercizio getbyId(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("l'esercizio con questo id non esiste!"));
	}

	// put
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

	// metodino per cercare per gruppo muscolare
	public Page<Esercizio> cercaTramiteMuscolo(GruppiMuscolari muscolo, Pageable pageable) {
		var listFiltrataperMuscolo = repo.findByMuscolo(muscolo);
		Page<Esercizio> eserciziPerMuscolo = PageableExecutionUtils.getPage(listFiltrataperMuscolo, pageable,
				() -> listFiltrataperMuscolo.size());
		return eserciziPerMuscolo;
	}

	// metodino per cercare per parte del nome esercizio
	public Page<Esercizio> cercaTramiteNome(String nome, Pageable pageable) {
		var listFiltrataperNome = repo.findByNomeContaining(nome);
		Page<Esercizio> eserciziPerNome = PageableExecutionUtils.getPage(listFiltrataperNome, pageable,
				() -> listFiltrataperNome.size());
		return eserciziPerNome;
	}

// metodino per cercare esercizi tramite un certo utente e una certa scheda
	public Set<Esercizio> getEserciziBySchedaAndUtente(Long userId, Long schedaId) {
		return repo.findBySchedaAndUtente(userId, schedaId);
	}

	// metodino per eliminare un esercizio da una certa scheda di un certo utente
	 @Transactional
	    public void deleteEsercizio(Long esercizioId, Long userId, Long schedaId) {
	        repo.deleteEsercizioFromScheda(esercizioId, userId, schedaId);
	    }
	
	
	
}
