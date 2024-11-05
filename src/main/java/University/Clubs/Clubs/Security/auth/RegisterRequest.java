package University.Clubs.Clubs.Security.auth;

import University.Clubs.Clubs.Security.user.Role;
import University.Clubs.Clubs.Student.Enum.College;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

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
