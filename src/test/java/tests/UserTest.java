package tests;

import base.BaseTest;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserPage;
import pages.restaurantPage;
import utils.ExcelReader;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.logging.SocketHandler;
import pages.UserPage;

public class UserTest extends BaseTest {
    SoftAssert softAssert;
    UserPage userPage;
    @BeforeClass
    public void doLoginOnce() {
        softAssert = new SoftAssert();
        userPage = new UserPage(getDriver());
        loginAs("senel@gmail.com", "Senel2314@");
        page = new restaurantPage(getDriver());
        validateRestaurantHeaders(softAssert);
        softAssert.assertAll();
    }

    @Test(priority = 1)
    @Description("Verify navigation to Users page and header text")
    public void testUserNavigationAndHeader() {
        userPage.openUsersPage();
        Assert.assertEquals(userPage.getUsersHeaderText(), "Users", "Header text mismatch on Users page");
        Assert.assertEquals(userPage.getCountryText(), "Countries", "Country label text mismatch");
        Assert.assertEquals(userPage.getStatusText(), "Status", "Status label text mismatch");
        Assert.assertEquals(userPage.getRoleText(), "Roles", "Role label text mismatch");
        Assert.assertEquals(getDriver().getTitle(), "Users | Dinetap");
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://qa.admin.dinetap.com/dashboard/users");
        userPage.clickNewUser();
    }

    @DataProvider(name = "userData")
    public Object[][] getUserData() {
        String path = "C:\\Users\\User\\Desktop\\Eatme Files\\dinetapadminpanel\\src\\test\\resources\\users.xlsx";
        List<Map<String, String>> data = ExcelReader.getData(path, "Sheet1");
        Object[][] result = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            result[i][0] = data.get(i);
        }
        return result;
    }
    @Test(dataProvider = "userData")
    public void createUserTest(Map<String, String> userData) {
        if (userData == null) {
            return;
        }
        userPage.openUsersPage();
        userPage.clickNewUser();
        Assert.assertEquals(userPage.getNewUserHeadingText(), "New User", "❌ Heading mismatch");
        Assert.assertEquals(userPage.getUsernameText(), "Name", "❌ Name label mismatch");
        userPage.fillName(userData.get("Name"));
        Assert.assertEquals(userPage.getEmailText(), "Email", "❌ Email label mismatch");
        userPage.fillEmail(userData.get("Email"));
        Assert.assertEquals(userPage.getRolesText(), "Roles", "❌ Roles label mismatch");
        userPage.selectRoles(userData.get("Role"));
        Assert.assertEquals(userPage.getPhoneNumberText(), "Phone Number", "❌ Phone Number label mismatch");
        userPage.fillPhone(userData.get("Phone"));
        Assert.assertEquals(userPage.getcountrytext(), "Countries", "❌ Countries label mismatch");
        userPage.selectCountry(userData.get("Country"));
        Assert.assertEquals(userPage.getPasswordText(), "Password", "❌ Password label mismatch");
        userPage.fillPassword(userData.get("Password"));
        userPage.clickCreate();
        if (page.isBadRequestPopupPresent()) {
            System.out.println("❌ User cannot be created – Reason: " + page.getBadRequestText());
            Assert.fail("Failed to create a User, because of duplicate data");
        }else {
            System.out.println("✅ Created user: " + userData.get("Email"));
        }

        userPage.closeModalIfOpen();
//        System.out.println("✅ Created user: " + userData.get("Email"));
    }



}