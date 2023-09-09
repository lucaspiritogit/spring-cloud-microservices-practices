package lpirito.ms.patients.service;

import lpirito.ms.patients.entity.Patient;
import lpirito.ms.patients.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService{

    @Autowired
    private IPatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public void savePatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Long patientId) {
        patientRepository.deleteById(patientId);
    }

    @Override
    public Optional<Patient> findPatient(Long patientId) {
        return patientRepository.findById(patientId);
    }

    @Override
    public void editPatient(Long patientId, Patient patient) {
        this.savePatient(patient);
    }

    @Override
    public Patient findByDNI(String dni) {
        return patientRepository.findByDNI(dni);
    }
}
