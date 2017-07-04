package com.github.tr1cks.weather.core.util;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerBean;

import java.text.ParseException;

//TODO: refactor me. Must be a better way
public class QuartzUtil {
    private static final Logger logger = LoggerFactory.getLogger(QuartzUtil.class);

    public static JobDetail createJobDetail(Object targetObj, String methodName, String jobName) {
        return createJobDetail(targetObj, methodName, jobName, Scheduler.DEFAULT_GROUP);
    }

    public static JobDetail createJobDetail(Object targetObj, String methodName, String jobName, String jobGroup) {
        MethodInvokingJobDetailFactoryBean jobDetailFactory = new MethodInvokingJobDetailFactoryBean();
        jobDetailFactory.setTargetObject(targetObj);
        jobDetailFactory.setTargetMethod(methodName);
        jobDetailFactory.setName(jobName);
        jobDetailFactory.setGroup(jobGroup);

        try {
            jobDetailFactory.afterPropertiesSet();
        } catch(Exception exc) {
            throw new RuntimeException(exc);
        }

        return jobDetailFactory.getObject();
    }

    public static Trigger createSimpleTrigger(long delayInMilliseconds, String triggerName) {
        return createSimpleTrigger(delayInMilliseconds, triggerName, Scheduler.DEFAULT_GROUP);
    }

    public static Trigger createSimpleTrigger(long delayInMilliseconds, String triggerName, String triggerGroup) {
        SimpleTriggerBean trigger = new SimpleTriggerBean();
        trigger.setName(triggerName);
        trigger.setGroup(triggerGroup);
        trigger.setRepeatInterval(delayInMilliseconds);
        try {
            trigger.afterPropertiesSet();
        } catch (ParseException exc) {
            throw new RuntimeException(exc);
        }

        return trigger;
    }

    public static void scheduleJob(Scheduler scheduler, JobDetail jobDetail, Trigger trigger) {
        try {
            scheduler.scheduleJob(jobDetail, trigger);
            logger.info("Created job \"{}\"", jobDetail.getName());
        } catch (SchedulerException exc) {
            throw new RuntimeException(exc);
        }
    }

    public static void pauseJob(Scheduler scheduler, String jobName, String jobGroup) {
        try {
            scheduler.pauseJob(jobName, jobGroup);
        } catch(SchedulerException exc) {
            throw new RuntimeException(exc);
        }
    }

    public static void resumeJob(Scheduler scheduler, String jobName, String jobGroup) {
        try {
            scheduler.resumeJob(jobName, jobGroup);
        } catch(SchedulerException exc) {
            throw new RuntimeException(exc);
        }
    }

    public static void rescheduleJob(Scheduler scheduler, String triggerName, String triggerGroup, long delayInMilliseconds) {
        try {
            Trigger oldTrigger = scheduler.getTrigger(triggerName, triggerGroup);
            Trigger newTrigger = createSimpleTrigger(delayInMilliseconds, triggerName, triggerGroup);
            newTrigger.setJobName(oldTrigger.getJobName());
            newTrigger.setJobGroup(oldTrigger.getJobGroup());

            scheduler.rescheduleJob(triggerName, triggerGroup, newTrigger);
        } catch(SchedulerException exc) {
            throw new RuntimeException(exc);
        }
    }

    public static void pauseJobGroup(Scheduler scheduler, String jobGroup) {
        try {
            scheduler.pauseJobGroup(jobGroup);
        } catch(SchedulerException e) {
            throw new RuntimeException(e);
        }
    }
}