package ng.nectar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
//@EnableJpaRepositories("ng.nectar.repository")
public class PoliworksApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoliworksApplication.class, args);
	}
}
