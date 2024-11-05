package University.Clubs.Clubs.Clubs.Repository;

import University.Clubs.Clubs.Clubs.ClubMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClubMemberRepository extends JpaRepository<ClubMember, Integer> {
//    public Optional<List<ClubMember>> getClubMemberByClubClub_id(int clubId);

}
