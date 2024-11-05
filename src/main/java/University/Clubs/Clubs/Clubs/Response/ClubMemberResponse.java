package University.Clubs.Clubs.Clubs.Response;

import University.Clubs.Clubs.Student.Response.StudentResponse;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClubMemberResponse {

    private Integer club_member_id;
    private StudentResponse student;
    private ClubResponse club;
}
