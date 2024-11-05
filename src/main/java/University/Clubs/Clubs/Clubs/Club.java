package University.Clubs.Clubs.Clubs;

import University.Clubs.Clubs.Clubs.Enum.ClubsName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "club")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Club {

    @Id
    @SequenceGenerator(name = "club_id" ,sequenceName = "club_id" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "club_id")
    private Integer club_id;

    @Column(name = "name")
    private ClubsName name;

    @Column(name = "club type")
    private String club_type;

    @Column(name = "description")
    private String description;

    @Column(name = "is active?")
    private Boolean active;

    @OneToMany
    private List<ClubMember> clubMembers;

    @ManyToOne
    private PRManager prManager;

    @ManyToOne
    private HRManager hrManager;

    @OneToOne
    private ClubManager clubManager;

    @OneToMany
    private List<ClubMembershipRequest> clubMembershipRequests;

    @OneToMany
    private List<Announcement> announcements;
}
