package University.Clubs.Clubs.UniversitySide;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "Employee")
@Data
@Builder
public class Employee {

    @Id
    @SequenceGenerator(name = "employee_id" ,sequenceName = "employee_id" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "employee_id")
    private Integer id;
    @Column(name = "Full_Name" ,length = 20)
    private String full_name;
    @Column(name = "Birth Date")
    private LocalDate birth_date;
    @Column(name = "Address")
    private String address;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Email")
    private String email;
    @Column(name = "Gender")
    private String gender;

    private String username;
    private String password;

    public Employee() {}

    public Employee(Integer id, String full_name,LocalDate birth_date, String address, String phone, String email, String gender, String username, String password) {
        this.id = id;
        this.full_name = full_name;
        this.birth_date = birth_date;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.username = username;
        this.password = password;
    }

//        @Override
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