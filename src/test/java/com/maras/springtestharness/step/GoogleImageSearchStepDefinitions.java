package com.maras.springtestharness.step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import com.maras.springtestharness.page.GoogleSearchPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Step Definition Class
 *
 */
public class GoogleImageSearchStepDefinitions {

    private GoogleSearchPage googleSearchPage = page(GoogleSearchPage.class);
    @When("click {string} link")
    public void chooseImagesAsSearchTarget(String linkText) {
        googleSearchPage.clickByLinkText(linkText);
        if (googleSearchPage.findByText("Accept all").isDisplayed()) {
            googleSearchPage.findByText("Accept all").shouldBe(visible).click();
            googleSearchPage.findByText("Accept all").should(disappear);
        }
    }

    @When("enter a keyword {string} in input field")
    public void enterKeyword(String keyword) {
        googleSearchPage.searchBox.val(keyword).pressEnter();
    }

    @Then("at least top {int} matching images should be shown")
    public void topTenMatchedImagesShouldBeShown(int resultsCount) {
        googleSearchPage.imageSearchResults.shouldHave(sizeGreaterThanOrEqual(resultsCount));
    }
}