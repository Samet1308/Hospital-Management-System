package com.hospitalmanagement.controllers;

import com.hospitalmanagement.business.abstracts.AppointmentService;
import com.hospitalmanagement.dtos.AppointmentDto;
import com.hospitalmanagement.dtos.PatientDto;
import com.hospitalmanagement.entities.Appointment;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping("/appointment")
    public ResponseEntity<AppointmentDto> postAppointment(@RequestBody AppointmentDto appointmentDto){
        AppointmentDto createdAppointment = appointmentService.postAppointment(appointmentDto);
        if (createdAppointment == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(createdAppointment);
    }

    @GetMapping("/appointments")
    public ResponseEntity<List<AppointmentDto>> getAppointments(){
        List<AppointmentDto> appointmentDtoList =  appointmentService.getAppointments();
        if (appointmentDtoList == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(appointmentDtoList);
    }

    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id){
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }
}
