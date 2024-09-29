package University.Clubs.Clubs.UniversitySide.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeRequest {

        private String full_name;
        private LocalDate birth_date;
        private String address;
        private String phone;
        private String email;
        private String gender;
        private String username;
        private String password;
}
