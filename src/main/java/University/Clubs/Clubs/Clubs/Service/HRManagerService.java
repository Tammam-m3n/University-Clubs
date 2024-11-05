package University.Clubs.Clubs.Clubs.Service;

import University.Clubs.Clubs.Clubs.HRManager;
import University.Clubs.Clubs.Clubs.Repository.HRManagerRepository;
import University.Clubs.Clubs.Clubs.Request.HRManagerRequest;
import University.Clubs.Clubs.Clubs.Response.HRManagerResponse;
import University.Clubs.Clubs.Student.Repository.StudentRepository;
import University.Clubs.Clubs.Student.Response.StudentResponse;
import University.Clubs.Clubs.Student.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class HRManagerService {

    @Autowired
    private HRManagerRepository hrManagerRepository;
    @Autowired
    private StudentRepository studentRepository;

    public ResponseEntity<?> save(HRManagerRequest hrManagerRequest) {

        Student student = studentRepository.findById(hrManagerRequest.getStudent_id()).orElse(null);

        HRManager hrManager = HRManager.builder()
                .university_number(hrManagerRequest.getUniversity_number())
                .password(hrManagerRequest.getPassword())
                .student(student)
                .build();
        hrManagerRepository.save(hrManager);

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

        HRManagerResponse hrManagerResponse = HRManagerResponse.builder()
                .hr_manager_id(hrManager.getHr_manager_id())
                .university_number(hrManager.getUniversity_number())
                .password(hrManager.getPassword())
                .student(studentResponse)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(hrManagerResponse);
    }

    public ResponseEntity<?> findById(int id) {

        HRManager hrManager = hrManagerRepository.findById(id).orElse(null);
        if (hrManager == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Student student = hrManager.getStudent();
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

        HRManagerResponse hrManagerResponse = HRManagerResponse.builder()
                .hr_manager_id(hrManager.getHr_manager_id())
                .university_number(hrManager.getUniversity_number())
                .password(hrManager.getPassword())
                .student(studentResponse)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(hrManagerResponse);
    }

    public void deleteById(int id) {

        HRManager hrManager = hrManagerRepository.findById(id).orElse(null);
        if (hrManager != null) {
            hrManagerRepository.deleteById(id);
        }
    }

    public HRManager update(HRManager hrManager) {

        HRManager hrManager1 = hrManagerRepository.findById(hrManager.getHr_manager_id()).orElse(null);

        if (hrManager1 != null) {
            hrManager1.setPassword(hrManager.getPassword());
            hrManagerRepository.save(hrManager1);
        }
        return hrManager;
    }

    public HRManager admin_update(HRManager hrManager) {

        HRManager hrManage = hrManagerRepository.findById(hrManager.getHr_manager_id()).orElse(null);
        Student student = hrManager.getStudent();

        if (hrManage != null) {
            hrManage.setUniversity_number(hrManager.getUniversity_number());
            student.setStudent_id(student.getStudent_id());
            hrManagerRepository.save(hrManage);
        }
        return hrManage;
    }
}
