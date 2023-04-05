package com.modeal.springbatch.jobs;

import com.modeal.springbatch.tasks.MyTaskOne;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobBuilder;
import org.quartz.JobExecutionContext;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.config.Task;
import org.springframework.scheduling.quartz.QuartzJobBean;

@Slf4j
public class CustomQuartzJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context) {
        System.out.println("Spring Batch Service START #1");

//        try {
//            // Grab the Scheduler instance from the Factory
//            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//            // and start it off
//            scheduler.start();
//            scheduler.shutdown();
//
//        } catch (SchedulerException se) {
//            se.printStackTrace();
//            throw new RuntimeException(se);
//        }

    }
}
