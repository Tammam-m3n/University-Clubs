package University.Clubs.Clubs.Clubs;

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
}
