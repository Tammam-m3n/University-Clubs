package University.Clubs.Clubs.Clubs.Service;

import University.Clubs.Clubs.Clubs.Club;
import University.Clubs.Clubs.Clubs.ClubManager;
import University.Clubs.Clubs.Clubs.HRManager;
import University.Clubs.Clubs.Clubs.PRManager;
import University.Clubs.Clubs.Clubs.Repository.ClubManagerRepository;
import University.Clubs.Clubs.Clubs.Repository.ClubRepository;
import University.Clubs.Clubs.Clubs.Repository.HRManagerRepository;
import University.Clubs.Clubs.Clubs.Repository.PRManagerRepository;
import University.Clubs.Clubs.Clubs.Request.ClubRequest;
import University.Clubs.Clubs.Clubs.Response.ClubManagerResponse;
import University.Clubs.Clubs.Clubs.Response.ClubResponse;
import University.Clubs.Clubs.Clubs.Response.HRManagerResponse;
import University.Clubs.Clubs.Clubs.Response.PRManagerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClubService {

    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private PRManagerRepository prManagerRepository;
    @Autowired
    private HRManagerRepository hrManagerRepository;
    @Autowired
    private ClubManagerRepository clubManagerRepository;

    public ResponseEntity<?> save(ClubRequest clubRequest) {

        PRManager prManager = prManagerRepository.findById(clubRequest.getPr_manager_id()).orElse(null);
        HRManager hrManager = hrManagerRepository.findById(clubRequest.getHr_manager_id()).orElse(null);
        ClubManager clubManager = clubManagerRepository.findById(clubRequest.getClub_manager_id()).orElse(null);

        Club club = Club.builder()
                .name(clubRequest.getName())
                .club_type(clubRequest.getClub_type())
                .description(clubRequest.getDescription())
                .active(clubRequest.getActive())
                .prManager(prManager)
                .hrManager(hrManager)
                .clubManager(clubManager)
                .build();
        clubRepository.save(club);

        PRManagerResponse prManagerResponse = PRManagerResponse.builder()
                .pr_manager_id(prManager.getPr_manager_id())
                .university_number(prManager.getUniversity_number())
                .build();

        HRManagerResponse hrManagerResponse = HRManagerResponse.builder()
                .hr_manager_id(hrManager.getHr_manager_id())
                .university_number(hrManager.getUniversity_number())
                .build();

        ClubManagerResponse clubManagerResponse =ClubManagerResponse.builder()
                .club_manager_id(clubManager.getClub_manager_id())
                .university_number(clubManager.getUniversity_number())
                .build();

        ClubResponse clubResponse = ClubResponse.builder()
                .club_id(club.getClub_id())
                .name(club.getName())
                .club_type(club.getClub_type())
                .description(club.getDescription())
                .active(club.getActive())
                .prManager(prManagerResponse)
                .hrManager(hrManagerResponse)
                .clubManager(clubManagerResponse)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(clubResponse);
    }

    public ResponseEntity<?> getAll() {

        List<Club> clubs = clubRepository.findAll();
        List<ClubResponse> clubResponses = new ArrayList<>();
        for (Club club : clubs) {

            PRManager prManager = club.getPrManager();
            PRManagerResponse prManagerResponse = PRManagerResponse.builder()
                    .pr_manager_id(prManager.getPr_manager_id())
                    .university_number(prManager.getUniversity_number())
                    .build();

            HRManager hrManager= club.getHrManager();
            HRManagerResponse hrManagerResponse= HRManagerResponse.builder()
                    .hr_manager_id(hrManager.getHr_manager_id())
                    .university_number(hrManager.getUniversity_number())
                    .build();

            ClubManager clubManager= club.getClubManager();
            ClubManagerResponse clubManagerResponse =ClubManagerResponse.builder()
                    .club_manager_id(clubManager.getClub_manager_id())
                    .university_number(clubManager.getUniversity_number())
                    .build();

            ClubResponse clubResponse = ClubResponse.builder()
                    .club_id(club.getClub_id())
                    .name(club.getName())
                    .club_type(club.getClub_type())
                    .description(club.getDescription())
                    .active(club.getActive())
                    .prManager(prManagerResponse)
                    .hrManager(hrManagerResponse)
                    .clubManager(clubManagerResponse)
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

        PRManager prManager = club.getPrManager();
        PRManagerResponse prManagerResponse = PRManagerResponse.builder()
                .pr_manager_id(prManager.getPr_manager_id())
                .university_number(prManager.getUniversity_number())
                .build();

        HRManager hrManager = club.getHrManager();
        HRManagerResponse hrManagerResponse=HRManagerResponse.builder()
                .hr_manager_id(hrManager.getHr_manager_id())
                .university_number(hrManager.getUniversity_number())
                .build();

        ClubManager clubManager= club.getClubManager();
        ClubManagerResponse clubManagerResponse =ClubManagerResponse.builder()
                .club_manager_id(clubManager.getClub_manager_id())
                .university_number(clubManager.getUniversity_number())
                .build();

        ClubResponse clubResponse = ClubResponse.builder()
                .club_id(club.getClub_id())
                .name(club.getName())
                .club_type(club.getClub_type())
                .description(club.getDescription())
                .active(club.getActive())
                .prManager(prManagerResponse)
                .hrManager(hrManagerResponse)
                .clubManager(clubManagerResponse)
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
            club1.setClubManager(club.getClubManager());
            club1.setClubMembers(club.getClubMembers());
            clubRepository.save(club1);
        }
        return club;
    }
}
