package com.maras.springtestharness.hook;

import com.codeborne.selenide.Configuration;
import com.maras.springtestharness.config.HarnessAbstractTestDefinition;
import com.maras.springtestharness.step.GoogleSearchStepDefinitions;
import com.maras.springtestharness.utility.properties.ApplicationProperties;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ScopeNotActiveException;

import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;

import static com.codeborne.selenide.Selenide.screenshot;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

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
        Configuration.reportsFolder = "test-result/reports";

    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        attachScreenshot(scenario);
    }

    @After
    public void afterScenario(Scenario scenario) {
    //things to do after scenario ended
        attachScreenshot(scenario);
    }

    public void attachScreenshot(Scenario scenario){
        //by attaching screenshot to the scenario, screenshot is added to both Extent and Allure report
        final byte[] screenshot = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
        //you can also attach screenshots to Allure report manually using below line
        //if you uncomment this, you will see screenshot with text "Test Finished" in your allure report
//        Allure.addAttachment("Test finished", new ByteArrayInputStream(((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES)));

    }

}
