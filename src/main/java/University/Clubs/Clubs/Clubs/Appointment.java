package University.Clubs.Clubs.Clubs;

import University.Clubs.Clubs.Student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "appointment")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Appointment {

    @Id
    @SequenceGenerator(name = "appointment_id" ,sequenceName = "appointment_id" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "appointment_id")
    private Integer appointment_id;

    @Column(name = "appointment_date")
    private String appointment_date;

    @ManyToOne
    private PRManager prManager;

    @ManyToOne
    private HRManager hrManager;

    @ManyToOne
    private Student student;
}
