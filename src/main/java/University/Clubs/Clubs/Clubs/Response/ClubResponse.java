package University.Clubs.Clubs.Clubs.Response;

import University.Clubs.Clubs.Clubs.Enum.ClubsName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClubResponse {

    private Integer club_id;
    private ClubsName name;
    private String club_type;
    private String description;
    private Boolean active;

    private PRManagerResponse prManager;
    private HRManagerResponse hrManager;
    private ClubManagerResponse clubManager;
}
