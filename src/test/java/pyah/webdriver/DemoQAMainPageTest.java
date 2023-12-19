package pyah.webdriver;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class DemoQAMainPageTest extends BaseTest {

    private final String fullNameValue = "Jack Black";
    private final String emailValue = "jackblack@jb.co";
    private final String currentAddressValue = "113, North street";
    private final String permanentAddressValue = "9, New Street";


    //Find and fill TextBox form
    @Test
    @Order(1)
    @DisplayName("Click and fill some elements")
    void findAndClick() {

        DemoQAMainPage mainPage = new DemoQAMainPage();
        mainPage.clickAndFill(fullNameValue, emailValue, currentAddressValue, permanentAddressValue);

        String nameIsSet = mainPage.getFilledName();
        String emailIsSet = mainPage.getFilledEmail();
        String curAddressIsSet = mainPage.getFilledCurAddress();
        String permAddressIsSet = mainPage.getFilledPerAddress();

        assertEquals(fullNameValue, nameIsSet, "Full Name field is filled with mistakes");
        assertEquals(emailValue, emailIsSet, "Email field is filled with mistakes");
        assertEquals(currentAddressValue, curAddressIsSet, "Current Address field is filled with mistakes");
        assertEquals(permanentAddressValue, permAddressIsSet, "Permanent Address field is filled with mistakes");

    }

    //Mark checkboxes
    @Test
    @Order(2)
    @DisplayName("Go to checkboxes")
    void markCheckboxes() {
        DemoQAMainPage mainPage = new DemoQAMainPage();
        mainPage.workWithCheckboxes();
        boolean count = mainPage.isMarkedItems();
        assertTrue(count, "Number of marked checkboxes is correct");
    }
}
