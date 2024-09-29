package University.Clubs.Clubs.UniversitySide.Response;

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

    private Integer id;
    private String full_name;
    private LocalDate birth_date;
    private String address;
    private String phone;
    private String email;
    private String gender;
    private String username;
    private String password;
}
