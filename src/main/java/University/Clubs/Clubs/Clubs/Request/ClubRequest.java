package University.Clubs.Clubs.Clubs.Request;

import University.Clubs.Clubs.Clubs.Enum.ClubsName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClubRequest {

    private ClubsName name;
    private String club_type;
    private String description;
    private Boolean active;

    private Integer pr_manager_id;
    private Integer hr_manager_id;
    private Integer club_manager_id;
}
