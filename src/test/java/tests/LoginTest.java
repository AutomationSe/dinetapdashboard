package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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


    @Test(description = "Login with valid credentials and verify labels")
    public void testLogin() {
        LoginPage loginPage = new LoginPage(getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        SoftAssert softAssert = new SoftAssert();

        // ✅ Verify login page labels using getter methods
        softAssert.assertEquals(loginPage.getLoginTitle(), "Login", "Login title mismatch");
        softAssert.assertEquals(loginPage.getEmailTitle(), "Email zero", "Email label mismatch");
        softAssert.assertEquals(loginPage.getPasswordTitle(), "Password", "Password label mismatch");


       // ✅ Perform login
        loginPage.login("seneluser@gmail.com", "Senel2314@");

        softAssert.assertEquals(loginPage.getErrorKey(), "Error", "Error key label mismatch");
        softAssert.assertEquals(loginPage.getServerError(), "An error occurred. Please try to login.", "Server error message mismatch");
        softAssert.assertEquals(loginPage.getVersion(), "Version 1.0.0 ", "Version label mismatch");
        softAssert.assertAll();

        // ✅ Wait for dashboard element to confirm successful login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='my new cafe']")));

//        tearDownOnce();
    }

}
