package University.Clubs.Clubs.Clubs.Service;

import University.Clubs.Clubs.Clubs.Club;
import University.Clubs.Clubs.Clubs.Repository.ClubRepository;
import University.Clubs.Clubs.Clubs.Request.ClubRequest;
import University.Clubs.Clubs.Clubs.Response.ClubResponse;
import University.Clubs.Clubs.Student.Repository.StudentRepository;
import University.Clubs.Clubs.Student.Request.StudentRequest;
import University.Clubs.Clubs.Student.Response.StudentResponse;
import University.Clubs.Clubs.Student.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClubService {

    @Autowired
    private ClubRepository clubRepository;

    public ResponseEntity<?> save(ClubRequest clubRequest) {

        Club club = Club.builder()
                .name(clubRequest.getName())
                .club_type(clubRequest.getClub_type())
                .description(clubRequest.getDescription())
                .active(clubRequest.getActive())
                .build();
        clubRepository.save(club);
        ClubResponse clubResponse = ClubResponse.builder()
                .name(club.getName())
                .club_type(club.getClub_type())
                .description(club.getDescription())
                .active(club.getActive())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(clubResponse);
    }

    public ResponseEntity<?> getAll() {
        List<Club> clubs = clubRepository.findAll();
        List<ClubResponse> clubResponses = new ArrayList<>();
        for (Club club : clubs) {
            ClubResponse clubResponse = ClubResponse.builder()
                    .club_id(club.getClub_id())
                    .name(club.getName())
                    .club_type(club.getClub_type())
                    .description(club.getDescription())
                    .active(club.getActive())
                    .build();
            clubResponses.add(clubResponse);
        }
        return ResponseEntity.status(HttpStatus.OK).body(clubResponses);
    }

    public ResponseEntity<?> findById(int id) {
        Club club = clubRepository.findById(id).orElse(null);
        if (club == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        ClubResponse clubResponse = ClubResponse.builder()
                .club_id(club.getClub_id())
                .name(club.getName())
                .club_type(club.getClub_type())
                .description(club.getDescription())
                .active(club.getActive())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(clubResponse);
    }

    public void deleteById(int id) {
        Club club = clubRepository.findById(id).orElse(null);
        if (club != null) {
            clubRepository.deleteById(id);
        }
    }

    public Club update(Club club) {
        Club club1 = clubRepository.findById(club.getClub_id()).orElse(null);

        if (club1 != null) {
            club1.setName(club.getName());
            club1.setClub_type(club.getClub_type());
            club1.setDescription(club.getDescription());
            club1.setActive(club.getActive());
            clubRepository.save(club1);
        }
        return club;
    }
}
