package com.example.capstoneBE.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.capstoneBE.entity.GruppiMuscolari;
import com.example.capstoneBE.entity.Scheda;
import com.example.capstoneBE.entity.User;

import jakarta.transaction.Transactional;

@Repository
public interface SchedaRepository extends JpaRepository<Scheda, Long> {

	
	public List<Scheda> findByData(LocalDate date);
	
	public List<Scheda> findByNomeContaining(String nome);
	
	
	public List<Scheda> findByOrderByData();
	
	public List<Scheda> findByUtente(Optional<User> utentePreso);
	
	@Modifying
	@Query("DELETE FROM Scheda s WHERE s.id = ?1 AND s.utente.id = ?2")
	void deleteScheda(Long schedaId, Long userId);
	 
	
}
