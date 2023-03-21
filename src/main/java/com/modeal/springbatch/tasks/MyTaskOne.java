package com.modeal.springbatch.tasks;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;

public class MyTaskOne {

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println("MyTaskOne start..");

        // ... your code

        System.out.println("MyTaskOne done..");
        return RepeatStatus.FINISHED;
    }

}
