package University.Clubs.Clubs.UniversitySide.Controller;

import University.Clubs.Clubs.UniversitySide.Employee;
import University.Clubs.Clubs.UniversitySide.Request.EmployeeRequest;
import University.Clubs.Clubs.UniversitySide.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/e1/employee")
public class EmpolyeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("add_employee")
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return employeeService.saveEmployee(employeeRequest);
    }

    @DeleteMapping("delete_employee/{id}")
    public void deleteEmployeeById(@PathVariable int id) {
        employeeService.deleteById(id);
    }

    @PostMapping("update_employee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }
}
