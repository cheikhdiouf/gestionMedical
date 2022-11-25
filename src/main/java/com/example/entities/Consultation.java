package com.example.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Consultation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id ;
	@Temporal(TemporalType.DATE)
	private Date dateConsultation;
	private String rapportConsultation;
	private Double prixConsultation;
	@OneToOne(mappedBy = "consultation",fetch = FetchType.EAGER)
	private RendezVous rendezVous;
	
}
