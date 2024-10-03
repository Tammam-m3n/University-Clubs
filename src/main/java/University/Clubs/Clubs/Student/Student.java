package University.Clubs.Clubs.Student;

import University.Clubs.Clubs.Clubs.ClubMember;
import University.Clubs.Clubs.Student.Enum.College;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Student {

    @Id
    @SequenceGenerator(name = "student_id" ,sequenceName = "student_id" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "student_id")
    private Integer student_id;

    @Column(name = "full_name" ,length = 20)
    private String full_name;

    @Column(name = "birth date")
    private LocalDate birth_date;

    @Column(name = "address")
    private String address;

    @Column(name = "phone number" ,length = 10)
    private String phone_number;

    @Column(name = "email")
    private String email;

    @Column(name = "university number" ,length = 9)
    private String university_number;

    @Column(name = "password")
    private String password;

    @Column(name = "college")
    private College college;

    @Column(name = "skills")
    private String skills;

    @Column(name = "interests")
    private String interests;

    @Column(name = "social media account")
    private String social_media_account;

    @Column(name = "gpa")
    private String gpa;

    @OneToMany
    private List<ClubMember> clubMembers;
}
