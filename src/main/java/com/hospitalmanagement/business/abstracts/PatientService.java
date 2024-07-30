package com.hospitalmanagement.business.abstracts;

import com.hospitalmanagement.dtos.PatientDto;

import java.util.List;

public interface PatientService {
    PatientDto postPatient(PatientDto patientDto);

    List<PatientDto> getAllPatients();

    void deletePatient(Long id);
}
