package lpirito.ms.appoints.service;

import lpirito.ms.appoints.entity.Appoint;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IAppointService {
    public List<Appoint> getAllApointments();

    public void saveAppointment(LocalDate date, String treatment, String dni);

    public void deleteAppointment(Long id);

    public Optional<Appoint> findAppointment(Long id);

    public void editAppointment(Long id, Appoint appointment);
}
