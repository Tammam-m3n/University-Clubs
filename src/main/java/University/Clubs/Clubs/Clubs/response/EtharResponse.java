package University.Clubs.Clubs.Clubs.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EtharResponse {
    private Integer id;
    private String fullName;
    private Integer universityNumber;
    private LocalDate birthDate;
    private String currentResidence;
    private String nationality;
    private String college;
    private Integer phoneNumber;
    private String email;
    private String membershipGoal;
    private String skills;
    private boolean anotherClub = false;

}
