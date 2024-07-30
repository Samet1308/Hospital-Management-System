package com.hospitalmanagement.business.concretes;

import com.hospitalmanagement.business.abstracts.AppointmentService;
import com.hospitalmanagement.dtos.AppointmentDto;
import com.hospitalmanagement.entities.Appointment;
import com.hospitalmanagement.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<AppointmentDto> getAppointments() {
        return this.appointmentRepository.findAll().stream().map(Appointment:: getAppointmentDto).collect(Collectors.toList());
    }

    @Override
    public AppointmentDto postAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = new Appointment();
        appointment.setId(appointmentDto.getId());
        appointment.setName(appointmentDto.getName());
        appointment.setAge(appointmentDto.getAge());
        appointment.setSymptoms(appointmentDto.getSymptoms());
        appointment.setPhoneNumber(appointmentDto.getPhoneNumber());

        Appointment createdAppointment = appointmentRepository.save(appointment);

        AppointmentDto createdAppointmentDto = new AppointmentDto();
        createdAppointmentDto.setId(createdAppointment.getId());
        createdAppointmentDto.setName(createdAppointment.getName());
        createdAppointmentDto.setAge(createdAppointment.getAge());
        createdAppointmentDto.setSymptoms(createdAppointment.getSymptoms());
        createdAppointmentDto.setPhoneNumber(createdAppointment.getPhoneNumber());

        return createdAppointmentDto;
    }

    @Override
    public void deleteAppointment(Long id) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);
        if (optionalAppointment.isPresent()){
            appointmentRepository.deleteById(id);
        }
    }
}
