package lpirito.ms.patients.service;

import lpirito.ms.patients.entity.Patient;

import java.util.List;
import java.util.Optional;

public interface IPatientService {
    public List<Patient> getAllPatients();

    public void savePatient(Patient patient);

    public void deletePatient(Long patientId);

    public Optional<Patient> findPatient(Long patientId);

    public void editPatient(Long patientId, Patient patient);

    Patient findByDNI(String dni);
}
