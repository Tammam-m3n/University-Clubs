package University.Clubs.Clubs.Student.Controller;

import University.Clubs.Clubs.Student.Request.StudentRequest;
import University.Clubs.Clubs.Student.Service.StudentService;
import University.Clubs.Clubs.Student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/s/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("add_student")
    @PreAuthorize("hasRole(ADMIN)")
    public ResponseEntity<?> addStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.save(studentRequest);
    }

    @GetMapping("all_student")
    @PreAuthorize("hasRole(ADMIN)")
    public ResponseEntity<?> getAllStudent() {
        return studentService.getAll();
    }

    @PutMapping("update_student")
    @PreAuthorize("hasRole(USER)")
    public Student update(Student student) {
        return studentService.update(student);
    }

    @GetMapping("by_student_id/{id}")
    @PreAuthorize("hasRole(ADMIN)")
    public ResponseEntity<?> getStudentById(@PathVariable int id) {
        return studentService.findById(id);
    }

    @DeleteMapping("delete_student/{id}")
    @PreAuthorize("hasRole(ADMIN)")
    public void deleteStudent(@PathVariable  int id) {
        studentService.deleteById(id);
    }
}
