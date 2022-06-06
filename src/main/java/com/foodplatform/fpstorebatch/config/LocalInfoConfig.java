package com.foodplatform.fpstorebatch.config;

import com.foodplatform.fpstorebatch.tasklet.LocalInfoTasklet;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class LocalInfoConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    // JobBuilderFactory를 통해서 tutorialJob을 생성
    @Bean
    public Job LocalInfoJob() {
        return jobBuilderFactory.get("localinfoJob")
                .start(LocalInfoStep())
                .build();
    }

    // StepBuilderFactory를 통해서 tutorialStep을 생성
    @Bean
    public Step LocalInfoStep() {
        return stepBuilderFactory.get("localinfoStep")
                .tasklet(new LocalInfoTasklet())
                .build();
    }

}
