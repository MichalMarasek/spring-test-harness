package com.maras.springtestharness.hook;

import com.codeborne.selenide.Configuration;
import com.maras.springtestharness.config.HarnessAbstractTestDefinition;
import com.maras.springtestharness.utility.hook.HookUtility;
import com.maras.springtestharness.utility.properties.ApplicationProperties;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.MalformedURLException;

@CucumberContextConfiguration
public class Hooks extends HarnessAbstractTestDefinition {
//    @Autowired
//    private LogManager logManager;
    @Autowired
    private HookUtility hookUtility;

//    @Autowired
//    private ApplicationProperties applicationProperties;

    @Before
    public void beforeScenario(Scenario scenario) throws MalformedURLException {
        String filename = scenario.getName().replaceAll("\\s+", "_");
        System.out.println(filename);
        System.setProperty("selenide.browser", "chrome");
        Configuration.holdBrowserOpen=false;
//        logManager.createNewLogger(filename);
    }

    @After
    public void afterScenario(Scenario scenario) {
//        hookUtility.endOfTest(scenario);
    }
}
