package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Medecine;
@Repository
public interface MedecineRepository extends JpaRepository<Medecine, Long>{

}
