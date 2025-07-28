package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    private final By timezonedropdown = By.xpath("(//div[@class='flex w-full items-center justify-between'])[4]");
    private final By timezoneselect = By.xpath("(//select[@aria-hidden='true'])[3]");
    private final By postalcodeText = By.xpath("(//label[normalize-space()='Postal Code'])[1]");
    private final By postalcodeInput = By.xpath("(//input[@id='posPostalCode'])[1]");
    private final By currencyText = By.xpath("(//label[normalize-space()='Currency'])[1]");
    private final By currencyInput = By.xpath("(//select[@aria-hidden='true'])[4]");
    private final By cusineText = By.xpath("(//label[normalize-space()='Cuisines'])[1]");
    private final By cuisinedropdown = By.xpath("(//div[@class='flex-1 overflow-hidden'])[1]");
    private final By mainCusineText = By.xpath("(//label[normalize-space()='Main Cuisine'])[1]");
    private final By mainCuisineDropdownTrigger = By.xpath("(//div[@class='flex w-full items-center justify-between'])[6]");
//    private final By maincusineselect = By.xpath("(//select[@aria-hidden='true'])[5]");
    private final By clickNextButton = By.xpath("(//button[normalize-space()='Next'])[1]");

    private final By locationinfoText = By.xpath("(//div[@class='ml-4 text-sm font-medium text-primary'])[1]");
    private final By insertLocation = By.xpath("(//input[@placeholder='E.g: Alexandra Road, Singapore'])[1]");
    private final By firstSuggestion = By.cssSelector(".pac-item");

    private final By latitudeText = By.xpath("(//label[normalize-space()='Latitude'])[1]");
    private final By longitudeText = By.xpath("(//label[normalize-space()='Longitude'])[1]");
    private final By Place_IDText = By.xpath("(//label[normalize-space()='Place ID'])[1]");

    private final By clickNextButton2 = By.xpath("(//button[normalize-space()='Next'])[1]");
    private final By contactinfotext = By.xpath("(//div[@class='ml-4 text-sm font-medium text-primary'])[1]");
    private final By emailText = By.xpath("(//label[normalize-space()='Email'])[1]");
    private final By emailInput = By.cssSelector("#registeredEmail]");
    private final By phonenumberText = By.xpath("(//label[normalize-space()='Phone Number'])[1]");
    private final By phonenumberInput = By.cssSelector("#registeredMobileNo");
    private final By pointcontactName = By.xpath("(//label[normalize-space()='Point of Contact Name'])[1]");
    private final By pointcontactInput = By.cssSelector("#contactPersonName");
    private final By pointcontactphoneText = By.xpath("(//label[normalize-space()='Point of Contact Phone Number'])[1]");
    private final By pointcontactphoneInput = By.cssSelector("#contactPersonMobileNo");
    


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
        WebDriverWait preWait = new WebDriverWait(driver, Duration.ofSeconds(1));
        preWait.until(ExpectedConditions.presenceOfElementLocated(clicknewRestaurant));

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
            Thread.sleep(2000); // Wait for 4 seconds
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
        try {
            Thread.sleep(2000); // Wait for 4 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(timezoneselect));
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(timezone);
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

/*        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(currencyInput));
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(currency);

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
        WebElement trigger = wait.until(ExpectedConditions.elementToBeClickable(mainCuisineDropdownTrigger));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", trigger);


        try {
            Thread.sleep(2000); // allow dropdown options to load
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        By optionLocator = By.xpath("//div[contains(@class,'option') or @role='option'][normalize-space()='" + mainCuisine + "']");


        WebElement optionElement = wait.until(ExpectedConditions.presenceOfElementLocated(optionLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
    }

    public void clickNextButton() {
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement element = shortWait.until(ExpectedConditions.elementToBeClickable(clickNextButton));
        element.click();
    }

    public void selectLocationFromGoogle(String location) {
        // Step 1: Type the address
        try {
            Thread.sleep(1500);  // if needed for Google data population
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement locationInput = wait.until(ExpectedConditions.visibilityOfElementLocated(insertLocation));
        locationInput.clear();
        locationInput.sendKeys(location);

        // Step 2: Wait for Google suggestion to appear
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement suggestion = shortWait.until(ExpectedConditions.elementToBeClickable(firstSuggestion));

        // Step 3: Click the first suggestion
        suggestion.click();
    }

    public String getLatitudeText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(latitudeText))
                .getText().trim();
    }

    public String getLongitude() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(longitudeText))
                .getText().trim();
    }


    public String getplaceidtext() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(Place_IDText));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

        return wait.until(ExpectedConditions.visibilityOf(element)).getText().trim();
    }

    public void clickNextButton2() {
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement element = shortWait.until(ExpectedConditions.elementToBeClickable(clickNextButton2));
        element.click();
    }


    public String getContactInfoText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(contactinfotext))
                .getText().trim();
    }

    public String getEmailText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailText))
                .getText().trim();
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(email);
    }

    public String getPhoneNumberText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(phonenumberText))
                .getText().trim();
    }

    public void enterPhoneNumber(String phoneNumber) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(phonenumberInput)).sendKeys(phoneNumber);
    }

    public String getPointContactNameText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pointcontactName))
                .getText().trim();
    }

    public void enterPointContactName(String contactName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pointcontactInput)).sendKeys(contactName);
    }

    public String getPointphoneText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pointcontactphoneText))
                .getText().trim();
    }

    public void enterPointContactPhone(String contactEmail) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pointcontactphoneInput)).sendKeys(contactEmail);
    }


}
