package com.hospitalmanagement.entities;

import com.hospitalmanagement.dtos.AppointmentDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "appointments")
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    private String age;

    private String symptoms;

    private String phoneNumber;

    public AppointmentDto getAppointmentDto(){
        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setId(id);
        appointmentDto.setAge(age);
        appointmentDto.setName(name);
        appointmentDto.setSymptoms(symptoms);
        appointmentDto.setPhoneNumber(phoneNumber);

        return appointmentDto;
    }


}
