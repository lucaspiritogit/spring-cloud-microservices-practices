package lpirito.ms.appoints.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointDTO {

    private LocalDate date;
    private String treatment;
    private String dni;
}
