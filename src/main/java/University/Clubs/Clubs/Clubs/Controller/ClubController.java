package University.Clubs.Clubs.Clubs.Controller;

import University.Clubs.Clubs.Clubs.Club;
import University.Clubs.Clubs.Clubs.Request.ClubRequest;
import University.Clubs.Clubs.Clubs.Service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/c/club")

public class ClubController {

    @Autowired
    private ClubService clubService;

    @PostMapping("add_club")
    public ResponseEntity<?> addClub(@RequestBody ClubRequest  clubRequest) {
        return clubService.save(clubRequest);
    }

    @GetMapping("all_clubs")
    public ResponseEntity<?> getAllClub() {
        return clubService.getAll();
    }

    @PutMapping("update_club")
    public Club update(Club club) {
        return clubService.update(club);
    }

    @GetMapping("by_club_id/{id}")
    public ResponseEntity<?> getClubById(@PathVariable int id) {
        return clubService.findById(id);
    }

    @DeleteMapping("delete_club/{id}")
    public void deleteClub(@PathVariable  int id) {
        clubService.deleteById(id);
    }
}
