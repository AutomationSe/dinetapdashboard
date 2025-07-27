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
import pages.accountPage;
import utils.ExcelReader;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class accountTest extends BaseTest {
    SoftAssert softAssert = new SoftAssert();
    @BeforeClass
    public void loginAndWait() {
        loginAs("seneluser@gmail.com", "Senel2314@");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        WebElement heading = driver.findElement(By.xpath("(//h1[normalize-space()='Restaurants'])[1]"));
        String actualText = heading.getText().trim();
        String expectedText = "Restaurants";
        Assert.assertEquals(actualText, expectedText, "❌ Header text mismatch!");
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
    public void testAccountCreationDataDriven() {
        accountPage page = new accountPage(getDriver());
        List<Map<String, String>> testData = ExcelReader.getData("C:\\Users\\User\\Desktop\\Account_update.xlsx", "Sheet1");

        for (Map<String, String> data : testData) {
            page.clickAccountButton();

            // Legal section
            softAssert.assertEquals(page.getAccountNameText(), "Name", "❌ Name label mismatch");
            page.enterAccountName(data.get("Name"));

            softAssert.assertEquals(page.getRegistrationNumberText(), "Registration Number (UEN)", "❌ Reg. Number label mismatch");
            page.enterRegistrationNumber(data.get("registrationNumber"));

            softAssert.assertEquals(page.gstNumberText(), "GST Number", "❌ GST label mismatch");
            page.enterGSTNumber(data.get("GSTNumber"));

            softAssert.assertEquals(page.getOrganizationTypeText(), "Organization Type", "❌ Org Type label mismatch");
            page.selectOrganizationType(data.get("organizationType"));

            softAssert.assertEquals(page.getCityText(), "City", "❌ City label mismatch");
            page.selectCity(data.get("City"));

            softAssert.assertEquals(page.getStreetNameText(), "Street Name", "❌ Street label mismatch");
            page.enterStreetName(data.get("Street Name"));

            softAssert.assertEquals(page.getPostalCodeText(), "Postal Code", "❌ Postal Code label mismatch");
            page.enterPostalCode(data.get("Postal Code"));

            softAssert.assertEquals(page.getWebsiteText(), "Website", "❌ Website label mismatch");
            page.enterWebsite(data.get("Website"));

            softAssert.assertEquals(page.getAccountNameText(), "Name", "❌ Name label mismatch");
            softAssert.assertEquals(page.getRegistrationNumberText(), "Registration Number (UEN)", "❌ Reg. Number label mismatch");
            softAssert.assertEquals(page.getOrganizationTypeText(), "Organization Type", "❌ Org Type label mismatch");
            page.clickNextButton();

            // Restaurant page
            softAssert.assertEquals(page.getRestaurantText(), "Restaurant", "❌ Restaurant section label mismatch");

            softAssert.assertEquals(page.getNameText(), "Name", "❌ Restaurant name label mismatch");
            page.enterName(data.get("RestaurantName"));

            softAssert.assertEquals(page.getShopperStatementText(), "Shopper Statement", "❌ Shopper Statement label mismatch");
            page.enterShopperStatement(data.get("ShopperStatement"));

            softAssert.assertEquals(page.getOwnerEmailText(), "Owner Email", "❌ Owner Email label mismatch");
            page.enterOwnerEmail(data.get("OwnerEmail"));

            softAssert.assertEquals(page.getRestaurantPhoneNumberText(), "Restaurant Phone Number", "❌ Phone label mismatch");
            page.enterRestaurantPhoneNumber(data.get("RestaurantPhoneNumber"));

            page.clickSecondNextButton();

            // Final form
            softAssert.assertEquals(page.getPointOfContactText(), "Point of Contact Name", "❌ Point of Contact label mismatch");
            page.enterPointOfContact(data.get("PointofContact Name"));

            softAssert.assertEquals(page.getPointOfContactNumberText(), "Point of Contact Phone Number", "❌ Contact Phone label mismatch");
            page.enterPointOfContactNumber(data.get("PointofContactPhoneNumber"));

            softAssert.assertEquals(page.getSalesManagerText(), "Sales Manager", "❌ Sales Manager label mismatch");
            page.selectSalesManager(data.get("Sales Manager"));

            page.clickSubmitButton();

            // Confirmation assertions
            Assert.assertEquals(page.getSettingAccountText(), "Setting Up Your Account", "❌ Setup header mismatch");
            Assert.assertEquals(page.getInitializingText(), "Initializing", "❌ Init mismatch");
            Assert.assertEquals(page.getCreatingLegalText(), "Creating Legal Entity", "❌ Legal mismatch");
            Assert.assertEquals(page.getCreatingAccountText(), "Creating Account Holder", "❌ Account Holder mismatch");
            Assert.assertEquals(page.getCreatingAccountBalanceText(), "Creating Balance Account", "❌ Balance Account mismatch");
            Assert.assertEquals(page.getBusinessLinesText(), "Creating Business Lines", "❌ Biz Lines mismatch");
            Assert.assertEquals(page.getCreatingStoreText(), "Creating Store", "❌ Store mismatch");
            Assert.assertEquals(page.getCreatingPaymentMethodText(), "Creating Payment Methods", "❌ Payment Method mismatch");
            Assert.assertEquals(page.getCreatingRestaurantText(), "Creating Restaurant", "❌ Restaurant mismatch");
            Assert.assertEquals(page.getSendingOwnerInviteText(), "Sending Owner Invitation", "❌ Owner Invite mismatch");

            // Popup confirmation
            Assert.assertEquals(page.getPopupText(), "Share the below details with the restaurant owner", "❌ Popup text mismatch");
            Assert.assertEquals(page.getLinkExpireText(), "This link expires in 4 hours.", "❌ Link expiration mismatch");

            page.clickOkayButton();

            Assert.assertEquals(page.getHeaderAccountText(), "Accounts", "❌ Header text mismatch after account creation");

            softAssert.assertAll(); // ✅ validate all soft assertions before moving to next row
        }
    }


}
