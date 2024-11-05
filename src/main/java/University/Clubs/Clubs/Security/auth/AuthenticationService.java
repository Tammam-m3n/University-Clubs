package University.Clubs.Clubs.Security.auth;

import University.Clubs.Clubs.Security.config.JwtService;
import University.Clubs.Clubs.Security.user.Role;
import University.Clubs.Clubs.Student.Repository.StudentRepository;
import University.Clubs.Clubs.Student.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final StudentRepository studentRepository;
    private  final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;



    public AuthenticationResponse register(RegisterRequest request) {
        Student student = Student.builder()
//                .gpa(request.get)
                //TODO
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        studentRepository.save(student);
        String token = jwtService.generateToken(student);
        return  AuthenticationResponse.builder()
                .token(token)
                .build();

    }

    public AuthenticationResponse login(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUniversity_number(),
                        request.getPassword()
                )
        );
        Student user = studentRepository.findByUniversityNumber(request.getUniversity_number())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        String token = jwtService.generateToken(user);
        return  AuthenticationResponse.builder()
                .token(token)
                .build();

    }
}
