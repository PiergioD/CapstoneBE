package com.example.capstoneBE.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
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
	
}
