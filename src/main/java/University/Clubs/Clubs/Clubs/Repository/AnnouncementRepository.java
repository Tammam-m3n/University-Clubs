package University.Clubs.Clubs.Clubs.Repository;

import University.Clubs.Clubs.Clubs.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {
}
