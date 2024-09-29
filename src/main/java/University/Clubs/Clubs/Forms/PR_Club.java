package University.Clubs.Clubs.Forms;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "PR")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PR_Club {

    @Id
    @SequenceGenerator(name = "pr_id" ,sequenceName = "pr_id" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "pr_id")
    private Integer id;
    @Column(name = "Full Name" ,length = 20)
    private String full_name;
    @Column(name = "University Number", unique = true ,length = 9)
    private String university_number;
    @Column(name = "Birth Date")
    private LocalDate birth_date;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Social Media Account")
    private String sm_account;
    @Column(name = "Email")
    private String email;
    @Column(name = "Basic Skils")
    private String basic_skills;
    @Column(name = "Workshops")
    private String workshops;
    @Column(name = "Training Courses")
    private String training_courses;
    @Column(name = "Languages")
    private String languages;
    @Column(name = "Other Interests")
    private String other_interests;
}
