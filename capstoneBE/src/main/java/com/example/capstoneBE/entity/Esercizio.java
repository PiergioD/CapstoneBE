package com.example.capstoneBE.entity;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="esercizi")
public class Esercizio {
	
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@NonNull
	@Column(name="nome_esercizio",unique = true)
	private String nome;
	@NonNull
	@Column(name="descrizione_esercizio")
	private String descrizione;
	@NonNull
	@Enumerated(EnumType.STRING)
	@Column(name="muscolo_interessato")
	private GruppiMuscolari muscolo;
	@NonNull
	@Column(name="serie_esercizio")
	private Integer serie;
	@NonNull
	@Column(name="ripetizioni_esercizio")
	private Integer ripetizioni;
	
	
	
	// relazione many to one a scheda
	@JsonIgnore
	@NonNull
	@ManyToOne(targetEntity =Scheda.class,cascade = CascadeType.MERGE,fetch = FetchType.EAGER,optional = false)
	@JoinColumn(name="id_scheda",referencedColumnName = "id",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Scheda scheda;
	
	
	

}
