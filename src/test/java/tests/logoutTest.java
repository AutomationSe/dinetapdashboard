package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.logoutpage;

import java.time.Duration;

public class logoutTest extends BaseTest {
    SoftAssert softAssert = new SoftAssert();
    @BeforeClass
    public void doLoginOnce() {
        loginAs("senel@gmail.com", "Senel2314@");
        WebElement heading = driver.findElement(By.xpath("(//h1[normalize-space()='Restaurants'])[1]"));
        String actualText = heading.getText().trim();
        String expectedText = "Restaurants";
        softAssert.assertEquals(actualText, expectedText, "❌ Header text mismatch!");
    }

    @Test
    public void testLogoutFlow() {
        logoutpage logout = new logoutpage(getDriver());
        logout.clickProfile();
        softAssert.assertEquals(logout.getUsername(), "senel user", "Profile name mismatch in profile menu");
        softAssert.assertEquals(logout.getEmailAddress(),"seneluser@gmail.com" , "Email address mismatch in profile menu");
        softAssert.assertEquals(logout.getUserRoles(),"Super, Charges" , "User roles mismatch in profile menu");
        logout.clickLogoutInMenu();
//        String popupText = logout.getLogoutPopupText();
        logout.confirmLogout();
        softAssert.assertAll();
    }
}
