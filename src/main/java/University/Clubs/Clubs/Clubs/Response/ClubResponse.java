package University.Clubs.Clubs.Clubs.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClubResponse {

    private int club_id;
    private String name;
    private String club_type;
    private String description;
    private Boolean active;

}
