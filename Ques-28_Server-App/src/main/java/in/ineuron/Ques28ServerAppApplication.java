package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Ques28ServerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ques28ServerAppApplication.class, args);
	}

}
