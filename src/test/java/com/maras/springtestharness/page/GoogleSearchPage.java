package com.maras.springtestharness.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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


}
