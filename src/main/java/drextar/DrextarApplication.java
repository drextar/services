package drextar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication(scanBasePackages = "drextar")
@EnableFeignClients(basePackages = "drextar.infrastructure")
public class DrextarApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrextarApplication.class, args);
	}

}
