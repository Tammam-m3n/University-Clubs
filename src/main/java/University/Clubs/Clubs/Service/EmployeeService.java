package University.Clubs.Clubs.Service;

import University.Clubs.Clubs.Employee;
import University.Clubs.Clubs.Repository.EmployeeRepository;
import University.Clubs.Clubs.Request.EmployeeRequest;
import University.Clubs.Clubs.Response.EmployeeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public ResponseEntity<?> saveEmployee(EmployeeRequest employeeRequest) {
        Employee employee = Employee.builder()
                .first_name(employeeRequest.getFirst_name())
                .mid_name(employeeRequest.getMid_name())
                .last_name(employeeRequest.getLast_name())
                .birth_date(employeeRequest.getBirth_date())
                .address(employeeRequest.getAddress())
                .phone(employeeRequest.getPhone())
                .email(employeeRequest.getEmail())
                .gender(employeeRequest.getGender())
                .username(employeeRequest.getUsername())
                .password(employeeRequest.getPassword())
                .build();
        employeeRepository.save(employee);
        EmployeeResponse employeeResponse =  EmployeeResponse.builder()
                .first_name(employee.getFirst_name())
                .mid_name(employee.getMid_name())
                .last_name(employee.getLast_name())
                .birth_date(employee.getBirth_date())
                .address(employee.getAddress())
                .phone(employee.getPhone())
                .email(employee.getEmail())
                .gender(employee.getGender())
                .username(employee.getUsername())
                .password(employee.getPassword())

                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeResponse);

    }

//    public ResponseEntity<?> findById(Integer id) {
//        Employee employee=employeeRepository.findById(id).orElse(null);
//        return ResponseEntity.ok().body(employee);
//    }

    public void deleteEmployeeById(int id){
        Employee employee = employeeRepository.findById(id).orElse(null);
        if(employee != null){
            employeeRepository.deleteById(id);
        }
    }

    public ResponseEntity<?> updateEmployee(EmployeeRequest employeeRequest) {

    }

}
