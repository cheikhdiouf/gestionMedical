package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.RendezVous;
@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {

}
