package University.Clubs.Clubs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class ClubsApplication{
@Autowired
	public static void main(String[] args) {
		SpringApplication.run(ClubsApplication.class, args);

	//	Employee employee = new Employee(1,"na","qwq","qwqw", LocalDate.of(2002,12,12),"12",12,"12","1","q","12",1);
	}

}
