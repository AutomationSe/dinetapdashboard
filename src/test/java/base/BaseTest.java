package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.restaurantPage;
import java.time.Duration;

@Listeners(listerners.TestListener.class)
public class BaseTest {
    protected WebDriver driver;


    @BeforeClass(alwaysRun = true)
    public void setUpOnce() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://qa.admin.dinetap.com/");
    }

    public void loginAs(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);
    }

/*    @AfterClass(alwaysRun = true)
    public void tearDownOnce() {
        if (driver != null) {
            driver.quit();
        }
    }*/

    protected restaurantPage page;

    public void validateRestaurantHeaders(SoftAssert softAssert) {
        softAssert.assertEquals(page.getRestaurantNameText(), "Restaurants", "❌ Header text mismatch!");
        softAssert.assertEquals(page.getPaymentProviderText(), "Payment Provider", "❌ Payment Provider label mismatch");
        softAssert.assertEquals(page.getStatusText(), "Status", "❌ Status label mismatch");
    }

    public WebDriver getDriver() {
        return driver;
    }
}