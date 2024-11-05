package University.Clubs.Clubs.Clubs.Repository;

import University.Clubs.Clubs.Clubs.HRManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HRManagerRepository extends JpaRepository<HRManager,Integer> {

}
