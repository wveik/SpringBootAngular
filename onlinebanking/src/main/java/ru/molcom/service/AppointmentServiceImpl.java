package ru.molcom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.molcom.dao.IAppointmentDao;
import ru.molcom.domain.Appointment;
import ru.molcom.service.interfaces.IAppointmentService;


@Service
public class AppointmentServiceImpl implements IAppointmentService {

    @Autowired
    private IAppointmentDao appointmentDao;

    public Appointment createAppointment(Appointment appointment) {
       return appointmentDao.save(appointment);
    }

    public List<Appointment> findAll() {
        return appointmentDao.findAll();
    }

    public Appointment findAppointment(Long id) {
        return appointmentDao.findByAppointmentId(id);
    }

    public void confirmAppointment(Long id) {
        Appointment appointment = findAppointment(id);
        appointment.setConfirmed(true);
        appointmentDao.save(appointment);
    }
}
