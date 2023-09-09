package lpirito.ms.patients.controller;

import lpirito.ms.patients.entity.Patient;
import lpirito.ms.patients.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/patient")
public class PatientController {

    @Autowired
    private IPatientService patientService;

    @PostMapping()
    public String createPatient(@RequestBody Patient patient) {
        patientService.savePatient(patient);

        return "Patient created successfully";
    }

    @GetMapping()
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }


    @GetMapping("/dni/{dni}")
    public Patient findPatientByDNI(@PathVariable String dni) {
        return patientService.findByDNI(dni);
    }

    @GetMapping("/{id}")
    public Optional<Patient> findPatientById(@PathVariable Long id) {
        return patientService.findPatient(id);
    }

    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);

        return "Patient deleted successfully";
    }

    @PutMapping("/{id}")
    public Optional<Patient> editPatient(@PathVariable Long id, @RequestBody Patient editedPatient) {
        patientService.editPatient(id ,editedPatient);
        Optional<Patient> newPatient = patientService.findPatient(id);

        return newPatient;
    }

}
