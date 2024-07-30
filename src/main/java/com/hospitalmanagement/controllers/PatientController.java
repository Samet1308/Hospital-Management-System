package com.hospitalmanagement.controllers;

import com.hospitalmanagement.business.abstracts.PatientService;
import com.hospitalmanagement.dtos.PatientDto;
import com.hospitalmanagement.entities.Patient;
import com.hospitalmanagement.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    private final PatientRepository patientRepository;

    @PostMapping("/patient")
    public ResponseEntity<PatientDto> postPatient(@RequestBody PatientDto patientDto){
        PatientDto createdPatientDto = patientService.postPatient(patientDto);
        if(createdPatientDto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(createdPatientDto);
    }

    @GetMapping("/patients")
    public ResponseEntity<List<PatientDto>> getAllPatients(){
        List<PatientDto> patientDtoList = patientService.getAllPatients();
        if(patientDtoList==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(patientDtoList);
    }

    @PutMapping("/patients/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id,@RequestBody Patient patientDetails) throws AttributeNotFoundException {
        Patient patient = patientRepository.findById(id).orElseThrow(()->new AttributeNotFoundException(("Patient not found")));

        patient.setAge(patientDetails.getAge());
        patient.setDose(patientDetails.getDose());
        patient.setFees(patientDetails.getFees());
        patient.setUrgency(patientDetails.getUrgency());
        patient.setName(patientDetails.getName());
        patient.setBlood(patientDetails.getBlood());
        patient.setPrescription(patientDetails.getPrescription());

        Patient savedPatient = patientRepository.save(patient);
        return ResponseEntity.ok(savedPatient);

    }

    @DeleteMapping("/patients/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id){
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }



}
