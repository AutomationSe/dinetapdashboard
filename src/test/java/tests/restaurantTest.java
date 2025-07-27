package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.restaurantPage;
import utils.ExcelReader;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static java.sql.DriverManager.getDriver;

public class restaurantTest extends BaseTest {
    restaurantPage page;

    @BeforeClass
    public void loginAndWait() {
        loginAs("seneluser@gmail.com", "Senel2314@");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        // Now driver is ready, so initialize page here
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
