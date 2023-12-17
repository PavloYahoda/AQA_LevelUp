package org.levelup.automated.pyah.webdriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DemoQAMainPage extends BasePage{
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div/div[1]")
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
    @FindBy(how = How.ID, using = "name")
    private WebElement filledName;
    @FindBy(how = How.ID, using = "email")
    private WebElement filledEmail;
    @FindBy(how = How.XPATH, using = "//*[@id=\"currentAddress\"]")
    private WebElement filledCurrentAddress;
    @FindBy(how = How.XPATH, using = "//*[@id=\"permanentAddress\"]")
    private WebElement filledPermanentAddress;


    public DemoQAMainPage() {
        driver.get("https://demoqa.com/");
        PageFactory.initElements(driver, this);
    }

    private List<String> values;

    public DemoQAMainPage clickAndFill (String fullNameValue, String emailValue, String currentAddressValue, String permanentAddressValue){
        tileElements.click();
        textBox.click();
        fullName.sendKeys(fullNameValue);
        email.sendKeys(emailValue);
        currentAddress.sendKeys(currentAddressValue);
        permanentAddress.sendKeys(permanentAddressValue);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        submitButton.click();

        values = new ArrayList<>();
        values.add(filledName.getText());
        values.add(filledEmail.getText());
        values.add(filledCurrentAddress.getAttribute("Current Address :"));
        values.add(filledPermanentAddress.getAttribute("Permananet Address :"));

        return this;
    }
    public List<String> getValues() {
        return values;
    }
}

