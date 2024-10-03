package University.Clubs.Clubs.Clubs;

import University.Clubs.Clubs.Student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "club member")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClubMember {

    @Id
    @SequenceGenerator(name = "club_member_id" ,sequenceName = "club_member_id" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "club_member_id")
    private Integer club_member_id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Club club;
}
