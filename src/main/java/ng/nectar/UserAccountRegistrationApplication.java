package ng.nectar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
//@EnableJpaRepositories("ng.nectar.repository")
public class UserAccountRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserAccountRegistrationApplication.class, args);
	}
}
