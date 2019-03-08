package com.jiashen.weather.config;

import com.jiashen.weather.manage.quartz.WeatherDataSyncJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.quartz.Trigger;
import org.springframework.context.annotation.Configuration;

/**
 * Quartz定时任务配置类
 * @author jiaoshen
 * @date 2019/2/8-${time}
 */
@Configuration
public class QuartzConfiguration {
    private static final int QUARTZ_TIME = 3600; // 更新频率

    // JobDetail
    @Bean
    public JobDetail weatherDataSyncJobDetail() {        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJob")
            .storeDurably().build();

    }

    // Trigger
    @Bean
    public Trigger weatherDataSyncTrigger() {

        SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(QUARTZ_TIME).repeatForever();

        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail())
                .withIdentity("weatherDataSyncTrigger").withSchedule(schedBuilder).build();
    }

}
