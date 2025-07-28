package tests;

import base.BaseTest;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.restaurantPage;
import utils.ExcelReader;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static java.sql.DriverManager.getDriver;

public class restaurantTest extends BaseTest {
    restaurantPage page;
    SoftAssert softAssert = new SoftAssert();
    @BeforeClass
    public void loginAndWait() {
        loginAs("seneluser@gmail.com", "Senel2314@");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        page = new restaurantPage(getDriver());

    }

    @Test(priority = 1)
    public void testRestaurantPageHeader() {
        Assert.assertEquals(page.getRestaurantNameText(), "Restaurants", "❌ Header text mismatch!");
        Assert.assertEquals(page.getPaymentProviderText(), "Payment Provider", "❌ Payment Provider label mismatch");
        Assert.assertEquals(page.getStatusText(), "Status", "❌ Status label mismatch");
    }

    @Test(priority = 3)
    public void clickNewRestaurant() {
        List<Map<String, String>> testData = ExcelReader.getData("C:\\Users\\User\\Desktop\\Eatme Files\\dinetapadminpanel\\src\\test\\resources\\Restaurant.xlsx", "Sheet1");
        for (Map<String, String> data : testData) {
            page.clickNewRestaurant();
            Assert.assertEquals(page.getNewRestaurantHeadingText(), "New Restaurant", "❌ Heading mismatch");
            Assert.assertEquals(page.getRestaurantBasicInfoText(), "Basic Info", "❌ Section heading mismatch");
            // Fill form
            Assert.assertEquals(page.getNameText(), "Name", "❌ Name label mismatch");
            page.enterName(data.get("Name"));
            Assert.assertEquals(page.getStreetText(), "Street", "❌ Street label mismatch");
            page.enterStreet(data.get("Street"));
            Assert.assertEquals(page.getCityText(), "City", "❌ City label mismatch");
            page.selectCity(data.get("City"));
            Assert.assertEquals(page.getTimezoneText(), "Time Zone", "❌ TimeZone label mismatch");
            page.enterTimezone(data.get("Time Zone"));
            Assert.assertEquals(page.getPostalCodeText(), "Postal Code", "❌ Postal Code label mismatch");
            page.enterPostalCode(data.get("Postal Code"));
            Assert.assertEquals(page.getCurrencyText(), "Currency", "❌ Currency label mismatch");
            page.enterCurrency(data.get("Currency"));
            Assert.assertEquals(page.getCuisineText(), "Cuisines", "❌ Cuisine label mismatch");
            page.selectCuisines(data.get("Cuisines"));
            Assert.assertEquals(page.getMainCuisineText(), "Main Cuisine", "❌ Main Cuisine label mismatch");
            page.selectMainCuisine(data.get("Main Cuisine"));

            page.clickNextButton();

            page.selectLocationFromGoogle(data.get("newlocation"));
//            page.selectLocationFromGoogle("24 Purvis St, Singapore 188601");
            Assert.assertEquals(page.getLatitudeText(), "Latitude", "❌ Main Cuisine label mismatch");
            Assert.assertEquals(page.getLongitude(), "Longitude", "❌ Main Cuisine label mismatch");
            Assert.assertEquals(page.getplaceidtext(), "Place ID", "❌ Main Cuisine label mismatch");

            page.clickNextButton2();

            Assert.assertEquals(page.getContactInfoText(),"Contact Info", "❌ Contact Info label mismatch");
            Assert.assertEquals(page.getEmailText(),"Email", "❌ Email label mismatch");
            page.enterEmail(data.get("Email"));
            Assert.assertEquals(page.getPhoneNumberText(),"Phone Number", "❌ Phone label mismatch");
            page.enterPhoneNumber(data.get("Phone Number"));
            Assert.assertEquals(page.getPointContactNameText(),"Point of Contact Name", "❌ Point of Contact Name label mismatch");
            page.enterPointContactName(data.get("Point of Contact Name"));
            Assert.assertEquals(page.getPointphoneText(),"Point of Contact Phone Number", "❌ Point of Contact Phone Number label mismatch");
            page.enterPointContactPhone(data.get("Point of Contact Phone Number"));

            page.clickNextButton3();

            softAssert.assertEquals(page.getSalesinfoText(), "Sales Info", "❌ Sales Info label mismatch");
            softAssert.assertEquals(page.getSalesmanagerText(), "Sales Manager", "❌ Sales Manager label mismatch");
            page.selectSalesManager(data.get("Sales Manager"));
            softAssert.assertEquals(page.getRestaurantCategoryText(), "Restaurant Category", "❌ Restaurant Category label mismatch");
            page.selectRestaurantCategory(data.get("Restaurant Category"));
            page.clickNextButton4();

            softAssert.assertEquals(page.getPaymentInfoText(),"Payment Info" , "❌ Payment Info label mismatch");
            softAssert.assertEquals(page.getPaymentProviderTxt(),"Provider", "❌ Payment Provider label mismatch");
            softAssert.assertEquals(page.getPaymentPlatformAccountText(),"Platform Account", "❌ Platform Account label mismatch");
            page.enterPaymentPlatformAccount("EatMe - POS 2 (acct_1O9kwUAaoVAZ6m8M)");
            softAssert.assertEquals(page.getConnectAccountText(), "Connect Account", "❌ Connect Account label mismatch");
            page.enterConnectAccount("acct_1REm1MPMERGGWtpY");

            softAssert.assertAll();

        }

    }

/*    @Test(priority = 3)
    public void createnewRestaurant() {
        List<Map<String, String>> testData = ExcelReader.getData("C:\\Users\\User\\Desktop\\Eatme Files\\dinetapadminpanel\\src\\test\\resources\\Restaurant.xlsx", "Sheet1");
        for (Map<String, String> data : testData) {
            page.clickNewRestaurant();
            // Validate page heading
            Assert.assertEquals(page.getNewRestaurantHeadingText(), "New Restaurant", "❌ Heading mismatch");
            Assert.assertEquals(page.getRestaurantBasicInfoText(), "Restaurant Basic Info", "❌ Section heading mismatch");
            // Fill form
            Assert.assertEquals(page.getNameText(), "Name", "❌ Name label mismatch");
            page.enterName(data.get("Name"));
            Assert.assertEquals(page.getStreetText(), "Street", "❌ Street label mismatch");
            page.enterStreet(data.get("Street"));
            Assert.assertEquals(page.getCityText(), "City", "❌ City label mismatch");
            page.enterCity(data.get("City"));
            Assert.assertEquals(page.getTimezoneText(), "Time Zone", "❌ TimeZone label mismatch");
            page.enterTimezone(data.get("Time Zone"));
            Assert.assertEquals(page.getPostalCodeText(), "Postal Code", "❌ Postal Code label mismatch");
            page.enterPostalCode(data.get("Postal Code"));
            Assert.assertEquals(page.getCurrencyText(), "Currency", "❌ Currency label mismatch");
            page.enterCurrency(data.get("Currency"));
            Assert.assertEquals(page.getCuisineText(), "Cuisines", "❌ Cuisine label mismatch");
            page.selectCuisines(data.get("Cuisines"));
            Assert.assertEquals(page.getMainCuisineText(), "Main Cuisine", "❌ Main Cuisine label mismatch");
            page.selectMainCuisine(data.get("Main Cuisine"));
        }
    }*/

}
