package com.modeal.springbatch.tasks;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;

public class MyTaskTwo {

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println("MyTaskTwo start..");

        // ... your code

        System.out.println("MyTaskTwo done..");
        return RepeatStatus.FINISHED;
    }

}
