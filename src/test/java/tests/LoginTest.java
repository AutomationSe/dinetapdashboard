package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.logoutpage;
import utils.ExcelReader;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Iterator<Object[]> loginDataProvider() {
        String excelPath = "src/test/resources/sendkeys.xlsx";
        String sheetName = "Sheet1";

        List<Map<String, String>> testData = ExcelReader.getData(excelPath, sheetName);
        return testData.stream()
                .map(data -> new Object[]{data.get("email"), data.get("password")})
                .iterator();
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String email, String password) {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        SoftAssert softAssert = new SoftAssert();

        // Perform login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);

        boolean isLoggedIn = false;

        try {
            // 1. Restaurants Heading
            String restaurantsHeading = wait.until(ExpectedConditions
                            .visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Restaurants']")))
                    .getText().trim();
            System.out.println("Page Heading: " + restaurantsHeading);
            softAssert.assertEquals(restaurantsHeading, "Restaurants", "Mismatch in Restaurants heading");

            // 2. Payment Provider Label
            String paymentProviderLabel = wait.until(ExpectedConditions
                            .visibilityOfElementLocated(By.xpath("(//label[normalize-space()='Payment Provider'])[1]")))
                    .getText().trim();
            System.out.println("Label: " + paymentProviderLabel);
            softAssert.assertEquals(paymentProviderLabel, "Payment Provider", "Mismatch in Payment Provider label");

            // 3. Status Label
            String statusLabel = wait.until(ExpectedConditions
                            .visibilityOfElementLocated(By.xpath("(//label[normalize-space()='Status'])[1]")))
                    .getText().trim();
            System.out.println("Label: " + statusLabel);
            softAssert.assertEquals(statusLabel, "Status", "Mismatch in Status label");

            // 4. Cafe Name
            String cafeName = wait.until(ExpectedConditions
                            .visibilityOfElementLocated(By.xpath("(//div[normalize-space()='my new cafe'])[1]")))
                    .getText().trim();
            System.out.println("Cafe Name: " + cafeName);
            softAssert.assertEquals(cafeName, "my new cafe", "Mismatch in Cafe Name");

            isLoggedIn = true;
        } catch (Exception e) {
            softAssert.fail("Login verification failed for: " + email);
        }

        if (isLoggedIn) {
            logoutpage logout = new logoutpage(driver);
            logout.clickProfile();
            logout.clickLogoutInMenu();
            logout.confirmLogout();

        }

        softAssert.assertAll();
    }
}
