package University.Clubs.Clubs.UniversitySide.Repository;

import University.Clubs.Clubs.UniversitySide.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
}
