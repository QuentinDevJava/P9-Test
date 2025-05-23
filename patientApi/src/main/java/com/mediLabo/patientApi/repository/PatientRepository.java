package com.mediLabo.patientApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mediLabo.patientApi.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

	Patient findById(int id);

	Patient findByNom(String nom);

	Patient findByNomAndPrenom(String nom, String prenom);

}
