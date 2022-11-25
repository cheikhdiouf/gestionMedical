package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Consultation;
@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

}
