package com.foodplatform.fpstorebatch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.TimeZone;

@Slf4j
@EnableScheduling
@EnableBatchProcessing
@SpringBootApplication
public class FpStorebatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(FpStorebatchApplication.class, args);
    }

    @PostConstruct
    public void started(){
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
        log.info("현재 시각 : "+new Date());
    }
}
