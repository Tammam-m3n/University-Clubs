package University.Clubs.Clubs.Forms;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Table(name = "Ethar")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EtharClub {

    @Id
    @SequenceGenerator(name = "person_id" ,sequenceName = "person_id" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "person_id")



    private Integer id;
    @Column(name = "FullName" ,length = 20)
    private String fullName;

    @Column(name = "UniversityNumber",unique = true )
    private Integer universityNumber;

    @Column(name = "BirthDate" )
    private LocalDate birthDate;

    @Column(name = "CurrentResidence" )
    private String currentResidence;

    @Column(name = "Nationality" )
    private String nationality;

    @Column(name = "College" )
    private Colleges college;

    @Column(name = "PhoneNumber" )
    private Integer phoneNumber;

    @Column(name = "Email" )
    private String email;

    @Column(name = "MembershipGoal" )
    private String membershipGoal;

    @Column(name = "Skills" )
    private String skills;

    @Column(name = "AnotherClub" )
    private boolean anotherClub = false;

}
