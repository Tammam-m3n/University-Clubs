package University.Clubs.Clubs.Clubs.Service;

import University.Clubs.Clubs.Clubs.Club;
import University.Clubs.Clubs.Clubs.ClubMembershipRequest;
import University.Clubs.Clubs.Clubs.Repository.ClubMembershipRequestRepository;
import University.Clubs.Clubs.Clubs.Repository.ClubRepository;
import University.Clubs.Clubs.Clubs.Request.ClubMembershipRequestRequest;
import University.Clubs.Clubs.Clubs.Response.ClubMembershipRequestResponse;
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
public class ClubMembershipRequestService {

    @Autowired
    private ClubMembershipRequestRepository clubMembershipRequestRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClubRepository clubRepository;

    public ResponseEntity<?> save(ClubMembershipRequestRequest clubMembershipRequestRequest) {

        Student student = studentRepository.findById(clubMembershipRequestRequest.getStudent_id()).orElse(null);
        Club club = clubRepository.findById(clubMembershipRequestRequest.getClub_id()).orElse(null);
        ClubMembershipRequest clubMembershipRequest = ClubMembershipRequest.builder()
                .status(clubMembershipRequestRequest.getStatus())
                .submission_date(clubMembershipRequestRequest.getSubmission_date())
                .student(student)
                .club(club)
                .build();
        clubMembershipRequestRepository.save(clubMembershipRequest);

        StudentResponse studentResponse = StudentResponse.builder()
                .student_id(student.getStudent_id())
                .full_name(student.getFull_name())
                .build();

        ClubResponse clubResponse = ClubResponse.builder()
                .club_id(club.getClub_id())
                .name(club.getName())
                .build();

        ClubMembershipRequestResponse clubMembershipRequestResponse = ClubMembershipRequestResponse.builder()
                .club_membership_request_id(clubMembershipRequest.getClub_membership_request_id())
                .status(clubMembershipRequest.getStatus())
                .submission_date(clubMembershipRequest.getSubmission_date())
                .student(studentResponse)
                .club(clubResponse)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(clubMembershipRequestResponse);
    }

    public ResponseEntity<?> getAll() {

        List<ClubMembershipRequest> clubMembershipRequests = clubMembershipRequestRepository.findAll();
        List<ClubMembershipRequestResponse> clubMembershipRequestResponses = new ArrayList<>();
        for (ClubMembershipRequest clubMembershipRequest : clubMembershipRequests) {

            Student student = clubMembershipRequest.getStudent();
            StudentResponse studentResponse = StudentResponse.builder()
                    .student_id(student.getStudent_id())
                    .full_name(student.getFull_name())
                    .build();

            Club club = clubMembershipRequest.getClub();
            ClubResponse clubResponse = ClubResponse.builder()
                    .club_id(club.getClub_id())
                    .name(club.getName())
                    .build();

            ClubMembershipRequestResponse clubMembershipRequestResponse = ClubMembershipRequestResponse.builder()
                    .club_membership_request_id(clubMembershipRequest.getClub_membership_request_id())
                    .status(clubMembershipRequest.getStatus())
                    .submission_date(clubMembershipRequest.getSubmission_date())
                    .student(studentResponse)
                    .club(clubResponse)
                    .build();
            clubMembershipRequestResponses.add(clubMembershipRequestResponse);
        }
        return ResponseEntity.status(HttpStatus.OK).body(clubMembershipRequestResponses);
    }

    public ResponseEntity<?> findById(int id) {

        ClubMembershipRequest clubMembershipRequest = clubMembershipRequestRepository.findById(id).orElse(null);
        if (clubMembershipRequest == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Student student = clubMembershipRequest.getStudent();
        StudentResponse studentResponse = StudentResponse.builder()
                .student_id(student.getStudent_id())
                .full_name(student.getFull_name())
                .build();

        Club club = clubMembershipRequest.getClub();
        ClubResponse clubResponse = ClubResponse.builder()
                .club_id(club.getClub_id())
                .name(club.getName())
                .build();

        ClubMembershipRequestResponse clubMembershipRequestResponse = ClubMembershipRequestResponse.builder()
                .club_membership_request_id(clubMembershipRequest.getClub_membership_request_id())
                .status(clubMembershipRequest.getStatus())
                .submission_date(clubMembershipRequest.getSubmission_date())
                .student(studentResponse)
                .club(clubResponse)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(clubMembershipRequestResponse);
    }

    public void deleteById(int id) {

        ClubMembershipRequest clubMembershipRequest = clubMembershipRequestRepository.findById(id).orElse(null);
        if (clubMembershipRequest != null) {
            clubMembershipRequestRepository.deleteById(id);
        }
    }

    public ClubMembershipRequest update(ClubMembershipRequest clubMembershipRequest) {

        ClubMembershipRequest clubMembershipRequest1 = clubMembershipRequestRepository.findById(clubMembershipRequest.getClub_membership_request_id()).orElse(null);

        if (clubMembershipRequest1 != null) {
            clubMembershipRequest1.setStatus(clubMembershipRequest.getStatus());
            clubMembershipRequest1.setSubmission_date(clubMembershipRequest.getSubmission_date());
            clubMembershipRequest1.setStudent(clubMembershipRequest.getStudent());
            clubMembershipRequest1.setClub(clubMembershipRequest.getClub());
            clubMembershipRequestRepository.save(clubMembershipRequest1);
        }
        return clubMembershipRequest;
    }
}
