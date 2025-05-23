package com.mediLabo.patientApi.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mediLabo.patientApi.dto.NoteDto;

@FeignClient(name = "noteapi")
public interface ApiClient {
	@GetMapping("api/notes/patient/{patientNom}")
	List<NoteDto> getNoteDtos(@PathVariable String patientNom);
}
