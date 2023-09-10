package lpirito.ms.appoints.service;

import lpirito.ms.appoints.client.PatientAPIClient;
import lpirito.ms.appoints.dto.PatientDTO;
import lpirito.ms.appoints.entity.Appoint;
import lpirito.ms.appoints.repository.IAppointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AppointService implements IAppointService{


    @Autowired
    private IAppointRepository appointRepository;

    @Autowired
    private PatientAPIClient patientAPIClient;

    @Override
    public List<Appoint> getAllApointments() {
        return appointRepository.findAll();
    }

    @Override
    public void saveAppointment(LocalDate date, String treatment, String dni) {
        // Call patients api
        PatientDTO patient = patientAPIClient.getPatientByDNI(dni);
        String fullPatientName = patient.getName() + " " + patient.getLastName();

        Appoint appoint = new Appoint();
        appoint.setDate(date);
        appoint.setTreatment(treatment);
        appoint.setFullPatientName(fullPatientName);

        appointRepository.save(appoint);

    }

    @Override
    public void deleteAppointment(Long id) {
        appointRepository.deleteById(id);
    }

    @Override
    public Optional<Appoint> findAppointment(Long id) {
        return appointRepository.findById(id);
    }

    @Override
    public void editAppointment(Long id, Appoint appointmentDTO) {
        Appoint newAppointment = this.findAppointment(id).orElse(null);

        newAppointment.setDate(appointmentDTO.getDate());
        newAppointment.setTreatment(appointmentDTO.getTreatment());
        newAppointment.setFullPatientName(appointmentDTO.getFullPatientName());

        appointRepository.save(newAppointment);
    }
}
