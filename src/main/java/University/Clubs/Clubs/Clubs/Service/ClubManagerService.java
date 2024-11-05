package University.Clubs.Clubs.Clubs.Service;

import University.Clubs.Clubs.Clubs.Club;
import University.Clubs.Clubs.Clubs.ClubManager;
import University.Clubs.Clubs.Clubs.Repository.ClubManagerRepository;
import University.Clubs.Clubs.Clubs.Repository.ClubRepository;
import University.Clubs.Clubs.Clubs.Request.ClubManagerRequest;
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
                .university_number(clubManagerRequest.getUniversity_number()            )
                .password(clubManagerRequest.getPassword())
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
                .university_number(student.getUniversity_number())
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
                .university_number(clubManager.getUniversity_number())
                .password(clubManager.getPassword())
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
                    .university_number(student.getUniversity_number())
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
                    .university_number(clubManager.getUniversity_number())
                    .password(clubManager.getPassword())
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
                .university_number(clubManager.getUniversity_number())
                .password(clubManager.getPassword())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(clubManagerResponse);
    }

    public void deleteById(int id) {

        ClubManager clubManager = clubManagerRepository.findById(id).orElse(null);
        if (clubManager != null) {
            clubManagerRepository.deleteById(id);
        }
    }

    public ClubManager update(ClubManager clubManager) {

        ClubManager clubManager1 = clubManagerRepository.findById(clubManager.getClub_manager_id()).orElse(null);

        if (clubManager1 != null) {
            clubManager1.setPassword(clubManager.getPassword());
            clubManagerRepository.save(clubManager1);
        }
        return clubManager;
    }

    public ClubManager admin_update(ClubManager clubManager) {

        ClubManager clubManager1 = clubManagerRepository.findById(clubManager.getClub_manager_id()).orElse(null);
        Student student = clubManager1.getStudent();

        if (clubManager1 != null) {
            clubManager1.setUniversity_number(clubManager.getUniversity_number());
            student.setStudent_id(student.getStudent_id());
            clubManagerRepository.save(clubManager1);
        }
        return clubManager;
    }
}
