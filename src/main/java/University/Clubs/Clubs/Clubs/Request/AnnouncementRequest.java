package University.Clubs.Clubs.Clubs.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnnouncementRequest {

    private String title;
    private String content;
    private LocalDate creation_date;

    private Integer club_id;
    private Integer pr_manager_id;
}
