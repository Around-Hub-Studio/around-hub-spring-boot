package studio.thinkground.aroundhub;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing // 배치 프로세스를 동작하게끔 설정
@SpringBootApplication
public class AroundHubSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(AroundHubSpringBootApplication.class, args);
    }

}