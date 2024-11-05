package University.Clubs.Clubs.Clubs.Repository;

import University.Clubs.Clubs.Clubs.ClubMembershipRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubMembershipRequestRepository extends JpaRepository<ClubMembershipRequest, Integer> {
}
