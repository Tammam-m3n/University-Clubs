package University.Clubs.Clubs.Forms;

import University.Clubs.Clubs.Request.EmployeeRequest;
import University.Clubs.Clubs.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
