package University.Clubs.Clubs.Forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PrRequest {

    private String first_name;
    private String last_name;
    private String university_number;
    private LocalDate birth_date;

    private String phone;
    private String sm_account;
    private String email;

    private String basic_skills;
    private String workshops;
    private String training_courses;
    private String languages;
    private String other_interests;
}
