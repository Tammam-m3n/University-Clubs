package University.Clubs.Clubs.Controller;

import University.Clubs.Clubs.Employee;
import University.Clubs.Clubs.Request.EmployeeRequest;
import University.Clubs.Clubs.Response.EmployeeResponse;
import University.Clubs.Clubs.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/employee")
public class EmpolyeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("add_employee")
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return employeeService.saveEmployee(employeeRequest);
    }


}
