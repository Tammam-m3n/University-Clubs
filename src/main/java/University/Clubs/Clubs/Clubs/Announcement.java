package University.Clubs.Clubs.Clubs;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "announcement")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Announcement {

    @Id
    @SequenceGenerator(name = "announcement_id" ,sequenceName = "announcement_id" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "announcement_id")
    private Integer announcement_id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "creation date")
    private LocalDate creation_date;

    @ManyToOne
    private Club club;

    @ManyToOne
    private PRManager prManager;
}
