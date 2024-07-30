package com.hospitalmanagement.business.concretes;

import com.hospitalmanagement.business.abstracts.PatientService;
import com.hospitalmanagement.dtos.PatientDto;
import com.hospitalmanagement.entities.Appointment;
import com.hospitalmanagement.entities.Patient;
import com.hospitalmanagement.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public PatientDto postPatient(PatientDto patientDto) {
        Patient patient = new Patient();
        patient.setName(patientDto.getName());
        patient.setAge(patientDto.getAge());
        patient.setFees(patientDto.getFees());
        patient.setDose(patientDto.getDose());
        patient.setBlood(patientDto.getBlood());
        patient.setUrgency(patientDto.getUrgency());
        patient.setPrescription(patientDto.getPrescription());

        Patient createdPatient = patientRepository.save(patient);
        PatientDto createdPatientDto = new PatientDto();
        createdPatientDto.setId(createdPatient.getId());
        createdPatientDto.setName(createdPatient.getName());
        createdPatientDto.setAge(createdPatient.getAge());
        createdPatientDto.setFees(createdPatient.getFees());
        createdPatientDto.setDose(createdPatient.getDose());
        createdPatientDto.setBlood(createdPatient.getBlood());
        createdPatientDto.setUrgency(createdPatient.getUrgency());
        createdPatientDto.setPrescription(createdPatient.getPrescription());

        return createdPatientDto;
    }

    @Override
    public List<PatientDto> getAllPatients() {
        return patientRepository.findAll().stream().map(Patient::getPatientDto).collect(Collectors.toList());
    }

    @Override
    public void deletePatient(Long id) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()){
            patientRepository.deleteById(id);
        }
    }
}
