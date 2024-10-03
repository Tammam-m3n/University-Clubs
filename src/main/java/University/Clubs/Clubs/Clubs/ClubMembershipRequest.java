package University.Clubs.Clubs.Clubs;

import University.Clubs.Clubs.Clubs.Enum.StatusRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "club membership request")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClubMembershipRequest {

    @Id
    @SequenceGenerator(name = "student_id" ,sequenceName = "student_id" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "student_id")
    private Integer club_membership_request_id;

    @Column(name = "status")
    private StatusRequest status;

    @Column(name = "submission date")
    private LocalDate submission_date;
}
