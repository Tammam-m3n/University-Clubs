package University.Clubs.Clubs.Clubs.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AnnouncementResponse {

    private Integer announcement_id;
    private String title;
    private String content;
    private LocalDate creation_date;

    private ClubResponse club;
    private PRManagerResponse prManager;
}
