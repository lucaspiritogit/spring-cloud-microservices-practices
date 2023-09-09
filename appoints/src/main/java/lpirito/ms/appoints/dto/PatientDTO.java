package lpirito.ms.appoints.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {

    private Long id;
    private String dni;
    private String name;
    private String lastName;
    private LocalDate birthDate;

}
