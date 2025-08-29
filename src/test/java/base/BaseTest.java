package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.restaurantPage;

import java.io.File;
import java.time.Duration;

@Listeners(listerners.TestListener.class)
public class BaseTest {
    protected WebDriver driver;
    protected restaurantPage page;

    @BeforeSuite
    public void cleanScreenshotsDir() {
        File screenshotFolder = new File("test-output/screenshots");
        if (screenshotFolder.exists()) {
            for (File file : screenshotFolder.listFiles()) {
                file.delete();
            }
        }
    }

    @BeforeClass(alwaysRun = true)
    public void setUpOnce() {
        WebDriverManager.chromedriver().setup();

        // ✅ Add ChromeOptions to disable graphics
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu");            // Disable GPU rendering
        options.addArguments("--disable-extensions");     // Disable extensions
        options.addArguments("--disable-dev-shm-usage");  // Prevents resource issues
        options.addArguments("--no-sandbox");             // More stable in CI/CD
        options.addArguments("--remote-allow-origins=*"); // Helps with ChromeDriver versions

        driver = new ChromeDriver(options);
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
        }
    */

    /*    @AfterSuite(alwaysRun = true)
        public void tearDownAfterSuite() {
            if (driver != null) {
                driver.quit();
            }
        }
    */
    public void validateRestaurantHeaders(SoftAssert softAssert) {
        softAssert.assertEquals(page.getRestaurantNameText(), "Restaurants", "❌ Header text mismatch!");
        softAssert.assertEquals(page.getPaymentProviderText(), "Payment Provider", "❌ Payment Provider label mismatch");
        softAssert.assertEquals(page.getStatusText(), "Status", "❌ Status label mismatch");
    }

    public WebDriver getDriver() {
        return driver;
    }
}
