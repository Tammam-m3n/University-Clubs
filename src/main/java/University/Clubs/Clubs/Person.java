package University.Clubs.Clubs;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {

    @Id
    @SequenceGenerator(name = "person_id" ,sequenceName = "person_id" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "person_id")
    protected Integer id;

    @Column(name = "First Name" ,length = 20)
    protected String first_name;

    @Column(name = "Mid Name" ,length = 20)
    protected String mid_name;

    @Column(name = "Last Name" ,length = 20)
    protected String last_name;

    @Column(name = "Birth Date")
    protected LocalDate birth_date;

    @Column(name = "Address")
    protected String address;

    @Column(name = "Phone")
    protected Integer phone;

    @Column(name = "Email")
    protected String email;

    @Column(name = "Gender")
    protected String gender;

    protected String username;
    protected String password;


//
//    @Override
//    public String toString() {
//        return "Person{" +
//                "id=" + id +
//                ", first_name='" + first_name + '\'' +
//                ", mid_name='" + mid_name + '\'' +
//                ", last_name='" + last_name + '\'' +
//                ", birth_date=" + birth_date +
//                ", address='" + address + '\'' +
//                ", phone=" + phone +
//                ", email='" + email + '\'' +
//                ", gender='" + gender + '\'' +
//                ", username='" + username + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }
}
