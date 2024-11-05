package University.Clubs.Clubs.Clubs.repository;

import University.Clubs.Clubs.Forms.EtharClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtharRepository extends JpaRepository<EtharClub, Integer> {

}
