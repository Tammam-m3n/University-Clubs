package University.Clubs.Clubs.Forms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PrService {

    @Autowired
    private PrRepository prRepository;

    public ResponseEntity<?> save(PrRequest prRequest){
        PR_Club pr = PR_Club.builder()
                .full_name(prRequest.getFull_name())
                .university_number(prRequest.getUniversity_number())
                .birth_date(prRequest.getBirth_date())
                .phone(prRequest.getPhone())
                .sm_account(prRequest.getSm_account())
                .email(prRequest.getEmail())
                .basic_skills(prRequest.getBasic_skills())
                .workshops(prRequest.getWorkshops())
                .training_courses(prRequest.getTraining_courses())
                .languages(prRequest.getLanguages())
                .other_interests(prRequest.getOther_interests())
                .build();
        prRepository.save(pr);
        PrResponse prResponse = PrResponse.builder()
                .id(pr.getId())
                .full_name(prRequest.getFull_name())
                .university_number(prRequest.getUniversity_number())
                .birth_date(prRequest.getBirth_date())
                .phone(prRequest.getPhone())
                .sm_account(prRequest.getSm_account())
                .email(prRequest.getEmail())
                .basic_skills(prRequest.getBasic_skills())
                .workshops(prRequest.getWorkshops())
                .training_courses(prRequest.getTraining_courses())
                .languages(prRequest.getLanguages())
                .other_interests(prRequest.getOther_interests())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(prResponse);
    }

    public void deleteById(int id){
        PR_Club pr_club = prRepository.findById(id).orElse(null);
        if(pr_club != null){
            prRepository.deleteById(id);
        }
    }

    public PR_Club update(PR_Club pr_club){
        PR_Club pr = prRepository.findById(pr_club.getId()).orElse(null);
        if(pr != null){
            pr.setFull_name(pr_club.getFull_name());
            pr.setUniversity_number(pr_club.getUniversity_number());
            pr.setBirth_date(pr_club.getBirth_date());
            pr.setPhone(pr_club.getPhone());
            pr.setSm_account(pr_club.getSm_account());
            pr.setEmail(pr_club.getEmail());
            pr.setBasic_skills(pr_club.getBasic_skills());
            pr.setWorkshops(pr_club.getWorkshops());
            pr.setTraining_courses(pr_club.getTraining_courses());
            pr.setLanguages(pr_club.getLanguages());
            pr.setOther_interests(pr_club.getOther_interests());
            prRepository.save(pr);
        }
        return pr;
    }

}
