package University.Clubs.Clubs.Clubs.Controller;

import University.Clubs.Clubs.Clubs.HRManager;
import University.Clubs.Clubs.Clubs.Request.HRManagerRequest;
import University.Clubs.Clubs.Clubs.Service.HRManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/hr/hr_manager")
public class HRManagerController {
    @Autowired
    private HRManagerService hrManagerService;

    @PostMapping("add_hr_manager")
    @PreAuthorize("hasRole(ADMIN)")
    public ResponseEntity<?> addHRManager(@RequestBody HRManagerRequest hrManagerRequest) {
        return hrManagerService.save(hrManagerRequest);
    }

//    @PutMapping("update_hr_manager")
//    @PreAuthorize("hasRole(ADMIN)")
//    public HRManager update(HRManager hrManager) {
//        return hrManagerService.update(hrManager);
//    }

    @PutMapping("admin_update_hr_manager")
    public HRManager adminUpdate(String university_number) {
        return hrManagerService.admin_update(university_number);
    }

    @GetMapping("by_hr_manager_id/{id}")
    public ResponseEntity<?> getHRManagerById(@PathVariable int id) {
        return  hrManagerService.findById(id);
    }

    @DeleteMapping("delete_hr_manager")
    public void deleteClubMember(int id) {
        hrManagerService.deleteById(id);
    }
}

