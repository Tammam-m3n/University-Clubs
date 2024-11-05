package University.Clubs.Clubs.Clubs.Service;

import University.Clubs.Clubs.Clubs.Club;
import University.Clubs.Clubs.Clubs.ClubManager;
import University.Clubs.Clubs.Clubs.Repository.ClubManagerRepository;
import University.Clubs.Clubs.Clubs.Repository.ClubRepository;
import University.Clubs.Clubs.Clubs.Request.ClubManagerRequest;
import University.Clubs.Clubs.Clubs.Request.ClubManagerUpdateRequest;
import University.Clubs.Clubs.Clubs.Response.ClubManagerResponse;
import University.Clubs.Clubs.Clubs.Response.ClubResponse;
import University.Clubs.Clubs.Student.Repository.StudentRepository;
import University.Clubs.Clubs.Student.Response.StudentResponse;
import University.Clubs.Clubs.Student.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static University.Clubs.Clubs.Security.user.Role.CLUB_MANAGER;
import static University.Clubs.Clubs.Security.user.Role.USER;

@Service
@RequiredArgsConstructor
public class ClubManagerService {

    @Autowired
    private ClubManagerRepository clubManagerRepository;
    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private StudentRepository studentRepository;

    public ResponseEntity<?> save(ClubManagerRequest  clubManagerRequest) {

        Student student = studentRepository.findById(clubManagerRequest.getStudent_id()).orElse(null);
        Club club = clubRepository.findById(clubManagerRequest.getClub_id()).orElse(null);

        ClubManager clubManager = ClubManager.builder()
                .student(student)
                .club(club)
                .build();
        clubManagerRepository.save(clubManager);

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

        ClubResponse clubResponse = ClubResponse.builder()
                .club_id(club.getClub_id())
                .name(club.getName())
                .club_type(club.getClub_type())
                .description(club.getDescription())
                .active(club.getActive())
                .build();

        ClubManagerResponse clubManagerResponse = ClubManagerResponse.builder()
                .club_manager_id(clubManager.getClub_manager_id())
                .student(studentResponse)
                .club(clubResponse)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(clubManagerResponse);
    }

    public ResponseEntity<?> getAll() {

        List<ClubManager> clubManagers = clubManagerRepository.findAll();
        List<ClubManagerResponse> clubManagerResponses = new ArrayList<>();
        for (ClubManager clubManager : clubManagers) {

            Student student = clubManager.getStudent();
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

            Club club = clubManager.getClub();
            ClubResponse clubResponse = ClubResponse.builder()
                    .club_id(club.getClub_id())
                    .name(club.getName())
                    .club_type(club.getClub_type())
                    .description(club.getDescription())
                    .active(club.getActive())
                    .build();

            ClubManagerResponse clubManagerResponse = ClubManagerResponse.builder()
                    .club_manager_id(clubManager.getClub_manager_id())
                    .student(studentResponse)
                    .club(clubResponse)
                    .build();
            clubManagerResponses.add(clubManagerResponse);
        }
        return ResponseEntity.status(HttpStatus.OK).body(clubManagerResponses);
    }

    public ResponseEntity<?> findById(int id) {

        ClubManager clubManager = clubManagerRepository.findById(id).orElse(null);
        if (clubManager == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        ClubManagerResponse clubManagerResponse = ClubManagerResponse.builder()
                .club_manager_id(clubManager.getClub_manager_id())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(clubManagerResponse);
    }

    public void deleteById(int id) {

        ClubManager clubManager = clubManagerRepository.findById(id).orElse(null);
        if (clubManager != null) {
            clubManagerRepository.deleteById(id);
        }
    }

//    public ClubManager update(ClubManager clubManager) {
//
//        ClubManager clubManager1 = clubManagerRepository.findById(clubManager.getClub_manager_id()).orElse(null);
//
//        if (clubManager1 != null) {
//            clubManagerRepository.save(clubManager1);
//        }
//        return clubManager;
//    }

    public ClubManager admin_update(ClubManagerUpdateRequest request) {

        Club club = clubRepository.findById(request.getClub_id()).orElse(null);
        ClubManager manager = club.getClubManager();
        Student oldStudent = manager.getStudent();

        Student newStudent = studentRepository.findByUniversityNumber(request.getUniversity_number()).orElse(null);

        if (newStudent == null) {
            return manager;
        }

        oldStudent.setRole(USER);
        studentRepository.save(oldStudent);

        newStudent.setRole(CLUB_MANAGER);
        studentRepository.save(newStudent);

        manager.setStudent(newStudent);
        clubManagerRepository.save(manager);
        club.setClubManager(manager);

        return manager;

    }
}
