package lpirito.ms.appoints.controller;

import lpirito.ms.appoints.client.PatientAPIClient;
import lpirito.ms.appoints.dto.AppointDTO;
import lpirito.ms.appoints.entity.Appoint;
import lpirito.ms.appoints.service.IAppointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/appoint")
public class AppointController {

    @Autowired
    private IAppointService appointService;



    @PostMapping()
    public String createAppointment(@RequestBody AppointDTO appoint) {
        appointService.saveAppointment(appoint.getDate(), appoint.getTreatment(), appoint.getDni());
        return "Appointment created";
    }

    @GetMapping()
    public List<Appoint> findAllAppointments() {
        return appointService.getAllApointments();
    }

    @GetMapping("/{id}")
    public Optional<Appoint> getAppoint(@PathVariable Long id) {
        return appointService.findAppointment(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointService.deleteAppointment(id);
    }

    @PutMapping("/{id}")
    public Optional<Appoint> editAppointment(@PathVariable Long originalId, @RequestBody Appoint newAppointment) {
        appointService.editAppointment(originalId, newAppointment);
        Optional<Appoint> editedAppoint = appointService.findAppointment(originalId);

        return editedAppoint;
    }


}
