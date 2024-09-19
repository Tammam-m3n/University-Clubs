package University.Clubs.Clubs.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmployeeResponse {

    private String first_name;
    private String mid_name;
    private String last_name;
    private LocalDate birth_date;
    private String address;
    private Integer phone;
    private String email;
    private String gender;
    private String username;
    private String password;
}
