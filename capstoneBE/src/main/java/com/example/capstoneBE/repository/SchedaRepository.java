package com.example.capstoneBE.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.capstoneBE.entity.GruppiMuscolari;
import com.example.capstoneBE.entity.Scheda;

@Repository
public interface SchedaRepository extends JpaRepository<Scheda, Long> {

	
	public List<Scheda> findByData(LocalDate date);
	
	public List<Scheda> findByNomeContaining(String nome);
	
	
	public List<Scheda> findByOrderByData();
	
	
	
	
}
