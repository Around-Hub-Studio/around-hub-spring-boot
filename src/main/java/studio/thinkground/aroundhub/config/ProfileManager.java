package studio.thinkground.aroundhub.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * PackageName : studio.thinkground.aroundhub.config
 * FileName : ProfileManager
 * Author : Flature
 * Date : 2022-05-11
 * Description :
 */
@Component
public class ProfileManager {

    private final Logger LOGGER = LoggerFactory.getLogger(ProfileManager.class);
    private final Environment environment;

    @Autowired
    public ProfileManager(Environment environment) {
        this.environment = environment;
    }

    public void printActiveProfiles() {
        LOGGER.info("[printActiveProfiles] active Profiles size : {}", environment.getActiveProfiles().length);
        for (String profile : environment.getActiveProfiles()) {
            LOGGER.info("[printActiveProfiles] profile : {}", profile);
        }
    }

}
