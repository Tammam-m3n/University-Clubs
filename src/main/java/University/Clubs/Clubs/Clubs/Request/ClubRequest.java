package University.Clubs.Clubs.Clubs.Request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClubRequest {

    private String name;
    private String club_type;
    private String description;
    private Boolean active;

}
