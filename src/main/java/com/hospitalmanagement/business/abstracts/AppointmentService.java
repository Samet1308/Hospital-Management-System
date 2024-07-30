package com.hospitalmanagement.business.abstracts;

import com.hospitalmanagement.dtos.AppointmentDto;
import com.hospitalmanagement.entities.Appointment;

import java.util.List;

public interface AppointmentService {
    List<AppointmentDto> getAppointments();

    AppointmentDto postAppointment(AppointmentDto appointmentDto);

    void deleteAppointment(Long id);
}
