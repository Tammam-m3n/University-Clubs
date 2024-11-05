package University.Clubs.Clubs.Clubs.Service;

import University.Clubs.Clubs.Clubs.PRManager;
import University.Clubs.Clubs.Clubs.Repository.PRManagerRepository;
import University.Clubs.Clubs.Clubs.Request.PRManagerRequest;
import University.Clubs.Clubs.Clubs.Response.PRManagerResponse;
import University.Clubs.Clubs.Security.user.Role;
import University.Clubs.Clubs.Student.Repository.StudentRepository;
import University.Clubs.Clubs.Student.Response.StudentResponse;
import University.Clubs.Clubs.Student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PRManagerService {

    @Autowired
    private PRManagerRepository prManagerRepository;
    @Autowired
    private StudentRepository studentRepository;

    public ResponseEntity<?> save(PRManagerRequest prManagerRequest) {

        Student student = studentRepository.findById(prManagerRequest.getStudent_id()).orElse(null);

        PRManager prManager = PRManager.builder()
                .student(student)
                .build();
        prManagerRepository.save(prManager);

        StudentResponse studentResponse = StudentResponse.builder()
                .student_id(student.getStudent_id())
                .full_name(student.getFull_name())
                .birth_date(student.getBirth_date())
                .address(student.getAddress())
                .phone_number(student.getPhone_number())
                .email(student.getEmail())
                .university_number(student.getUniversityNumber())
                .password(student.getPassword())
                .college(student.getCollege())
                .skills(student.getSkills())
                .interests(student.getInterests())
                .social_media_account(student.getSocial_media_account())
                .gpa(student.getGpa())
                .build();

        PRManagerResponse prManagerResponse = PRManagerResponse.builder()
                .pr_manager_id(prManager.getPr_manager_id())
                .student(studentResponse)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(prManagerResponse);
    }

    public ResponseEntity<?> findById(int id) {

        PRManager prManager = prManagerRepository.findById(id).orElse(null);
        if (prManager == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Student student = prManager.getStudent();
        StudentResponse studentResponse = StudentResponse.builder()
                .student_id(student.getStudent_id())
                .full_name(student.getFull_name())
                .birth_date(student.getBirth_date())
                .address(student.getAddress())
                .phone_number(student.getPhone_number())
                .email(student.getEmail())
                .university_number(student.getUniversityNumber())
                .password(student.getPassword())
                .college(student.getCollege())
                .skills(student.getSkills())
                .interests(student.getInterests())
                .social_media_account(student.getSocial_media_account())
                .gpa(student.getGpa())
                .build();

        PRManagerResponse prManagerResponse = PRManagerResponse.builder()
                .pr_manager_id(prManager.getPr_manager_id())
                .student(studentResponse)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(prManagerResponse);
    }

    public void deleteById(int id) {

        PRManager prManager = prManagerRepository.findById(id).orElse(null);
        if (prManager != null) {
            prManagerRepository.deleteById(id);
        }
    }

    public PRManager admin_update(String university_number) {

        PRManager prManager = prManagerRepository.findById(1).orElse(null);
        Student oldStudent = studentRepository.findById(prManager.getStudent().getStudent_id()).orElse(null);
        Student newStudent = studentRepository.findByUniversityNumber(university_number).orElse(null);

        if(newStudent == null) {
            return  prManager;
        }

        oldStudent.setRole(Role.USER);
        studentRepository.save(oldStudent);

        newStudent.setRole(Role.ADMIN);
        studentRepository.save(newStudent);

        prManager.setStudent(newStudent);
        prManagerRepository.save(prManager);
        return prManager;
    }

}
