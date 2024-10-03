package University.Clubs.Clubs.Clubs.Service;

import University.Clubs.Clubs.Clubs.Club;
import University.Clubs.Clubs.Clubs.ClubMember;
import University.Clubs.Clubs.Clubs.Repository.ClubMemberRepository;
import University.Clubs.Clubs.Clubs.Repository.ClubRepository;
import University.Clubs.Clubs.Clubs.Request.ClubMemberRequest;
import University.Clubs.Clubs.Clubs.Response.ClubMemberResponse;
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
public class ClubMemberService {

    @Autowired
    private ClubMemberRepository clubMemberRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClubRepository clubRepository;

    public ResponseEntity<?> save(ClubMemberRequest clubMemberRequest) {

        Student student = studentRepository.findById(clubMemberRequest.getStudent_id()).orElse(null);
        Club club = clubRepository.findById(clubMemberRequest.getClub_id()).orElse(null);
        ClubMember clubMember = ClubMember.builder()
                .student(student)
                .club(club)
                .build();
        clubMemberRepository.save(clubMember);

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
                .build();

        ClubMemberResponse clubMemberResponse = ClubMemberResponse.builder()
                .club_member_id(clubMember.getClub_member_id())
                .student(studentResponse)
                .club(clubResponse)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(clubMemberResponse);
    }

    public ResponseEntity<?> getAll() {

        List<ClubMember> clubMembers = clubMemberRepository.findAll();
        List<ClubMemberResponse> clubMemberResponses = new ArrayList<>();

        for (ClubMember clubMember : clubMembers) {
            Student student = clubMember.getStudent();
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

            Club club = clubMember.getClub();
            ClubResponse clubResponse = ClubResponse.builder()
                    .club_id(club.getClub_id())
                    .name(club.getName())
                    .build();

            ClubMemberResponse clubMemberResponse = ClubMemberResponse.builder()
                    .club_member_id(clubMember.getClub_member_id())
                    .student(studentResponse)
                    .club(clubResponse)
                    .build();
            clubMemberResponses.add(clubMemberResponse);
        }
        return ResponseEntity.status(HttpStatus.OK).body(clubMemberResponses);
    }

    public ResponseEntity<?> findById(int id) {

        ClubMember clubMember = clubMemberRepository.findById(id).orElse(null);
        if (clubMember == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Student student = clubMember.getStudent();
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

        Club club = clubMember.getClub();
        ClubResponse clubResponse = ClubResponse.builder()
                .club_id(club.getClub_id())
                .name(club.getName())
                .build();

        ClubMemberResponse clubMemberResponse = ClubMemberResponse.builder()
                .club_member_id(clubMember.getClub_member_id())
                .student(studentResponse)
                .club(clubResponse)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(clubMemberResponse);
    }

    public void deleteById(int id) {

        ClubMember clubMember = clubMemberRepository.findById(id).orElse(null);
        if (clubMember != null) {
            clubMemberRepository.deleteById(id);
        }
    }
}
