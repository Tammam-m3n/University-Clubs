package University.Clubs.Clubs.Clubs.Controller;

import University.Clubs.Clubs.Clubs.ClubMembershipRequest;
import University.Clubs.Clubs.Clubs.Request.ClubMembershipRequestRequest;
import University.Clubs.Clubs.Clubs.Service.ClubMembershipRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/cmr/club_membership_request")
public class ClubMembershipRequestController {

    @Autowired
    private ClubMembershipRequestService clubMembershipRequestService;

    @PostMapping("add_club_membership_request")
    @PreAuthorize("hasRole(ADMIN)")
    public ResponseEntity<?> addClubMembershipRequest(@RequestBody ClubMembershipRequestRequest clubMembershipRequestRequest) {
        return clubMembershipRequestService.save(clubMembershipRequestRequest);
    }

    @GetMapping("all_club_membership_requests")
    @PreAuthorize("hasRole(ADMIN)")
    public ResponseEntity<?> getAllClubMembershipRequest() {
        return clubMembershipRequestService.getAll();
    }

    @PutMapping("update_club_membership_request")
    @PreAuthorize("hasRole(ADMIN)") // update admin
    public ClubMembershipRequest update(ClubMembershipRequest clubMembershipRequest) {
        return clubMembershipRequestService.update(clubMembershipRequest);
    }

    @GetMapping("by_club_membership_request_id/{id}")
    @PreAuthorize("hasRole(ADMIN)")
    public ResponseEntity<?> getClubMembershipRequestById(@PathVariable int id) {
        return clubMembershipRequestService.findById(id);
    }


    @DeleteMapping("delete_club_membership_request/{id}")
    @PreAuthorize("hasRole(ADMIN)")
    public void deleteClubMembershipRequest(@PathVariable  int id) {
        clubMembershipRequestService.deleteById(id);
    }
}
