package University.Clubs.Clubs.Student.Repository;


import University.Clubs.Clubs.Student.Student;
import University.Clubs.Clubs.UniversitySide.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
