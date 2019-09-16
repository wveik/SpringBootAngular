package ru.molcom.service.interfaces;


import ru.molcom.domain.Appointment;

import java.util.List;

public interface IAppointmentService {
	Appointment createAppointment(Appointment appointment);

    List<Appointment> findAll();

    Appointment findAppointment(Long id);

    void confirmAppointment(Long id);
}
