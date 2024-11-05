package University.Clubs.Clubs.Clubs.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PRManagerRequest {

    private String university_number;
    private String password;

    private Integer student_id;
}
