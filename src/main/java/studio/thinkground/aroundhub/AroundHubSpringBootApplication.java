package studio.thinkground.aroundhub;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class AroundHubSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(AroundHubSpringBootApplication.class, args);
    }

}