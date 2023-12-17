package org.levelup.automated.pyah.webdriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DemoQAMainPage extends BasePage{
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div")
//    @FindBy(how = How.CSS, using = "div[class='card mt-4 top-card']")
    private WebElement tileElements;

    @FindBy(how = How.ID, using = "item-0")
    private WebElement textBox;

    @FindBy(how = How.ID, using = "userName")
    private WebElement fullName;

    @FindBy(how = How.ID, using = "userEmail")
    private WebElement email;

    @FindBy(how = How.ID, using = "currentAddress")
    private WebElement currentAddress;

    @FindBy(how = How.ID, using = "permanentAddress")
    private WebElement permanentAddress;

    @FindBy(how = How.ID, using = "submit")
    private WebElement submitButton;

    public DemoQAMainPage() {
        driver.get("https://demoqa.com/");
        PageFactory.initElements(driver, this);
    }
    public DemoQAMainPage clickByClick (String fullNameValue, String emailValue, String currentAddressValue, String permanentAddressValue){
        tileElements.click();
        textBox.click();
        fullName.sendKeys(fullNameValue);
        email.sendKeys(emailValue);
        currentAddress.sendKeys(currentAddressValue);
        permanentAddress.sendKeys(permanentAddressValue);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        submitButton.click();

        return this;
    }
}
