package uphf.produitsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProduitsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProduitsServiceApplication.class, args);
	}

}
