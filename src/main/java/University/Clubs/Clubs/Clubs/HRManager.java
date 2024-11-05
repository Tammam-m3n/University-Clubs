package University.Clubs.Clubs.Clubs;

import University.Clubs.Clubs.Student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "hr manager")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HRManager {

    @Id
    @Column(name = "hr_manager_id")
    private Integer hr_manager_id = 1;

    @Column(name = "university_number")
    private String university_number;

    @Column(name = "password")
    private String password;

    @OneToMany
    private List<Club> clubs;

    @OneToMany
    private List<Appointment> appointments;

    @OneToOne
    private Student student;
}
