package University.Clubs.Clubs.UniversitySide;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "Employee")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employee {

    @Id
    @SequenceGenerator(name = "employee_id" ,sequenceName = "employee_id" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "employee_id")
    private Integer employee_id;

    @Column(name = "full name" ,length = 20)
    private String full_name;

    @Column(name = "birth date")
    private LocalDate birth_date;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "gender")
    private String gender;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
}