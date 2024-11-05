package University.Clubs.Clubs.Clubs;

import University.Clubs.Clubs.Student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "pr_manager")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PRManager {

    @Id
    @Column(name = "pr_manager_id")
    private Integer pr_manager_id = 1;

    @Column(name = "university_number", nullable = false)
    private String university_number;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany
    private List<Club> clubs;

    @OneToMany
    private List<Student> students;

    @OneToOne
    private Student student;
}
