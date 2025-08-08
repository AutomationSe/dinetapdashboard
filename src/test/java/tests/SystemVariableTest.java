package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.systemVariablepage;
import utils.ExcelReader;
import pages.restaurantPage;
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
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        softAssert = new SoftAssert();
        page = new restaurantPage(getDriver());
        validateRestaurantHeaders(softAssert);
        softAssert.assertAll();
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
     /*   page.openProductTypeDropdown();
        softAssert.assertEquals(page.getOptionPOS().getText().trim(), "POS", "POS option missing");
        softAssert.assertEquals(page.getOptionDinetapApp().getText().trim(), "Dinetap App", "Dinetap App option missing");
        softAssert.assertEquals(page.getOptionPayments().getText().trim(), "Payments", "Payments option missing");
        softAssert.assertEquals(page.getOptionLegacy().getText().trim(), "Legacy", "Legacy option missing");*/
        softAssert.assertAll();
    }
    @DataProvider(name = "systemVariableData")
    public Iterator<Object[]> provideSystemVariableData() {
        String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\SystemVariablesData.xlsx";
        String sheetName = "Sheet1";
        List<Map<String, String>> dataList = ExcelReader.getData(filePath, sheetName);
        return dataList.stream().map(row -> new Object[]{row}).iterator();
    }
    @Test(priority = 3, dataProvider = "systemVariableData")
    public void testCreateSystemVariableFromExcel(Map<String, String> data) {
        systemVariablepage page = new systemVariablepage(getDriver());
        SoftAssert softAssert = new SoftAssert();
        page.clickNewSystemVariableButton();
        softAssert.assertEquals(page.getFormHeading(), "New System Variable", "❌ Form heading mismatch");
        softAssert.assertEquals(page.getKeyLabel(), "Key", "❌ Key label mismatch");
        softAssert.assertEquals(page.getDescriptionLabel(), "Description", "❌ Description label mismatch");
        softAssert.assertEquals(page.getTypeLabel(), "Type", "❌ Type label mismatch");
        softAssert.assertEquals(page.getValueLabel(), "Value", "❌ Value label mismatch");
        page.enterKey(data.get("Key"));
        page.enterDescription(data.get("Description"));
        page.selectType(data.get("Type"));
        page.enterValue(data.get("Value"));
        page.clickCreateButton();
        Assert.assertEquals(page.getHeaderSystemVariables().getText().trim(), "System Variables", "Mismatch in page heading");
        softAssert.assertAll();
    }
}
