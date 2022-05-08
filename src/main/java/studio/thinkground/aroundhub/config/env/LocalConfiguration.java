package studio.thinkground.aroundhub.config.env;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * PackageName : studio.thinkground.aroundhub.config.env
 * FileName : LocalConfiguration
 * Author : Flature
 * Date : 2022-05-08
 * Description :
 */
@Profile("local")
@Configuration
public class LocalConfiguration implements EnvConfiguration {

    @Value("${around.hub.loading.message}")
    private String message;

    @Override
    @Bean
    public String getMessage() {
        return message;
    }

}
