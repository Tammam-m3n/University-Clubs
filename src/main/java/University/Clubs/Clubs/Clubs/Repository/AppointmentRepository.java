package University.Clubs.Clubs.Clubs.Repository;

import University.Clubs.Clubs.Clubs.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}

