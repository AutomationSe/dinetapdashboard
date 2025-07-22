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
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//h1[normalize-space()='Restaurants'])[1]")
        ));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//div[normalize-space()='Magnified Res'])[1]")
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

/*    @Test(priority = 2)
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
    }*/

    @Test(priority = 2)
    public void testAccountLink() {
        accountPage page = new accountPage(getDriver());

        Assert.assertEquals(page.getCreateTextTwo(), "Accounts","❌ Header text mismatch after clicking New Account button");

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

        softAssert.assertEquals(page.getOrganizationTypeText(),"Organization Type", "❌ Organization Type text mismatch");
        page.selectOrganizationType("Listed Public Company");


        softAssert.assertEquals(page.getCityText(),"City", "❌ City text mismatch");

        Assert.assertEquals(
                page.getCheckDefaultCity(),
                "Singapore","❌ Country text mismatch"
        );

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
        softAssert.assertEquals(page.getCityNewText(), "City", "❌ City text mismatch");
        softAssert.assertEquals(page.getStreetText(), "Street Name", "❌ Street Name text mismatch");
        softAssert.assertEquals(page.getPostalCodeTextNew(), "Postal Code", "❌ Postal Code text mismatch");

        softAssert.assertEquals(page.getCurrencyText(),"Currency", "❌ Currency text mismatch");

        softAssert.assertEquals(page.getTimeZoneText(),"Time Zone","❌ Time Zone text mismatch");
        softAssert.assertEquals(page.getOwnerEmailText(),"Owner Email","❌ Owner Email text mismatch");
        page.enterOwnerEmail("senelqa@gmail.com");
        softAssert.assertEquals(page.getRestaurantPhoneNumberText(),"Restaurant Phone Number","❌ restaurant phone number text mismatch");
        page.enterRestaurantPhoneNumber("6512 4544");

        page.clickSecondNextButton();

        softAssert.assertEquals(page.getPointOfContactText(), "Point of Contact Name", "❌ point of contact text mismatch");
        page.enterPointOfContact("Test Contact");

        softAssert.assertEquals(page.getPointOfContactNumberText(), "Point of Contact Phone Number", "❌ Point of Contact Number text mismatch");
        page.enterPointOfContactNumber("6565 2114");

        softAssert.assertEquals(page.getSalesManagerText(), "Sales Manager", "❌ sales manager text mismatch");
        page.selectSalesManager("John");

        page.clickSubmitButton();

        Assert.assertEquals(
                page.getSettingAccountText(),
                "Setting Up Your Account","❌ setting up your account text mismatch after account creation"
        );

        Assert.assertEquals(
                page.getInitializingText(),
                "Initializing","❌ Initializing message mismatch after account creation"
        );

        Assert.assertEquals(
                page.getCreatingLegalText(),
                "Creating Legal Entity","❌ Legal Entity message mismatch after account creation"
        );

        Assert.assertEquals(
                page.getCreatingAccountText(),
                "Creating Account Holder","❌ Account Holder message mismatch after account creation"
        );

        Assert.assertEquals(
                page.getCreatingAccountBalanceText(),
                "Creating Balance Account","❌ Balance Account message mismatch after account creation"
        );

        Assert.assertEquals(
                page.getBusinessLinesText(),
                "Creating Business Lines","❌ Buisiness Lines message mismatch after account creation"
        );

        Assert.assertEquals(
                page.getCreatingStoreText(),
                "Creating Store","❌ Creating Store message mismatch after account creation"
        );

        Assert.assertEquals(
                page.getCreatingPaymentMethodText(),
                "Creating Payment Methods","❌ Payment Method message mismatch after account creation"
        );

        Assert.assertEquals(
                page.getCreatingRestaurantText(),
                "Creating Restaurant","❌ Creating Restaurant message mismatch after account creation"
        );
        Assert.assertEquals(
                page.getSendingOwnerInviteText(),
                "Sending Owner Invitation","❌ Invitation message mismatch after account creation"
        );

        Assert.assertEquals(
                page.getPopupText(),
                "Share the below details with the restaurant owner","❌ Success message mismatch If paragraph after account creation"
        );

        Assert.assertEquals(
                page.getLinkExpireText(),
                "This link expires in 4 hours.","❌ Link expiration message mismatch after account creation"
        );

        page.clickOkayButton();

        softAssert.assertAll();
    }

/*    @Test(priority = 2)
    public void testAccountLinkDataDriven() {
        String filePath = "C:\\Users\\User\\Desktop\\Eatme Files\\dinetapadminpanel\\src\\test\\resources\\AccountData.xlsx";
        List<Map<String, String>> testData = ExcelReader.getData(filePath, "AccountData");

        for (Map<String, String> data : testData) {
            accountPage page = new accountPage(getDriver());

            page.clickAccountButton();

            page.enterAccountName(data.get("Name"));
            page.enterRegistrationNumber(data.get("UEN"));
            page.enterGSTNumber(data.get("GSTNumber"));
            page.selectOrganizationType(data.get("OrgType"));
            page.selectCity(data.get("City"));
            page.enterStreetName(data.get("StreetName"));
            page.enterPostalCode(data.get("PostalCode"));
            page.enterWebsite(data.get("Website"));

            page.clickNextButton();

            page.enterName("Test Restaurant"); // hardcoded
            page.enterShopperStatement("TEST STATEMENT"); // hardcoded

            page.enterOwnerEmail(data.get("OwnerEmail"));
            page.enterRestaurantPhoneNumber(data.get("PhoneNumber"));

            page.clickSecondNextButton();

            page.enterPointOfContact("QA Contact"); // hardcoded
            page.enterPointOfContactNumber("99998888"); // hardcoded
            page.selectSalesManager(data.get("SalesManager"));

            page.clickSubmitButton();
        }
    }*/

}
