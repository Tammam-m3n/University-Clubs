package University.Clubs.Clubs.Clubs;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "event")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Event {

    @Id
    @SequenceGenerator(name = "event_id" ,sequenceName = "event_id" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "event_id")
    private Integer event_id;

    @Column(name = "event name")
    private String event_name;

    @Column(name = "event date")
    private LocalDate event_date;

    @Column(name = "description")
    private String description;
}
