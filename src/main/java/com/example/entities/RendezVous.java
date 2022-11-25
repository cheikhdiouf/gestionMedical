package com.example.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class RendezVous {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id ;
private Date dateRendezVous;
@ManyToOne
private Medecine medecine;
@ManyToOne
private Patient patient;
@OneToOne
private Consultation consultation;
}






