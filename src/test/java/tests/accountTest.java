package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.accountPage;

import java.time.Duration;

public class accountTest extends BaseTest {
    SoftAssert softAssert = new SoftAssert();
    @BeforeClass
    public void loginAndWait() {
        loginAs("senel@gmail.com", "Senel2314@");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[normalize-space()='Magnified Res']")
        ));
    }

    @Test(priority = 1)
    public void testAccountNavigationAndHeader() {
        accountPage page = new accountPage(getDriver());
        page.clickSystemAccountLink();
        Assert.assertEquals(
                page.getHeaderAccountText(),
                "Accounts","❌ Header text mismatch after clicking Accounts link"
        );
    }

    @Test(priority = 2)
    public void ClickandCancel(){
        accountPage page = new accountPage(getDriver());
        page.clickAccountButton();
        Assert.assertEquals(
                page.getCreateTextTwo(),
                "Accounts","❌ Header text mismatch after clicking New Account button"
        );
        Assert.assertEquals(
                page.getCreateTextTwo(),
                "Accounts","❌ Accounts text mistach after clicking New Account button"
        );

        Assert.assertEquals(
                page.getLegalText(),
                "Legal","❌ Legal text mismatch after clicking New Account button"
        );

        page.clickCancelButton();
        Assert.assertEquals(
                page.getCancelButtonText(),
                "Are you sure you want to cancel this account creation?","❌ Cancel confirmation text mismatch"
        );
        page.clickCancelButtonTwo();
    }

    @Test(priority = 3)
    public void testAccountLink() {
        accountPage page = new accountPage(getDriver());

        Assert.assertEquals(
                page.getCreateTextTwo(),
                "Accounts","❌ Header text mismatch after clicking New Account button"
        );

        page.clickAccountButton();


        softAssert.assertEquals(
                page.getAccountNameText(),
                "Name","❌ Header text mismatch after clicking New Account button"
        );

        page.enterAccountName("Test Account");

        softAssert.assertEquals(
                page.getRegistrationNumberText(),
                "Registration Number (UEN)","❌ Registration Number text mismatch"
        );

        page.enterRegistrationNumber("1234567890");

        softAssert.assertEquals(
                page.gstNumberText(),
                "GST Number","❌ GST Number text mismatch"
        );

        page.enterGSTNumber("GST123456");

        softAssert.assertEquals(page.getCityText(),"City", "❌ City text mismatch");

        page.selectCity("Downtown Core");

        softAssert.assertEquals(
                page.getStreetNameText(),
                "Street Name","❌ Street Name text mismatch"
        );

        page.enterStreetName("123 Main St");

        softAssert.assertEquals(
                page.getPostalCodeText(),
                "Postal Code","❌ Postal Code text mismatch"
        );

        page.enterPostalCode("188601");

        softAssert.assertEquals(
                page.getWebsiteText(),
                "Website","❌ Website text mismatch"
        );

        page.enterWebsite("https://qa.admin.dinetap.com/");

        page.clickNextButton();

        softAssert.assertEquals(page.getRestaurantText(),"Restaurant", "❌ Restaurant text mismatch");

        softAssert.assertEquals(page.getNameText(),"Name", "❌ Name text mismatch");
        page.enterName("New name");

        softAssert.assertEquals(page.getShopperStatementText(),"Shopper Statement", "❌ Shopper Statement text mismatch");
        page.enterShopperStatement("NEWSHOPESTATEMENT");

        softAssert.assertEquals(page.getCountryText(), "Country", "❌ Country text mismatch");
        softAssert.assertEquals(page.getCityNewText(), "Country", "❌ Country text mismatch");
        softAssert.assertEquals(page.getStreetText(), "Country", "❌ Country text mismatch");
        softAssert.assertEquals(page.getPostalCodeTextNew(), "Country", "❌ Country text mismatch");

        softAssert.assertEquals(page.getCurrencyText(),"Currency", "❌ Currency text mismatch");
        page.selectCurrency("Australian Dollar (AUD)");

        softAssert.assertEquals(page.getTimeZoneText(),"Time Zone","❌ Time Zone text mismatch");
        softAssert.assertEquals(page.getOwnerEmailText(),"Owner Email","❌ Owner Email text mismatch");
        page.enterOwnerEmail("senelqa@gmail.com");
        softAssert.assertEquals(page.getRestaurantPhoneNumberText(),"Restaurant Phone Number","❌ Owner Phone text mismatch");
        page.enterRestaurantPhoneNumber("6512 4544");

        softAssert.assertAll();
    }

}
