package net.myphenotype.microservices.Ground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "AuditorAwareImpl")
public class GroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroundApplication.class, args);
	}

}
