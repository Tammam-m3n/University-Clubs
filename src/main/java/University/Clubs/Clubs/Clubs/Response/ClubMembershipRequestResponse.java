package University.Clubs.Clubs.Clubs.Response;

import University.Clubs.Clubs.Clubs.Enum.StatusRequest;
import University.Clubs.Clubs.Student.Response.StudentResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClubMembershipRequestResponse {

    private Integer club_membership_request_id;
    private StatusRequest status;
    private LocalDate submission_date;

    private StudentResponse student;
    private ClubResponse club;
}
