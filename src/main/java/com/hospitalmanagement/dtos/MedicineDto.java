package com.hospitalmanagement.dtos;

import lombok.Data;

@Data
public class MedicineDto {

    private Long id;

    private String drugName;

    private String stock;
}
