package University.Clubs.Clubs.Clubs.Service;

import University.Clubs.Clubs.Clubs.Appointment;
import University.Clubs.Clubs.Clubs.HRManager;
import University.Clubs.Clubs.Clubs.PRManager;
import University.Clubs.Clubs.Clubs.Repository.AppointmentRepository;
import University.Clubs.Clubs.Clubs.Repository.HRManagerRepository;
import University.Clubs.Clubs.Clubs.Repository.PRManagerRepository;
import University.Clubs.Clubs.Clubs.Request.AppointmentRequest;
import University.Clubs.Clubs.Clubs.Response.AppointmentResponse;
import University.Clubs.Clubs.Clubs.Response.HRManagerResponse;
import University.Clubs.Clubs.Clubs.Response.PRManagerResponse;
import University.Clubs.Clubs.Student.Repository.StudentRepository;
import University.Clubs.Clubs.Student.Response.StudentResponse;
import University.Clubs.Clubs.Student.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private PRManagerRepository prManagerRepository;
    @Autowired
    private HRManagerRepository hrManagerRepository;
    @Autowired
    private StudentRepository studentRepository;

    public ResponseEntity<?> save(AppointmentRequest appointmentRequest) {

        PRManager prManager = prManagerRepository.findById(appointmentRequest.getPr_manager_id()).orElse(null);
        HRManager hrManager = hrManagerRepository.findById(appointmentRequest.getHr_manager_id()).orElse(null);
        Student student = studentRepository.findById(appointmentRequest.getStudent_id()).orElse(null);

        Appointment appointment = Appointment.builder()
                .student(student)
                .hrManager(hrManager)
                .build();
        appointmentRepository.save(appointment);

        StudentResponse studentResponse = StudentResponse.builder()
                .student_id(student.getStudent_id())
                .full_name(student.getFull_name())
                .build();

        PRManagerResponse prManagerResponse = PRManagerResponse.builder()
                .university_number(hrManager.getStudent().getUniversityNumber())
                .build();

        HRManagerResponse hrManagerResponse = HRManagerResponse.builder()
                .university_number(hrManager.getStudent().getUniversityNumber())
                .build();

        AppointmentResponse appointmentResponse = AppointmentResponse.builder()
                .appointmentId(appointment.getAppointment_id())
                .prManager(prManagerResponse)
                .hrManager(hrManagerResponse)
                .student(studentResponse)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentResponse);
    }

    public ResponseEntity<?> getAll() {

        List<Appointment> Appointments = appointmentRepository.findAll();
        List<AppointmentResponse> appointmentResponses = new ArrayList<>();

        for (Appointment appointment : Appointments ) {
            Student student1 = appointment.getStudent();
            StudentResponse studentResponse = StudentResponse.builder()
                    .student_id(student1.getStudent_id())
                    .full_name(student1.getFull_name())
                    .build();

            PRManager prManager = appointment.getPrManager();
            PRManagerResponse prManagerResponse = PRManagerResponse.builder()
                    .pr_manager_id(prManager.getPr_manager_id())
                    .university_number(prManager.getStudent().getUniversityNumber())
                    .build();

            HRManager hrManager = appointment.getHrManager();
            HRManagerResponse hrManagerResponse = HRManagerResponse.builder()
                    .hr_manager_id(hrManager.getHr_manager_id())
                    .university_number(hrManager.getStudent().getUniversityNumber())
                    .build();

            AppointmentResponse appointmentResponse=AppointmentResponse.builder()
                    .appointmentId(appointment.getAppointment_id())
                    .prManager(prManagerResponse)
                    .hrManager(hrManagerResponse)
                    .student(studentResponse)
                    .build();
            appointmentResponses.add(appointmentResponse);
        }
        return ResponseEntity.status(HttpStatus.OK).body(appointmentResponses);
    }

    public ResponseEntity<?> findById(int id) {

        Appointment appointment = appointmentRepository.findById(id).orElse(null);
        if (appointment == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        PRManager prManager = appointment.getPrManager();
        PRManagerResponse prManagerResponse = PRManagerResponse.builder()
                .pr_manager_id(prManager.getPr_manager_id())
                .university_number(prManager.getStudent().getUniversityNumber())
                .build();

        Student student = appointment.getStudent();
        StudentResponse studentResponse = StudentResponse.builder()
                .student_id(student.getStudent_id())
                .full_name(student.getFull_name())
                .build();

        HRManager hrManager = appointment.getHrManager();
        HRManagerResponse hrManagerResponse = HRManagerResponse.builder()
                .hr_manager_id(hrManager.getHr_manager_id())
                .university_number(hrManager.getStudent().getUniversityNumber())
                .build();

        AppointmentResponse appointmentResponse =AppointmentResponse.builder()
                .appointmentId(appointment.getAppointment_id())
                .prManager(prManagerResponse)
                .hrManager(hrManagerResponse)
                .student(studentResponse)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(appointmentResponse);
    }

    public void deleteById(int id) {

        Appointment appointment = appointmentRepository.findById(id).orElse(null);
        if (appointment != null) {
            appointmentRepository.deleteById(id);
        }
    }

    public Appointment update(Appointment appointment) {

        Appointment appointment1 = appointmentRepository.findById(appointment.getAppointment_id()).orElse(null);
        Student student = appointment1.getStudent();

        if (appointment1 != null) {
            appointment1.setAppointment_date(appointment.getAppointment_date());
            student.setStudent_id(student.getStudent_id());
            appointmentRepository.save(appointment1);
        }
        return appointment;
    }
}

