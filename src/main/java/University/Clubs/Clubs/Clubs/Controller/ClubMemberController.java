package University.Clubs.Clubs.Clubs.Controller;

import University.Clubs.Clubs.Clubs.ClubMember;
import University.Clubs.Clubs.Clubs.Request.ClubMemberRequest;
import University.Clubs.Clubs.Clubs.Service.ClubMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/cm1/club_member")
public class ClubMemberController {

    @Autowired
    private ClubMemberService clubMemberService;

    @PostMapping("add_club_member")
    public ResponseEntity<?> addClubMember(@RequestBody ClubMemberRequest clubMemberRequest) {
        return clubMemberService.save(clubMemberRequest);
    }

    @GetMapping("all_club_member")
    public ResponseEntity<?> getAllClubMember() {
        return clubMemberService.getAll();
    }

    @GetMapping("by_club_member_id/{id}")
    public ResponseEntity<?> getClubMemberById(@PathVariable int id) {
        return  clubMemberService.findById(id);
    }

    @DeleteMapping("delete_club_member")
    public void deleteClubMember(int id) {
        clubMemberService.deleteById(id);
    }
}
