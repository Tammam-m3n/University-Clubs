package University.Clubs.Clubs.Forms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrRepository extends JpaRepository<PR_Club,Integer> {

}
