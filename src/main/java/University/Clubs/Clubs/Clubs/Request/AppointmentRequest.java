package University.Clubs.Clubs.Clubs.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AppointmentRequest {

    private Integer student_id;
    private Integer pr_manager_id;
    private Integer hr_manager_id;
    private LocalDate appointmentDate;
}
