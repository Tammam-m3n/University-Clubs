package University.Clubs.Clubs.Clubs.Repository;

import University.Clubs.Clubs.Clubs.ClubManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubManagerRepository extends JpaRepository<ClubManager, Integer> {
}
