package University.Clubs.Clubs.Clubs.service;

import University.Clubs.Clubs.Clubs.repository.EtharRepository;
import University.Clubs.Clubs.Clubs.request.EtharRequest;
import University.Clubs.Clubs.Clubs.response.EtharResponse;
import University.Clubs.Clubs.Forms.Colleges;
import University.Clubs.Clubs.Forms.EtharClub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EtharService {

    @Autowired
    private EtharRepository etharRepository;

    public ResponseEntity<?> save(EtharRequest etharRequest) {
        EtharClub etharClub = EtharClub.builder()
                .fullName(etharRequest.getFullName())
                .universityNumber(etharRequest.getUniversityNumber())
                .birthDate(etharRequest.getBirthDate())
                .birthDate(etharRequest.getBirthDate())
                .currentResidence(etharRequest.getCurrentResidence())
                .nationality(etharRequest.getNationality())
                .college(Colleges.valueOf(etharRequest.getCollege()))
                .phoneNumber(etharRequest.getPhoneNumber())
                .email(etharRequest.getEmail())
                .membershipGoal(etharRequest.getMembershipGoal())
                .skills(etharRequest.getSkills())
                .anotherClub(etharRequest.isAnotherClub())
                .build();
        etharRepository.save(etharClub);


        EtharResponse etharResponse =EtharResponse.builder()
                .fullName(etharClub.getFullName())
                .universityNumber(etharClub.getUniversityNumber())
                .birthDate(etharClub.getBirthDate())
                .birthDate(etharClub.getBirthDate())
                .currentResidence(etharClub.getCurrentResidence())
                .nationality(etharClub.getNationality())
                .college(String.valueOf(etharClub.getCollege()))
                .phoneNumber(etharClub.getPhoneNumber())
                .email(etharClub.getEmail())
                .membershipGoal(etharClub.getMembershipGoal())
                .skills(etharClub.getSkills())
                .anotherClub(etharClub.isAnotherClub())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(etharResponse);


    }
}
