package University.Clubs.Clubs.Clubs.Response;

import University.Clubs.Clubs.Clubs.Club;
import University.Clubs.Clubs.Student.Response.StudentResponse;
import University.Clubs.Clubs.Student.Student;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClubMemberResponse {

    private int club_member_id;
    private StudentResponse student;
    private ClubResponse club;
}
