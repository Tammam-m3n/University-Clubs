package University.Clubs.Clubs.Clubs.Response;

import University.Clubs.Clubs.Student.Response.StudentResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AppointmentResponse {

    private Integer appointmentId;
    private LocalDate appointmentDate;
    private PRManagerResponse prManager;
    private HRManagerResponse hrManager;
    private StudentResponse student;

}
