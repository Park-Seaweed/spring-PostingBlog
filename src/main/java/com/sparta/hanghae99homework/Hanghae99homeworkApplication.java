package com.sparta.hanghae99homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextRegionProviderAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication(exclude = ContextRegionProviderAutoConfiguration.class)
public class Hanghae99homeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(Hanghae99homeworkApplication.class, args);
    }

}
