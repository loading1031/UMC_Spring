package umc.bob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BobApplication {

	public static void main(String[] args) {
		SpringApplication.run(BobApplication.class, args);
	}

}
