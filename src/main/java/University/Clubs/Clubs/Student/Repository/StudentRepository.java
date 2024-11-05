package University.Clubs.Clubs.Student.Repository;


import University.Clubs.Clubs.Student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    public Optional<Student> findByUniversityNumber(String university_number);
}
