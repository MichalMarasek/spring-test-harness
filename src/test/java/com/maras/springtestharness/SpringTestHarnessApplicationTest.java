package com.maras.springtestharness;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;


@CucumberOptions(
		features = {
				"src/test/resources/feature/RestApiTest.feature"
		},
		plugin = {
				"pretty",
				"json:target/cucumber/report.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
		})
public class SpringTestHarnessApplicationTest extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
