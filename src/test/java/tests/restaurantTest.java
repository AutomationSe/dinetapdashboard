package tests;

import base.BaseTest;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.restaurantPage;
import utils.ExcelReader;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static java.sql.DriverManager.getDriver;

public class restaurantTest extends BaseTest {
    restaurantPage page;
/*    SoftAssert softAssert = new SoftAssert();*/

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

    @DataProvider(name = "restaurantData")
    public Iterator<Object[]> getRestaurantData() {
        String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\Restaurant.xlsx";
        String sheet = "Sheet1";
        List<Map<String, String>> dataList = ExcelReader.getData(filePath, sheet);
        return dataList.stream().map(row -> new Object[] { row }).iterator();
    }

    @Test(dataProvider = "restaurantData", priority = 3)
    public void clickNewRestaurant(Map<String, String> data) {
        SoftAssert softAssert = new SoftAssert();
        page.clickNewRestaurant();
        Assert.assertEquals(page.getNewRestaurantHeadingText(), "New Restaurant", "❌ Heading mismatch");
//        Assert.assertEquals(page.getRestaurantBasicInfoText(), "Basic Info", "❌ Section heading mismatch");
        // Fill form
        Assert.assertEquals(page.getNameText(), "Name", "❌ Name label mismatch");
        page.enterName(data.get("Name"));
        Assert.assertEquals(page.getStreetText(), "Street", "❌ Street label mismatch");
        page.enterStreet(data.get("Street"));
        Assert.assertEquals(page.getCountryText(), "Country", "❌ Country label mismatch");
        page.selectCountry("Singapore");
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
        Assert.assertEquals(page.getLatitudeText(), "Latitude", "❌ Latitude label mismatch");
        Assert.assertEquals(page.getLongitude(), "Longitude", "❌ Longitude label mismatch");
        Assert.assertEquals(page.getplaceidtext(), "Place ID", "❌ Place ID label mismatch");
        page.clickNextButton2();
        Assert.assertEquals(page.getContactInfoText(), "Contact", "❌ Contact Info label mismatch");
        Assert.assertEquals(page.getEmailText(), "Email", "❌ Email label mismatch");
        page.enterEmail(data.get("Email"));
        Assert.assertEquals(page.getPhoneNumberText(), "Phone Number", "❌ Phone label mismatch");
        page.enterPhoneNumber(data.get("Phone Number"));
        Assert.assertEquals(page.getPointContactNameText(), "Point of Contact Name", "❌ Point of Contact Name label mismatch");
        page.enterPointContactName(data.get("Point of Contact Name"));
        Assert.assertEquals(page.getPointphoneText(), "Point of Contact Phone Number", "❌ Point of Contact Phone Number label mismatch");
        page.enterPointContactPhone(data.get("Point of Contact Phone Number"));
        page.clickNextButton3();
        softAssert.assertEquals(page.getSalesinfoText(), "Sales Info", "❌ Sales Info label mismatch");
        softAssert.assertEquals(page.getSalesmanagerText(), "Sales Manager", "❌ Sales Manager label mismatch");
        page.selectSalesManager(data.get("Sales Manager"));
        softAssert.assertEquals(page.getRestaurantCategoryText(), "Restaurant Category", "❌ Restaurant Category label mismatch");
        page.selectRestaurantCategory(data.get("Restaurant Category"));
        page.clickNextButton4();
        softAssert.assertEquals(page.getPaymentInfoText(), "Payment Info", "❌ Payment Info label mismatch");
        softAssert.assertEquals(page.getPaymentProviderTxt(), "Provider", "❌ Payment Provider label mismatch");
        softAssert.assertEquals(page.getPaymentPlatformAccountText(), "Platform Account", "❌ Platform Account label mismatch");
        page.enterPaymentPlatformAccount(data.get("Platform Account"));
        softAssert.assertEquals(page.getConnectAccountText(), "Connect Account", "❌ Connect Account label mismatch");
        page.enterConnectAccount(data.get("Connect Account"));
        page.clickNextButton5();
        softAssert.assertEquals(page.getCompanyInfoText(), "Company Info", "❌ Company Info label mismatch");
        Assert.assertEquals(page.getcompanyNameText(), "Name", "❌ Company Name label mismatch");
        page.enterCompanyName(data.get("CompanyName"));
        softAssert.assertEquals(page.getCompanyStreetText(), "Street", "❌ Street label mismatch");
        page.enterCompanyStreet(data.get("CompanyStreet"));
        softAssert.assertEquals(page.getCompanyCountryText(), "Country", "❌ Country label mismatch");
        page.selectCompanyCountry("Singapore");
        softAssert.assertEquals(page.getCompanyCityText(), "City", "❌ City label mismatch");
        page.selectCompanyCity(data.get("CompanyCity"));
        softAssert.assertEquals(page.getCompanyPostalCodeText(), "Postal Code", "❌ Postal Code label mismatch");
        page.enterCompanyPostalCode(data.get("CompanyPostalCode"));
        softAssert.assertEquals(page.getRegisteredNumberText(), "Registration Number (UEN)", "❌ UEN label mismatch");
        page.enterRegisteredNumber(data.get("CompanyUEN"));
        softAssert.assertEquals(page.getGstNumberText(), "GST Number", "❌ GST label mismatch");
        page.enterGstNumber(data.get("CompanyGST"));
        page.clickNextButton6();
        page.enableToggleIfRequired("posSwitch", data.get("POS"));
        page.enableToggleIfRequired("dinetapApp", data.get("MobileApp"));
        page.enableToggleIfRequired("payments", data.get("Payments"));
        page.clickNextButton7();
//        softAssert.assertEquals(page.getLogoVerifyText(),"Please provide a high-quality image of your restaurant's logo with a minimum resolution of 1024 x 1024 pixels and an aspect ratio of 1:1. Ensure that the file size does not exceed 2MB. Accepted file formats include JPG, JPEG, and PNG.", "❌ Logo verification text mismatch");
        softAssert.assertEquals(page.getAgreementText(),"Agreement", "❌ Agreement text mismatch");
//        softAssert.assertEquals(page.getAgreementHeadingText().trim(), "Make sure you are uploading a clear and readable PDF document for your restaurant (After selecting make sure to upload the pdf.)", "❌ Agreement heading text mismatch");
        page.clickSubmitCreateButton();
//        Thread.sleep(2000);


        if (page.isBadRequestPopupPresent()) {
            System.out.println("❌ Restaurant cannot be created – Reason: " + page.getBadRequestText());
            Assert.fail("Bad Request popup appeared. Restaurant creation failed.");
        }else {
            System.out.println("Restaurant created: " + data.get("Name"));
        }

        softAssert.assertAll();
    }
}
