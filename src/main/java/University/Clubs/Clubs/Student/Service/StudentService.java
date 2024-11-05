package University.Clubs.Clubs.Student.Service;

import University.Clubs.Clubs.Clubs.PRManager;
import University.Clubs.Clubs.Clubs.Repository.PRManagerRepository;
import University.Clubs.Clubs.Clubs.Response.PRManagerResponse;
import University.Clubs.Clubs.Student.Repository.StudentRepository;
import University.Clubs.Clubs.Student.Request.StudentRequest;
import University.Clubs.Clubs.Student.Response.StudentResponse;
import University.Clubs.Clubs.Student.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private PRManagerRepository prManagerRepository;

    public ResponseEntity<?> save(StudentRequest studentRequest) {

        PRManager prManager = prManagerRepository.findById(studentRequest.getPr_manager_id()).orElse(null);
        Student student = Student.builder()
                .full_name(studentRequest.getFull_name())
                .birth_date(studentRequest.getBirth_date())
                .address(studentRequest.getAddress())
                .phone_number(studentRequest.getPhone_number())
                .email(studentRequest.getEmail())
                .university_number(studentRequest.getUniversity_number())
                .password(studentRequest.getPassword())
                .college(studentRequest.getCollege())
                .skills(studentRequest.getSkills())
                .interests(studentRequest.getInterests())
                .social_media_account(studentRequest.getSocial_media_account())
                .gpa(studentRequest.getGpa())
                .prManager(prManager)
                .build();
        studentRepository.save(student);

//        PRManagerResponse prManagerResponse = PRManagerResponse.builder()
//                .pr_manager_id(prManager.getPr_manager_id())
//                .university_number(prManager.getUniversity_number())
//                .build();

        StudentResponse studentResponse = StudentResponse.builder()
                .student_id(student.getStudent_id())
                .full_name(student.getFull_name())
                .birth_date(student.getBirth_date())
                .address(student.getAddress())
                .phone_number(student.getPhone_number())
                .email(student.getEmail())
                .university_number(student.getUniversity_number())
                .password(student.getPassword())
                .college(student.getCollege())
                .skills(student.getSkills())
                .interests(student.getInterests())
                .social_media_account(student.getSocial_media_account())
                .gpa(student.getGpa())
//                .prManager(prManagerResponse)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(studentResponse);
    }

    public ResponseEntity<?> getAll() {

        List<Student> students = studentRepository.findAll();
        List<StudentResponse> studentResponses = new ArrayList<>();
        for (Student student : students) {

            StudentResponse studentResponse = StudentResponse.builder()
                    .student_id(student.getStudent_id())
                    .full_name(student.getFull_name())
                    .birth_date(student.getBirth_date())
                    .address(student.getAddress())
                    .phone_number(student.getPhone_number())
                    .email(student.getEmail())
                    .university_number(student.getUniversity_number())
                    .password(student.getPassword())
                    .college(student.getCollege())
                    .skills(student.getSkills())
                    .interests(student.getInterests())
                    .social_media_account(student.getSocial_media_account())
                    .gpa(student.getGpa())
                    .build();
            studentResponses.add(studentResponse);
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentResponses);
    }

    public ResponseEntity<?> findById(int id) {

        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        StudentResponse studentResponse = StudentResponse.builder()
                .student_id(student.getStudent_id())
                .full_name(student.getFull_name())
                .birth_date(student.getBirth_date())
                .address(student.getAddress())
                .phone_number(student.getPhone_number())
                .email(student.getEmail())
                .university_number(student.getUniversity_number())
                .password(student.getPassword())
                .college(student.getCollege())
                .skills(student.getSkills())
                .interests(student.getInterests())
                .social_media_account(student.getSocial_media_account())
                .gpa(student.getGpa())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(studentResponse);
    }

    public void deleteById(int id) {

        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            studentRepository.deleteById(id);
        }
    }

    public Student update(Student student) {

        Student stud = studentRepository.findById(student.getStudent_id()).orElse(null);

        if (stud != null) {
            stud.setFull_name(student.getFull_name());
            stud.setBirth_date(student.getBirth_date());
            stud.setAddress(student.getAddress());
            stud.setPhone_number(student.getPhone_number());
            stud.setEmail(student.getEmail());
            stud.setUniversity_number(student.getUniversity_number());
            stud.setPassword(student.getPassword());
            stud.setCollege(student.getCollege());
            stud.setSkills(student.getSkills());
            stud.setInterests(student.getInterests());
            stud.setSocial_media_account(student.getSocial_media_account());
            stud.setGpa(student.getGpa());
            studentRepository.save(stud);
        }
        return stud;
    }
}
