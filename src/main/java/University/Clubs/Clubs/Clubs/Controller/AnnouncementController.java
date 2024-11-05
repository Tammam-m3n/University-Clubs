package University.Clubs.Clubs.Clubs.Controller;

import University.Clubs.Clubs.Clubs.Announcement;
import University.Clubs.Clubs.Clubs.Request.AnnouncementRequest;
import University.Clubs.Clubs.Clubs.Service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/a/announcement")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    @PostMapping("add_announcement")
    public ResponseEntity<?> addAnnouncement(@RequestBody AnnouncementRequest announcementRequest) {
        return announcementService.save(announcementRequest);
    }

    @GetMapping("all_announcements")
    public ResponseEntity<?> getAllAnnouncement() { return announcementService.getAll(); }

    @PutMapping("update_announcement")
    public Announcement update(Announcement announcement) {
        return announcementService.update(announcement);
    }

    @GetMapping("by_announcement_id/{id}")
    public ResponseEntity<?> getAnnouncementById(@PathVariable int id) {
        return announcementService.findById(id);
    }

    @DeleteMapping("delete_announcement/{id}")
    public void deleteAnnouncement(@PathVariable int id) {
        announcementService.deleteById(id);
    }
}
