package com.example.capstoneBE.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.capstoneBE.entity.Esercizio;
import com.example.capstoneBE.entity.GruppiMuscolari;

@Repository
public interface EsercizioRepository extends JpaRepository<Esercizio, Long> {

	
	public List<Esercizio> findByMuscolo(GruppiMuscolari muscolo);
	public List<Esercizio> findByNomeContaining(String nome);
	
//	@Query("SELECT e FROM ESERCIZIO e JOIN e.scheda s ORDER BY s.nome")
//	List<Esercizio> getEsercizioByScheda(@Param("nome") String nome);
	
	
	@Query("SELECT DISTINCT e FROM Esercizio e JOIN e.scheda s JOIN s.utente u WHERE u.id = :userId AND s.id = :schedaId")
    Set<Esercizio> findBySchedaAndUtente(@Param("userId") Long userId, @Param("schedaId") Long schedaId);
	
	
	
	@Modifying
	@Query("DELETE FROM Esercizio e WHERE e.id = ?1 AND e.scheda.utente.id = ?2 AND e.scheda.id = ?3")
	void deleteEsercizioFromScheda(Long esercizioId, Long userId, Long schedaId);
}
