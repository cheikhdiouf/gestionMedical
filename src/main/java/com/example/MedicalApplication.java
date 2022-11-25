package com.example;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.example.repository.PatientRepository;

@SpringBootApplication
public class MedicalApplication implements CommandLineRunner {
@Autowired
PatientRepository patientRepository;

	public static void main(String[] args) {
		 SpringApplication.run(MedicalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * patientRepository.save(new Patient(null,"omar","fall","fall@gmail.com",new
		 * Date(),false)); patientRepository.save(new
		 * Patient(null,"faty","deye","deye@gmail.com",new Date(),true));
		 * patientRepository.save(new Patient(null,"assane","ndiaye","ndiaye.com",new
		 * Date(),true));
		 * 
		 * patientRepository.findAll().forEach(c->{System.out.println(c.getName());});
		 * 
		 */}

}
