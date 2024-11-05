package University.Clubs.Clubs.Clubs;

import University.Clubs.Clubs.Student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "club manager")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClubManager {

    @Id
    @SequenceGenerator(name = "club_manager_id" ,sequenceName = "club_manager_id" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "club_manager_id")
    private Integer club_manager_id;

    @Column(name = "university_number")
    private String university_number;

    @Column(name = "password")
    private String password;

    @OneToOne
    private Club club;

    @OneToOne
    private Student student;
}
