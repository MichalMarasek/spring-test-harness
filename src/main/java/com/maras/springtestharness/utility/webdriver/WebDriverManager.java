package com.maras.springtestharness.utility.webdriver;

import com.maras.springtestharness.utility.properties.ApplicationProperties;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class WebDriverManager {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private final Logger log = LoggerFactory.getLogger(WebDriverManager.class);

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private Environment environment;


}
