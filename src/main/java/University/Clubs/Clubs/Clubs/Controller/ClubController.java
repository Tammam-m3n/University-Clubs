package University.Clubs.Clubs.Clubs.Controller;

import University.Clubs.Clubs.Clubs.Club;
import University.Clubs.Clubs.Clubs.Request.ClubRequest;
import University.Clubs.Clubs.Clubs.Service.ClubMemberService;
import University.Clubs.Clubs.Clubs.Service.ClubService;
import University.Clubs.Clubs.Student.Request.StudentRequest;
import University.Clubs.Clubs.Student.Service.StudentService;
import University.Clubs.Clubs.Student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/c1/club")
public class ClubController {

    @Autowired
    private ClubService clubService;

    @PostMapping("add_club")
    public ResponseEntity<?> addClub(@RequestBody ClubRequest  clubRequest) {
        return clubService.save(clubRequest);
    }

    @GetMapping("all_club")
    public ResponseEntity<?> getAllClub() {
        return clubService.getAll();
    }

    @GetMapping("update_club")
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
