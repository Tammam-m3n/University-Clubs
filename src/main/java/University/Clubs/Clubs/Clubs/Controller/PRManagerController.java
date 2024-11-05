package University.Clubs.Clubs.Clubs.Controller;

import University.Clubs.Clubs.Clubs.PRManager;
import University.Clubs.Clubs.Clubs.Request.PRManagerRequest;
import University.Clubs.Clubs.Clubs.Service.PRManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/pr/pr_manager")
public class PRManagerController {

    @Autowired
    private PRManagerService prManagerService;

    @PostMapping("add_pr_manager")
    public ResponseEntity<?> addPRManager(@RequestBody PRManagerRequest prManagerRequest) {
        return prManagerService.save(prManagerRequest);
    }

    @GetMapping("by_pr_manager_id/{id}")
    public ResponseEntity<?> getPRManagerById(@PathVariable int id) {
        return  prManagerService.findById(id);
    }

    @DeleteMapping("delete_pr_manager")
    public void deletePRManager(int id) {
        prManagerService.deleteById(id);
    }

    @PutMapping("update_pr_manager")
    public PRManager updatePRManager(PRManager prManager) {
        return prManagerService.update(prManager);
    }
}
