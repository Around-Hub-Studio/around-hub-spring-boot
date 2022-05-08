package studio.thinkground.aroundhub.config.env;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * PackageName : studio.thinkground.aroundhub.config.env
 * FileName : DevConfiguration
 * Author : Flature
 * Date : 2022-05-08
 * Description :
 */
@Profile("dev")
@Configuration
public class DevConfiguration implements EnvConfiguration {

    @Value("${around.hub.loading.message}")
    private String message;

    @Override
    @Bean
    public String getMessage(){
        return message;
    }

}
