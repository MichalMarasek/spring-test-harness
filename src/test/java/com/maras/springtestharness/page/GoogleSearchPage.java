package com.maras.springtestharness.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import java.util.Collection;
import java.util.List;

/**
 * Page Object Model Class
 *
 */
public class GoogleSearchPage {

    private static Logger logger = LoggerFactory.getLogger(GoogleSearchPage.class);

    @FindBy(how = How.NAME, using = "q")
    public SelenideElement searchBox;

    @FindBy(how = How.CSS, using = "#res .g")
    public SelenideElement firstSearchResults;

    @FindBy(how = How.CSS, using = "#res .g")
    public ElementsCollection searchResults;

    @FindBy(how = How.CSS, using = ".rg_i")
    public ElementsCollection imageSearchResults;

    public void openPage(String url) {
        logger.info("Search for: " + url + " in google");
        open(url);
    }

    public void clickByLinkText(String linkText) {
        $(byText(linkText)).click();
    }

    public SelenideElement findByText(String text) {
        return $(byText("Accept all"));
    }

}
