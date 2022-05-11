package studio.thinkground.aroundhub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import studio.thinkground.aroundhub.config.ProfileManager;
import studio.thinkground.aroundhub.config.env.EnvConfiguration;

@SpringBootApplication
public class AroundHubSpringBootApplication {

    private final Logger LOGGER = LoggerFactory.getLogger(AroundHubSpringBootApplication.class);

    @Autowired
    public AroundHubSpringBootApplication(EnvConfiguration envConfiguration, ProfileManager profileManager) {
        LOGGER.info(envConfiguration.getMessage());
        profileManager.printActiveProfiles();
    }

    public static void main(String[] args) {
        SpringApplication.run(AroundHubSpringBootApplication.class, args);
    }

}