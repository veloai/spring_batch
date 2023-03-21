package com.modeal.springbatch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfig {

    @Bean
    public Job batchSample(JobRepository jobRepository, Step step) {
        return new JobBuilder("sampleBatchJob", jobRepository)
                .start(step)
                .build();
    }

    @Bean
    public Step stepSample1(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("sampleBatchStep",jobRepository)
                .tasklet((StepContribution stepContribution, ChunkContext chunkContext) -> {
                    System.out.println("sample test!");
                    return RepeatStatus.FINISHED;
                },transactionManager).build();
    }

}
