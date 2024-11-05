package University.Clubs.Clubs.Clubs.Request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClubMemberRequest {

    private Integer student_id;
    private Integer club_id;
}
