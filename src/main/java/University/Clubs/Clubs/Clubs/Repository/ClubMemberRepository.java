package University.Clubs.Clubs.Clubs.Repository;

import University.Clubs.Clubs.Clubs.ClubMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubMemberRepository extends JpaRepository<ClubMember, Integer> {

}
