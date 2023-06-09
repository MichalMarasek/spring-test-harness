package com.maras.springtestharness.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@Configuration
@ComponentScan({
        "com.maras.springtestharness"
})
@PropertySource("classpath:/application.properties")
public class HarnessContextConfiguration {
}
