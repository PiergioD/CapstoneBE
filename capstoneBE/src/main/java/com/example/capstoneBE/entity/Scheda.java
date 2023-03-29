package com.example.capstoneBE.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="scheda_allenamento")
public class Scheda {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	@Column(name="nome_scheda")
	private String nome;
	@NonNull
	@Column(name="data_scheda")
	private LocalDate data=LocalDate.now();
	
	
	// relazione molti a uno con utente
	@NonNull
    @ManyToOne(targetEntity = User.class,cascade = CascadeType.MERGE)
    @JoinColumn(name="id_user",referencedColumnName = "id")
    private User utente;
	
	@NonNull
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="esercizi_della_scheda",joinColumns = @JoinColumn(name="scheda_id"),inverseJoinColumns = @JoinColumn(name="esercizio_id"))
	private Set<Esercizio> esercizi;
	
	
	

}