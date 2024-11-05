package University.Clubs.Clubs.Clubs.Controller;

import University.Clubs.Clubs.Clubs.ClubMember;
import University.Clubs.Clubs.Clubs.Request.ClubMemberRequest;
import University.Clubs.Clubs.Clubs.Service.ClubMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/cm/club_member")
public class ClubMemberController {

    @Autowired
    private ClubMemberService clubMemberService;

    @PostMapping("add_club_member")
    @PreAuthorize("hasRole(ADMIN)")
    public ResponseEntity<?> addClubMember(@RequestBody ClubMemberRequest clubMemberRequest) {
        return clubMemberService.save(clubMemberRequest);
    }

    @GetMapping("all_clubs_members")
    @PreAuthorize("hasRole(ADMIN)")
    public ResponseEntity<?> getAllClubMember() {
        return clubMemberService.getAll();
    }


    @GetMapping("by_club_member_id/{id}")
    @PreAuthorize("hasRole(ADMIN)")
    public ResponseEntity<?> getClubMemberById(@PathVariable int id) {
        return  clubMemberService.findById(id);
    }


    @DeleteMapping("delete_club_member")
    @PreAuthorize("hasRole(ADMIN)")
    public void deleteClubMember(int id) {
        clubMemberService.deleteById(id);
    }

    @PutMapping("update_club_member")
    @PreAuthorize("hasRole(ADMIN)")
    public ClubMember updateClubMember(ClubMember clubMember) {
        return clubMemberService.update(clubMember);
    }
}
