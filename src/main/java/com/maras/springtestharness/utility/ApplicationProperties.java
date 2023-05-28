package com.maras.springtestharness.utility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {
    //you can get values from application.properties files using this class
    //for example, to get value of browser property:

    @Value("${browser}")
    private String browser;

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }


}
