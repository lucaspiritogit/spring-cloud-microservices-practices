package lpirito.ms.appoints.client;

import lpirito.ms.appoints.dto.PatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "patientapi", url = "http://localhost:9001/api/v1/patient")
public interface PatientAPIClient {

    @GetMapping("/dni/{dni}")
    public PatientDTO getPatientByDNI(@PathVariable("dni") String dni);
}
