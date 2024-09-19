package University.Clubs.Clubs;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "Employee")
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Builder
public class Employee {

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

    public Employee(Integer id, String first_name, String mid_name, String last_name, LocalDate birth_date, String address, Integer phone, String email, String gender, String username, String password) {
        this.id = id;
        this.first_name = first_name;
        this.mid_name = mid_name;
        this.last_name = last_name;
        this.birth_date = birth_date;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.username = username;
        this.password = password;
    }

    public Employee() {

    }

    //    @Override
//    public String toString() {
//        return "Employee{" +
//                "salary=" + salary +
//                ", id=" + id +
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