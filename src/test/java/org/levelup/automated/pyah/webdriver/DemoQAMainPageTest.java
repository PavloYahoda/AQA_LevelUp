package org.levelup.automated.pyah.webdriver;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class DemoQAMainPageTest extends BaseTest{

    private final String fullNameValue = "Jack Black";
    private final String emailValue = "jackblak@jb.co";
    private final String currentAddressValue = "113, North street";
    private final String permanentAddressValue = "9, New Street";




    //Find and fill TextBox form
    @Test
    @Order(1)
    @DisplayName("Click and fill some elements")
    void findAndClick (){

        DemoQAMainPage mainPage = new DemoQAMainPage();
        mainPage.clickAndFill(fullNameValue, emailValue, currentAddressValue, permanentAddressValue);
    }

    //Check previously entered data
    @Test
    @Order(2)
    @DisplayName("Checking values in all fields")
    void checkValues (){
        DemoQAMainPage mainPage = new DemoQAMainPage();
        String nameIsSet = mainPage.getValues().get(0);
        String emailIsSet = mainPage.getValues().get(1);
        String curAddressIsSet = mainPage.getValues().get(2);
        String permAddressIsSet = mainPage.getValues().get(3);

        assertEquals(fullNameValue, nameIsSet, "Full Name field is filled with mistakes");
        assertEquals(emailValue, emailIsSet, "Email field is filled with mistakes");
        assertEquals(currentAddressValue, curAddressIsSet, "Current Address field is filled with mistakes");
        assertEquals(permanentAddressValue, permAddressIsSet, "Permanent Address field is filled with mistakes");
    }
}