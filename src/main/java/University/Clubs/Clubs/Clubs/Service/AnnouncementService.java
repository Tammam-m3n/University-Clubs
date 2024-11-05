package University.Clubs.Clubs.Clubs.Service;

import University.Clubs.Clubs.Clubs.Announcement;
import University.Clubs.Clubs.Clubs.Club;
import University.Clubs.Clubs.Clubs.PRManager;
import University.Clubs.Clubs.Clubs.Repository.AnnouncementRepository;
import University.Clubs.Clubs.Clubs.Repository.ClubRepository;
import University.Clubs.Clubs.Clubs.Repository.PRManagerRepository;
import University.Clubs.Clubs.Clubs.Request.AnnouncementRequest;
import University.Clubs.Clubs.Clubs.Response.AnnouncementResponse;
import University.Clubs.Clubs.Clubs.Response.ClubResponse;
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
public class AnnouncementService {

    @Autowired
    private AnnouncementRepository announcementRepository;
    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private PRManagerRepository prManagerRepository;

    public ResponseEntity<?> save(AnnouncementRequest announcementRequest) {

        PRManager prManager = prManagerRepository.findById(announcementRequest.getPr_manager_id()).orElse(null);
        Club club = clubRepository.findById(announcementRequest.getClub_id()).orElse(null);

        Announcement announcement = Announcement.builder()
                .title(announcementRequest.getTitle())
                .content(announcementRequest.getContent())
                .creation_date(announcementRequest.getCreation_date())
                .club(club)
                .prManager(prManager)
                .build();
        announcementRepository.save(announcement);

        ClubResponse clubResponse = ClubResponse.builder()
                .club_id(club.getClub_id())
                .name(club.getName())
                .build();

        PRManagerResponse prManagerResponse = PRManagerResponse.builder()
                .pr_manager_id(prManager.getPr_manager_id())
                .university_number(prManager.getStudent().getUniversityNumber())
                .build();

        AnnouncementResponse announcementResponse = AnnouncementResponse.builder()
                .announcement_id(announcement.getAnnouncement_id())
                .title(announcement.getTitle())
                .content(announcement.getContent())
                .creation_date(announcement.getCreation_date())
                .club(clubResponse)
                .prManager(prManagerResponse)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(clubResponse);
    }

    public ResponseEntity<?> getAll() {

        List<Announcement> announcements = announcementRepository.findAll();
        List<AnnouncementResponse> announcementResponses = new ArrayList<>();
        for (Announcement announcement : announcements) {

            Club club = announcement.getClub();
            ClubResponse clubResponse = ClubResponse.builder()
                    .club_id(club.getClub_id())
                    .name(club.getName())
                    .build();

            PRManager prManager = announcement.getPrManager();
            PRManagerResponse prManagerResponse = PRManagerResponse.builder()
                    .pr_manager_id(prManager.getPr_manager_id())
                    .university_number(prManager.getStudent().getUniversityNumber())
                    .build();

            AnnouncementResponse announcementResponse = AnnouncementResponse.builder()
                    .announcement_id(announcement.getAnnouncement_id())
                    .title(announcement.getTitle())
                    .content(announcement.getContent())
                    .creation_date(announcement.getCreation_date())
                    .club(clubResponse)
                    .prManager(prManagerResponse)
                    .build();
            announcementResponses.add(announcementResponse);
        }
        return ResponseEntity.status(HttpStatus.OK).body(announcementResponses);
    }

    public ResponseEntity<?> findById(int id) {

        Announcement announcement = announcementRepository.findById(id).orElse(null);
        if (announcement == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Club club = announcement.getClub();
        ClubResponse clubResponse = ClubResponse.builder()
                .club_id(club.getClub_id())
                .name(club.getName())
                .build();

        PRManager prManager = announcement.getPrManager();
        PRManagerResponse prManagerResponse = PRManagerResponse.builder()
                .pr_manager_id(prManager.getPr_manager_id())
                .university_number(prManager.getStudent().getUniversityNumber())
                .build();

        AnnouncementResponse announcementResponse = AnnouncementResponse.builder()
                .announcement_id(announcement.getAnnouncement_id())
                .title(announcement.getTitle())
                .content(announcement.getContent())
                .creation_date(announcement.getCreation_date())
                .club(clubResponse)
                .prManager(prManagerResponse)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(announcementResponse);
    }

    public void deleteById(int id) {

        Announcement announcement = announcementRepository.findById(id).orElse(null);
        if (announcement != null) {
            announcementRepository.deleteById(id);
        }
    }

    public Announcement update(Announcement announcement) {

        Announcement announcement1 = announcementRepository.findById(announcement.getAnnouncement_id()).orElse(null);
        Club club = announcement1.getClub();

        if (announcement1 != null) {
            announcement1.setAnnouncement_id(announcement.getAnnouncement_id());
            announcement1.setTitle(announcement.getTitle());
            announcement1.setContent(announcement.getContent());
            announcement1.setCreation_date(announcement.getCreation_date());
            club.setClub_id(club.getClub_id());
            announcementRepository.save(announcement1);
        }
        return announcement;
    }
}
