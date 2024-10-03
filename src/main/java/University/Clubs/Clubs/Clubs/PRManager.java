package University.Clubs.Clubs.Clubs;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pr manager")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PRManager {

    @Id
    @SequenceGenerator(name = "pr_manager_id" ,sequenceName = "pr_manager_id" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "pr_manager_id")
    private Integer pr_manager_id;

    @Column(name = "full name")
    private String full_name;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
}
