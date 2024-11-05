package University.Clubs.Clubs.Clubs.controller;
import University.Clubs.Clubs.Clubs.request.EtharRequest;
import University.Clubs.Clubs.Clubs.service.EtharService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/E1/etharmember")
public class EtharController {
    @Autowired
    private EtharService etharService;


    @PostMapping("add_student")
    public ResponseEntity<?> addStudent(@RequestBody EtharRequest etharRequest) {
//        System.out.println(studentRequest.getName());
        return etharService.save(etharRequest);
    }

}
