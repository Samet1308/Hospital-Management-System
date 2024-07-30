package com.hospitalmanagement.entities;

import com.hospitalmanagement.dtos.PatientDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    private String age;

    private String blood;

    private String prescription;

    private String dose;

    private String fees;

    private String urgency;

public PatientDto getPatientDto(){
    PatientDto patientDto = new PatientDto();
    patientDto.setId(id);
    patientDto.setName(name);
    patientDto.setFees(fees);
    patientDto.setDose(dose);
    patientDto.setAge(age);
    patientDto.setBlood(blood);
    patientDto.setPrescription(prescription);
    patientDto.setUrgency(urgency);

    return patientDto;
}

}
