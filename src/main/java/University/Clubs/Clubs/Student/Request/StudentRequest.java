package University.Clubs.Clubs.Student.Request;

import University.Clubs.Clubs.Student.Enum.College;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentRequest {

    private String full_name;
    private LocalDate birth_date;
    private String address;
    private String phone_number;
    private String email;
    private String university_number;
    private String password;
    private College college;
    private String skills;
    private String interests;
    private String social_media_account;
    private String gpa;

    private Integer pr_manager_id;
}
