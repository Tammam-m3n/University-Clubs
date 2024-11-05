package University.Clubs.Clubs.Clubs.Request;

import University.Clubs.Clubs.Clubs.Enum.StatusRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClubMembershipRequestRequest {

    private StatusRequest status;
    private LocalDate submission_date;

    private Integer student_id;
    private Integer club_id;
}
