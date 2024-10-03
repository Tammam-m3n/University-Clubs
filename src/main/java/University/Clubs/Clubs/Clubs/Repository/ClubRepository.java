package University.Clubs.Clubs.Clubs.Repository;

import University.Clubs.Clubs.Clubs.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ClubRepository extends JpaRepository<Club, Integer> {
}
