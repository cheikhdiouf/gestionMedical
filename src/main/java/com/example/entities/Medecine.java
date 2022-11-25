package com.example.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Medecine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nom;
	private String specialite;
	private String email,password;
	@OneToMany(mappedBy = "medecine" ,fetch = FetchType.EAGER)
	private Collection<RendezVous> rendezVous;

}
