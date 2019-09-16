package ru.molcom.dao;


import org.springframework.data.repository.CrudRepository;
import ru.molcom.domain.Appointment;

import java.util.List;

public interface IAppointmentDao extends CrudRepository<Appointment, Long> {

    List<Appointment> findAll();

    Appointment findByAppointmentId(Long id);
}
