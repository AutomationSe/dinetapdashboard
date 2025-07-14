package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.logoutpage;

import java.time.Duration;

public class logoutTest extends BaseTest {

    @BeforeClass
    public void doLoginOnce() {
        loginAs("senel@gmail.com", "Senel2314@");

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[normalize-space()='my new cafe']")
        ));
    }

    @Test
    public void testLogoutFlow() {
        logoutpage logout = new logoutpage(getDriver());

        logout.clickProfile();
        logout.clickLogoutInMenu();

        String popupText = logout.getLogoutPopupText();

        logout.confirmLogout();
    }
}
