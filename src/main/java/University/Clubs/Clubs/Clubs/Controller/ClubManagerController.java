package University.Clubs.Clubs.Clubs.Controller;

import University.Clubs.Clubs.Clubs.ClubManager;
import University.Clubs.Clubs.Clubs.Request.ClubManagerRequest;
import University.Clubs.Clubs.Clubs.Request.ClubManagerUpdateRequest;
import University.Clubs.Clubs.Clubs.Service.ClubManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/cm/club_manager")
public class ClubManagerController {
    @Autowired
    private ClubManagerService clubManagerService;

    @PostMapping("add_club_manager")
    @PreAuthorize("hasRole(ADMIN)")
    public ResponseEntity<?> addClubManager(@RequestBody ClubManagerRequest clubManagerRequest) {
        return clubManagerService.save(clubManagerRequest);
    }

    @GetMapping("all_clubs_managers")
    @PreAuthorize("hasRole(ADMIN)")
    public ResponseEntity<?> getAllClubManager() {return clubManagerService.getAll(); }

//    @PutMapping("update_club_manager")
//    @PreAuthorize("hasRole(MA/NAGER)")
//    public ClubManager updateClubManager(ClubManager clubManager) {
//        return clubManagerService.update(clubManager);
//    }

    @PutMapping("admin_update_club_manager")
    @PreAuthorize("hasRole(ADMIN)")
    public ClubManager adminUpdateClubManager(ClubManagerUpdateRequest request) {
        return clubManagerService.admin_update(request);
    }

    @GetMapping("by_club_manager_id/{id}")
    @PreAuthorize("hasRole(ADMIN)")
    public ResponseEntity<?> getClubManagerById(@PathVariable int id) {return clubManagerService.findById(id);}

    @DeleteMapping("delete_club_manager/{id}")
    @PreAuthorize("hasRole(ADMIN)")
    public void deleteClub(@PathVariable  int id) {
        clubManagerService.deleteById(id);
    }
}

