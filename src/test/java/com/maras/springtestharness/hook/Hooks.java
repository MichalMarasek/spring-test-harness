package com.maras.springtestharness.hook;

import com.codeborne.selenide.WebDriverRunner;
import com.maras.springtestharness.utility.hook.HookUtility;
import com.maras.springtestharness.utility.log.LogManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.MalformedURLException;

@CucumberContextConfiguration
public class Hooks {
//    @Autowired
//    private LogManager logManager;
//    @Autowired
//    private HookUtility hookUtility;

    @Before
    public void beforeScenario(Scenario scenario) throws MalformedURLException {
        String filename = scenario.getName().replaceAll("\\s+", "_");
        System.out.println(filename);
//        logManager.createNewLogger(filename);
    }

    @After
    public void afterScenario(Scenario scenario) {
//        hookUtility.endOfTest(scenario);
    }
}
