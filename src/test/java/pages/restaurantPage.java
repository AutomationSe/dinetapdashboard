package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class restaurantPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public restaurantPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    private final By restaurantName = By.xpath("(//h1[normalize-space()='Restaurants'])[1]");
    private final By Payment_Provider = By.xpath("(//label[normalize-space()='Payment Provider'])[1]");
    private final By status = By.xpath("(//label[normalize-space()='Status'])[1]");
    private final By clicknewRestaurant = By.xpath("(//button[normalize-space()='New Restaurant'])[1]");
    private final By newRestaurantHeading = By.xpath("(//h1[normalize-space()='New Restaurant'])[1]");
    private final By restaurantBasicInfo = By.xpath("(//div[@class='ml-4 text-sm font-medium text-primary'])[1]");
    private final By NameText = By.xpath("(//label[normalize-space()='Name'])[1]");
    private final By NameInput = By.xpath("(//input[@id='name'])[1]");
    private final By Street = By.xpath("(//label[normalize-space()='Street'])[1]");
    private final By StreetInput = By.xpath("(//input[@id='address'])[1]");
    private final By Country = By.xpath("(//label[normalize-space()='Country'])[1]");
    private final By cityText = By.xpath("(//label[normalize-space()='City'])[1]");
    private final By cityInput = By.xpath("(//select[@aria-hidden='true'])[2]");
    private final By timezoneText = By.xpath("(//label[normalize-space()='Time Zone'])[1]");
    private final By timezoneInput = By.xpath("(//div[@class='flex w-full items-center justify-between'])[4]");
    private final By postalcodeText = By.xpath("(//label[normalize-space()='Postal Code'])[1]");
    private final By postalcodeInput = By.xpath("(//input[@id='posPostalCode'])[1]");
    private final By currencyText = By.xpath("(//label[normalize-space()='Currency'])[1]");
    private final By currencyInput = By.xpath("(//div[@class='flex w-full items-center justify-between'])[5]");
    private final By cusineText = By.xpath("(//label[normalize-space()='Cuisines'])[1]");
    private final By cuisinedropdown = By.xpath("(//div[@class='flex-1 overflow-hidden'])[1]");
    private final By mainCusineText = By.xpath("(//label[normalize-space()='Main Cuisine'])[1]");
    private final By mainCusinedropdown = By.xpath("(//div[@class='flex w-full items-center justify-between'])[6]");

    public String getRestaurantNameText() {
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        return shortWait.until(ExpectedConditions.visibilityOfElementLocated(restaurantName))
                .getText().trim();
    }
    public String getPaymentProviderText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(Payment_Provider))
                .getText().trim();
    }

    public String getStatusText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(status))
                .getText().trim();
    }

    public void clickNewRestaurant() {
        wait.until(ExpectedConditions.elementToBeClickable(clicknewRestaurant)).click();
    }

    public String getNewRestaurantHeadingText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(newRestaurantHeading))
                .getText().trim();
    }

    public String getRestaurantBasicInfoText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(restaurantBasicInfo))
                .getText().trim();
    }

    public String getNameText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(NameText))
                .getText().trim();
    }

    public void enterName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(NameInput)).sendKeys(name);
    }

    public String getStreetText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(Street))
                .getText().trim();
    }

    public void enterStreet(String street) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(StreetInput)).sendKeys(street);
    }

    public String getCountryText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(Country))
                .getText().trim();
    }

    public String getCityText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cityText))
                .getText().trim();
    }

    public void selectCity(String city) {
        try {
            Thread.sleep(4000); // Wait for 4 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(cityInput));
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(city);
    }

    public String getTimezoneText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(timezoneText))
                .getText().trim();
    }

    public void enterTimezone(String timezone) {
        // Click the dropdown to open it
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(timezoneInput));
        dropdown.click();

        // Small wait to allow dropdown options to render (optional but helpful for flaky dropdowns)
        try {
            Thread.sleep(500); // 0.5s delay if dropdown is rendered slowly
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Wait for the correct dropdown option and click it
        By option = By.xpath("//div[contains(@class,'option') and text()='" + timezone + "']");
        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(option));
        optionElement.click();
    }

    public String getPostalCodeText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(postalcodeText))
                .getText().trim();
    }

    public void enterPostalCode(String postalCode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(postalcodeInput)).sendKeys(postalCode);
    }

    public String getCurrencyText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(currencyText))
                .getText().trim();
    }

    public void enterCurrency(String currency) {
        // Step 1: Open the dropdown
        wait.until(ExpectedConditions.elementToBeClickable(currencyInput)).click();

        // Step 2: Wait for and select the currency option
        By option = By.xpath("//div[text()='" + currency + "']");
        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
    }


    public String getCuisineText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cusineText))
                .getText().trim();
    }

    public void selectCuisines(String cuisines) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cuisinedropdown)).click();

        // Split the comma-separated string and click each option
        String[] cuisineArray = cuisines.split(",");
        for (String cuisine : cuisineArray) {
            String trimmedCuisine = cuisine.trim();
            By option = By.xpath("//div[text()='" + trimmedCuisine + "']");
            wait.until(ExpectedConditions.elementToBeClickable(option)).click();
        }
    }
    public String getMainCuisineText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mainCusineText))
                .getText().trim();
    }

    public void selectMainCuisine(String mainCuisine) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainCusinedropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='" + mainCuisine + "']"))).click();
    }

}
