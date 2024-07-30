package com.hospitalmanagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {
    private Long id;

    private String name;

    private String age;

    private String symptoms;

    private String phoneNumber;
}
