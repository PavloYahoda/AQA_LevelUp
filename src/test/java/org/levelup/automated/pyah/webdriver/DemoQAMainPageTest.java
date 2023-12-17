package org.levelup.automated.pyah.webdriver;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DemoQAMainPageTest extends BaseTest{

    DemoQAMainPage demoQAMainPage = new DemoQAMainPage();

    @Test
    @DisplayName("Click some elements")
    void findAndClick (){
        String fullNameValue = "Jack Black";
        String emailValue = "jackblak@jb.co";
        String currentAddressValue = "113, North street";
        String permanentAddressValue = "9, New Street";
        demoQAMainPage.clickByClick(fullNameValue, emailValue, currentAddressValue, permanentAddressValue);
    }
}
