package studio.thinkground.aroundhub.batch;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChunkProcessingConfiguration {

    private final Logger LOGGER = LoggerFactory.getLogger(HelloConfiguration.class);

    // Job을 쉽게 만들 수 있게 지원하는 클래스
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    public ChunkProcessingConfiguration(
        JobBuilderFactory jobBuilderFactory,
        StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Job chunkProcessingJob() {
        return jobBuilderFactory.get("chunkProcessingJob")
            .incrementer(new RunIdIncrementer())
            .start(this.taskBaseStep())
            .next(this.chunkBaseStep())
            .build();
    }

    @Bean
    public Step chunkBaseStep(){
        return stepBuilderFactory.get("chunkBaseStep")
            .<String, String>chunk(10)
            .reader(itemReader())
            .processor(itemProcessor())
            .writer(itemWriter())
            .build();
    }

    /*
    writer에서는 chunksize를 기준으로 List 형식의 인풋을 받게 되며
    그 사이즈에 맞춰 반복하여 처리하게 됨
     */
    private ItemWriter<String> itemWriter() {
        return items -> LOGGER.info("chunk item size : {}", items.size());
        //return items -> items.forEach(LOGGER::info);
    }

    /*
    getItems() 메소드에서 만들어진 문자열에서 뒤에 더 데이터를 붙이는 역할을 수행
    Processor는 reader에서 생성한 데이터를 가공하거나 writer로 넘길지 말지 결정하는 역할을 수행
    return null을 하게 되면 writer로 넘어가지 않음
     */
    private ItemProcessor<String, String> itemProcessor() {
        return item -> item + ", Spring Batch";
    }

    private ItemReader<String> itemReader() {
        return new ListItemReader<>(getItems());
    }

    @Bean
    public Step taskBaseStep() {
        return stepBuilderFactory.get("taskBaseStep")
            .tasklet(this.tasklet())
            .build();
    }

    private Tasklet tasklet() {
        return (contribution, chunkContext) -> {
            List<String> items = getItems();
            LOGGER.info("task item size : {}", items.size());

            return RepeatStatus.FINISHED;
        };
    }

    private List<String> getItems() {
        List<String> items = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            items.add(i + " data");
        }
        return items;
    }
}
