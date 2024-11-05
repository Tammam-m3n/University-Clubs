package University.Clubs.Clubs.Clubs.Controller;

import University.Clubs.Clubs.Clubs.Appointment;
import University.Clubs.Clubs.Clubs.Request.AppointmentRequest;
import University.Clubs.Clubs.Clubs.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/a/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("add_appointment")
    public ResponseEntity<?> addAppointment(@RequestBody AppointmentRequest appointmentRequest) {
        return appointmentService.save(appointmentRequest);
    }

    @GetMapping("all_appointments")
    public ResponseEntity<?> getAllAppointment() {return appointmentService.getAll();}

    @GetMapping("by_appointment_id/{id}")
    public ResponseEntity<?> getAppointmentById(@PathVariable int id) {return appointmentService.findById(id);}

    @DeleteMapping("delete_appointment")
    public void deleteAppointment(int id) {appointmentService.deleteById(id);}

    @PutMapping("update_appointment")
    public Appointment update(Appointment appointment) {
        return appointmentService.update(appointment);
    }
}


