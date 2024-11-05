package University.Clubs.Clubs.Clubs.Repository;

import University.Clubs.Clubs.Clubs.PRManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PRManagerRepository extends JpaRepository<PRManager, Integer> {

}
