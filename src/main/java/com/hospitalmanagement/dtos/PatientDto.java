package com.hospitalmanagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {

    private Long id;

    private String name;

    private String age;

    private String blood;

    private String prescription;

    private String dose;

    private String fees;

    private String urgency;
}
