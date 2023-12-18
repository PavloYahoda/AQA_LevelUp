package org.levelup.automated.pyah.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DemoQAMainPage extends BasePage{

    //For Text Box
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

    //For Check Box
    @FindBy(how = How.ID, using = "item-1")
    private WebElement checkBox;
    @FindBy(how = How.CLASS_NAME, using = "rct-option-expand-all")
    private WebElement expandAll;
    @FindBy(how = How.XPATH, using = "//span[text()='Documents']")
    private WebElement chDocuments;
    @FindBy(how = How.XPATH, using = "//span[text()='General']")
    private WebElement chGeneral;
    @FindBy(how = How.XPATH, using = "//span[text()='Excel File.doc']")
    private WebElement chExcelFile;



    public DemoQAMainPage() {
        driver.get("https://demoqa.com/");
        PageFactory.initElements(driver, this);
    }

    private String filledName;
    private String filledEmail;
    private String filledCurAddress;
    private String filledPerAddress;
    private boolean markedItems = false;

    public DemoQAMainPage clickAndFill (String fullNameValue, String emailValue, String currentAddressValue, String permanentAddressValue){

        //For Text Box form
        tileElements.click();
        textBox.click();
        fullName.sendKeys(fullNameValue);
        email.sendKeys(emailValue);
        currentAddress.sendKeys(currentAddressValue);
        permanentAddress.sendKeys(permanentAddressValue);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        submitButton.click();

        //assertEquals
        By outputNameBy = By.xpath("//div[@id='output']//p[@id='name']");
        By outputEmailBy = By.xpath("//div[@id='output']//p[@id='email']");
        By outputCurAddressBy = By.xpath("//div[@id='output']//p[@id='currentAddress']");
        By outputPerAddressBy = By.xpath("//div[@id='output']//p[@id='permanentAddress']");

        filledName = driver.findElement(outputNameBy).getText();
        filledEmail = driver.findElement(outputEmailBy).getText();
        filledCurAddress = driver.findElement(outputCurAddressBy).getText();
        filledPerAddress = driver.findElement(outputPerAddressBy).getText();

        return this;
    }
    public void workWithCheckboxes(){
        tileElements.click();
        checkBox.click();
        expandAll.click();
        chDocuments.click();

        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        chExcelFile.click();
        chGeneral.click();

        List<WebElement> selectedItems = driver.findElements(By.xpath("//div[@id='result']//span[@class='text-success']"));

        if(selectedItems.size() == 8){
            markedItems = true;
        }
    }
    public String getFilledName() {
        return filledName;
    }

    public String getFilledEmail() {
        return filledEmail;
    }

    public String getFilledCurAddress() {
        return filledCurAddress;
    }

    public String getFilledPerAddress() {
        return filledPerAddress;
    }

    public boolean isMarkedItems() {
        return markedItems;
    }
}

