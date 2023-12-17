package org.levelup.automated.pyah.webdriver;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected WebDriver driver;

    @BeforeAll
    public void setUp(){
        System.setProperty("webdriver.edge.driver","src/test/resources/msedgedriver");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
//                Wait<WebDriver> wait = new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(2))
//                .pollingEvery(Duration.ofSeconds(2))
//                .ignoring(NoSuchElementException.class);

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        BasePage.setDriver(driver);
    }

//    @BeforeEach
//    @DisplayName("Open browser")
//    public void openBrowser(){
//        driver.get("https://demoqa.com/");
//
//    }

    @AfterEach
    public void closeBrowser(){
        driver.close();
        driver.quit();
    }
}