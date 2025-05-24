package com.mediLabo.patientApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mediLabo.patientApi.dto.PatientDto;
import com.mediLabo.patientApi.entities.Patient;
import com.mediLabo.patientApi.mapper.PatientMapper;
import com.mediLabo.patientApi.repository.PatientRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

	// private WebClient webClient;

	// private ApiClient apiClient;

	private final PatientRepository patientRepository;
	private final PatientMapper patientMapper;

	@Override
	public PatientDto getPatientById(int id) {
		Patient patient = patientRepository.findById(id);
		return patientMapper.toDto(patient);
	}

	@Override
	public PatientDto getPatientByName(String name) {
		Patient patient = patientRepository.findByNom(name);
		return patientMapper.toDto(patient);
	}

	@Override
	public PatientDto getPatientWithNotesById(int id) {
		Patient patient = patientRepository.findById(id);
		return patientMapper.toDtoWithNotes(patient);
	}

	@Override
	public PatientDto getPatientWithNotesByName(String name) {
		Patient patient = patientRepository.findByNom(name);
		return patientMapper.toDtoWithNotes(patient);
	}

	@Override
	public List<PatientDto> getAllPatient() {
		return patientRepository.findAll().stream().map(patientMapper::toDtoWithNotes).toList();
	}

	@Override
	public PatientDto addPatient(PatientDto patientDto) {
		Patient patient = patientRepository.save(patientMapper.toEntity(patientDto));
		return patientMapper.toDto(patient);
	}

	@Override
	public PatientDto updatePatient(int id, PatientDto patientDto) {
		Patient patient = patientRepository.findById(id);

		patient.setNom(patientDto.getNom());
		patient.setPrenom(patientDto.getPrenom());
		patient.setDateAnniversaire(patientDto.getDateAnniversaire());
		patient.setGenre(patientDto.getGenre());
		patient.setAdresse(patientDto.getAdresse());
		patient.setTelephone(patientDto.getTelephone());

		return patientMapper.toDto(patientRepository.save(patient));
	}

}
