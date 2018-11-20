package ng.nectar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@ImportResource("classpath:application-context.xml")
public class PoliworksApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoliworksApplication.class, args);
	}
}
