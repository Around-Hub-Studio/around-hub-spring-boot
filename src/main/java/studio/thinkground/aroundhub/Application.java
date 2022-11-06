package studio.thinkground.aroundhub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import studio.thinkground.aroundhub.config.ProfileManager;
import studio.thinkground.aroundhub.config.env.EnvConfiguration;

@SpringBootApplication
public class Application {

    private final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Autowired
    public Application(EnvConfiguration envConfiguration, ProfileManager profileManager) {
        LOGGER.info(envConfiguration.getMessage());
        profileManager.printActiveProfiles();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}