package giovani.nfestatusproj.nfestatus.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationSetup {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(ApplicationSetup.class);
		
		for (String arg : args) {
			logger.info("Argument: " + arg);
		}
		
		SpringApplication.run(ApplicationSetup.class, args);
	}
}
