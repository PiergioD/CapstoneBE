package com.example.capstoneBE.controller;

import java.time.LocalDate;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.capstoneBE.entity.Esercizio;
import com.example.capstoneBE.entity.Scheda;
import com.example.capstoneBE.repository.EsercizioRepository;
import com.example.capstoneBE.service.EsercizioService;
import com.example.capstoneBE.service.SchedaService;

@RestController

@RequestMapping("api/capstone/esercizio")
public class EsercizioController {

	@Autowired
	SchedaService serviceScheda;
	@Autowired
	EsercizioService service;

	// create
	@PostMapping("/scheda/{id}/create")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<Esercizio> postScheda(@RequestBody Esercizio s, @PathVariable Long id) {
		Scheda scheda = serviceScheda.getbyId(id);
		s.setScheda(scheda);
		service.create(s);
		return new ResponseEntity<>(s, HttpStatus.OK);

	}

	// pagina per fare ordinarli in base ad uno degli attributi di esercizio
	@GetMapping("/page/{page}/{sortBy}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public Page<Esercizio> getAllScheda(@PathVariable int page, @RequestParam(defaultValue = "10") int size,
			@PathVariable String sortBy) {
		Pageable sorting = PageRequest.of(page, size, Sort.by(sortBy));
		return service.getAll(sorting);
	}

	// get by id
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<Esercizio> getClienteById(@PathVariable long id) {
		return new ResponseEntity<>(service.getbyId(id), HttpStatus.OK);
	}

	// modifica
	@PutMapping("/update/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<Esercizio> updateEsercizio(@RequestBody Esercizio esercizioToUpdate, @PathVariable Long id) {

		Esercizio esercizioEsistente = service.getbyId(id);
		esercizioEsistente.setNome(esercizioToUpdate.getNome());
		esercizioEsistente.setMuscolo(esercizioToUpdate.getMuscolo());
		esercizioEsistente.setDescrizione(esercizioToUpdate.getDescrizione());
		esercizioEsistente.setSerie(esercizioToUpdate.getSerie());
		esercizioEsistente.setRipetizioni(esercizioToUpdate.getRipetizioni());

		return new ResponseEntity<Esercizio>(service.updateEsercizio(esercizioEsistente), HttpStatus.OK);
	}

	// delete
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<Esercizio> deleteCliente(@PathVariable long id) {

		return new ResponseEntity<>(service.deleteById(id), HttpStatus.OK);
	}

	// cerca per parte del nome
	@GetMapping("/nome/{nome}/{page}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public Page<Esercizio> getByNome(@PathVariable String nome, @PathVariable int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
		Pageable sorting = PageRequest.of(page, size, Sort.by(sortBy));
		return service.cercaTramiteNome(nome, sorting);
	}

}
