package studio.thinkground.aroundhub.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SharedConfiguration {

    private final Logger LOGGER = LoggerFactory.getLogger(SharedConfiguration.class);

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    public SharedConfiguration(JobBuilderFactory jobBuilderFactory,
        StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Job shareJob() {
        return jobBuilderFactory.get("shareJob")
            .incrementer(new RunIdIncrementer())
            .start(this.shareStep())
            .next(this.shareStep2())
            .build();
    }

    @Bean
    public Step shareStep(){
        return stepBuilderFactory.get("shareStep")
            .tasklet((stepContribution, chunkContext) -> {
                StepExecution stepExecution = stepContribution.getStepExecution();
                ExecutionContext executionContext = stepExecution.getExecutionContext();
                executionContext.putString("stepKey", "step execution context");

                JobExecution jobExecution = stepExecution.getJobExecution();
                JobInstance jobInstance = jobExecution.getJobInstance();
                ExecutionContext jobExecutionContext = jobExecution.getExecutionContext();
                jobExecutionContext.putString("jobKey", "job execution context");
                JobParameters jobParameters = jobExecution.getJobParameters();

                LOGGER.info("[shareStep] jobName : {}, stepName : {}, parameter : {}",
                    jobInstance.getJobName(),
                    stepExecution.getStepName(),
                    jobParameters.getLong("run.id"));

                return RepeatStatus.FINISHED;
            })
            .build();
    }

    @Bean
    public Step shareStep2() {
        return stepBuilderFactory.get("shareStep2")
            .tasklet((contribution, chunkContext) -> {
                StepExecution stepExecution = contribution.getStepExecution();
                ExecutionContext stepExecutionContext = stepExecution.getExecutionContext();

                JobExecution jobExecution = stepExecution.getJobExecution();
                ExecutionContext jobExecutionContext = jobExecution.getExecutionContext();

                LOGGER.info("[shareStep2] jobKey : {}, stepKey : {}",
                    jobExecutionContext.getString("jobKey", "emptyJobKey"),
                    stepExecutionContext.getString("stepKey", "emptyStepKey"));

                return RepeatStatus.FINISHED;
            })
            .build();
    }
}
