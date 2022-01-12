package studio.thinkground.aroundhub.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfiguration {

    private final Logger LOGGER = LoggerFactory.getLogger(HelloConfiguration.class);

    // Job을 쉽게 만들 수 있게 지원하는 클래스
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    public HelloConfiguration(JobBuilderFactory jobBuilderFactory,
        StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    /*
    Job은 Batch의 실행 단위
    어떤 배치를 실행할지 설정하기 위해서는 Program Arguments 부분에 '--spring.batch.job.names=helloJob' 추가
     */
    @Bean
    public Job helloJob() {
        return jobBuilderFactory.get("helloJob")
            .incrementer(
                new RunIdIncrementer()) // incrementer : 작업의 실행 단위를 구분할 수 있는 개념, RunIdIncrementor : 파라미터 ID를 자동으로 생성해줌
            .start(this.helloStep()) // job 실행시 최초로 실행될 메소드를 설정
            .build();
    }

    @Bean
    public Step helloStep() {
        return stepBuilderFactory.get("helloStep")
            .tasklet((contribution, chunkContext) -> {
                LOGGER.info("hello spring batch");
                return RepeatStatus.FINISHED;
            }).build();
    }
}
