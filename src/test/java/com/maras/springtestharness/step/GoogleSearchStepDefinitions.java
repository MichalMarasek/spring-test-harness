package com.maras.springtestharness.step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

import com.maras.springtestharness.page.GoogleSearchPage;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Step Definition Class
 *
 */
public class GoogleSearchStepDefinitions {

    private static Logger logger = LoggerFactory.getLogger(GoogleSearchStepDefinitions.class);

    private GoogleSearchPage googleSearchPage = page(GoogleSearchPage.class);
    @Given("an open browser with google.com")
    public void openGoogleSearch() {
        googleSearchPage.openPage("https://google.com/ncr");
        if ($(byText("Accept all")).isDisplayed()) {
            $(byText("Accept all")).shouldBe(visible).click();
            $(byText("Accept all")).should(disappear);
        }
    }

    @When("a keyword {string} is entered in input field")
    public void enterKeyword(String keyword) {
        googleSearchPage.searchBox.val(keyword).pressEnter();

    }

    @Then("at least top {int} matches should be shown")
    public void topTenMatchesShouldBeShown(int resultsCount) {
        googleSearchPage.searchResults.shouldHave(sizeGreaterThanOrEqual(resultsCount));
    }

    @Then("the first one should contain {string}")
    public void theFirstOneShouldContainKeyword(String expectedText) {
        googleSearchPage.firstSearchResults.shouldHave(text(expectedText));
    }
}