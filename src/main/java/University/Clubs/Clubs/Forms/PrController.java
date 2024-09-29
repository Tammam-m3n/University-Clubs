package University.Clubs.Clubs.Forms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/pr")
public class PrController {

    @Autowired
    private PrService prService;

    @PostMapping("add")
    public ResponseEntity<?> addPr(@RequestBody PrRequest prRequest){
        return prService.save(prRequest);
    }

    @DeleteMapping("delete_pr/{id}")
    public void deletePr(@PathVariable int id){
        prService.deleteById(id);
    }
}
