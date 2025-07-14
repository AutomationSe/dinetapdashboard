package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.systemVariablepage;
import utils.ExcelReader;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SystemVariableTest extends BaseTest {

    WebDriverWait wait;
    SoftAssert softAssert;
    List<Map<String, String>> testData;

    @BeforeClass
    public void doLoginAndNavigate() {
        loginAs("senel@gmail.com", "Senel2314@");

        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        softAssert = new SoftAssert();

        // Verify "my new cafe" is visible using soft assertion
        String cafeNameText = wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("(//div[normalize-space()='my new cafe'])[1]")))
                .getText().trim();

        System.out.println("✅ Cafe name captured: " + cafeNameText);
        softAssert.assertEquals(cafeNameText, "my new cafe", "Cafe name text mismatch");

        softAssert.assertAll(); // Evaluate soft assertions

        // Load Excel data
        String path = "src/test/resources/SystemVariablesData.xlsx";
        testData = ExcelReader.getData(path, "Sheet1");
    }

    @Test(priority = 1)
    public void testNavigateToSystemVariablePage() {
        systemVariablepage systemVariablePage = new systemVariablepage(getDriver());
        systemVariablePage.clickSystemVariablelink();
    }

    @Test(priority = 2)
    public void verifySystemVariablePageElements() {
        systemVariablepage page = new systemVariablepage(getDriver());
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(page.getHeaderSystemVariables().getText().trim(), "System Variables", "Mismatch in page heading");
        softAssert.assertEquals(page.getLabelProductTypes().getText().trim(), "Product Types", "Mismatch in label");

        page.openProductTypeDropdown();

        softAssert.assertEquals(page.getOptionPOS().getText().trim(), "POS", "POS option missing");
        softAssert.assertEquals(page.getOptionDinetapApp().getText().trim(), "Dinetap App", "Dinetap App option missing");
        softAssert.assertEquals(page.getOptionPayments().getText().trim(), "Payments", "Payments option missing");
        softAssert.assertEquals(page.getOptionLegacy().getText().trim(), "Legacy", "Legacy option missing");

        softAssert.assertAll();
    }

    @DataProvider(name = "systemVariableData")
    public Iterator<Object[]> provideSystemVariableData() {
        return testData.stream()
                .map(data -> new Object[]{
                        data.get("Key"),
                        data.get("Description"),
                        data.get("Type"),
                        data.get("Value")
                })
                .iterator();
    }

    @Test(priority = 3, dataProvider = "systemVariableData")
    public void testCreateSystemVariableFromExcel(String key, String description, String type, String value) {
        systemVariablepage page = new systemVariablepage(getDriver());
        SoftAssert softAssert = new SoftAssert();

        page.clickNewSystemVariableButton();

        softAssert.assertEquals(page.getFormHeading(), "New System Variable", "Form heading mismatch");
        softAssert.assertEquals(page.getKeyLabel(), "Key", "Key label mismatch");
        softAssert.assertEquals(page.getDescriptionLabel(), "Description", "Description label mismatch");
        softAssert.assertEquals(page.getTypeLabel(), "Type", "Type label mismatch");
        softAssert.assertEquals(page.getValueLabel(), "Value", "Value label mismatch");

        page.enterKey(key);
        page.enterDescription(description);
        page.selectType(type); // accepts POS, Dinetap App, Payments, Legacy
        page.enterValue(value);

        page.clickCreateButton();

        softAssert.assertAll();
    }
}
