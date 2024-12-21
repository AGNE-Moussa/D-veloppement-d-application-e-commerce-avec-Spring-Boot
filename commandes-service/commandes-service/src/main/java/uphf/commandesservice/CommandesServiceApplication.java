package uphf.commandesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CommandesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommandesServiceApplication.class, args);
	}

}
