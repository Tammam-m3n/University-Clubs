package University.Clubs.Clubs.Clubs.Request;

import University.Clubs.Clubs.Clubs.Club;
import University.Clubs.Clubs.Student.Student;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClubMemberRequest {

    private Integer student_id;
    private Integer club_id;
}
