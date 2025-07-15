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

    @Test(description = "Login with valid credentials using LoginPage directly")
    public void testLogin() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("seneluser@gmail.com", "Senel2314@");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='my new cafe']")));
        tearDownOnce();
    }
}
