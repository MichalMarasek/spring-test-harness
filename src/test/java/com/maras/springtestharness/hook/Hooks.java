package com.maras.springtestharness.hook;

import com.codeborne.selenide.Configuration;
import com.maras.springtestharness.config.HarnessAbstractTestDefinition;
import com.maras.springtestharness.step.GoogleSearchStepDefinitions;
import com.maras.springtestharness.utility.properties.ApplicationProperties;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.MalformedURLException;

@CucumberContextConfiguration
public class Hooks extends HarnessAbstractTestDefinition {

    private static Logger logger = LoggerFactory.getLogger(Hooks.class);

    @Autowired
    private ApplicationProperties applicationProperties;

    @Before
    public void beforeScenario(Scenario scenario) throws MalformedURLException {
        //things to do before test scenario started
        String filename = scenario.getName().replaceAll("\\s+", "_");
        System.out.println(filename);
        System.setProperty("selenide.browser", "chrome");
        Configuration.holdBrowserOpen=false;

    }

    @After
    public void afterScenario(Scenario scenario) {
    //things to do after scenario ended
    }
}
