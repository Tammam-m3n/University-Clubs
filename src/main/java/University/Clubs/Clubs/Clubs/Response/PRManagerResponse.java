package University.Clubs.Clubs.Clubs.Response;

import University.Clubs.Clubs.Student.Response.StudentResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PRManagerResponse {

    private Integer pr_manager_id;
    private String university_number;
    private String password;

    private StudentResponse student;
}