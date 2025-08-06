package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class restaurantPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public restaurantPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    private final By restaurantName = By.xpath("//h1[normalize-space()='Restaurants']");
    private final By Payment_Provider = By.xpath("(//label[normalize-space()='Payment Provider'])[1]");
    private final By payment_providerInput = By.xpath("//div[@aria-label='Select Payment Provider']//div[@class='flex-1 overflow-hidden']");
    private final By status = By.xpath("(//label[normalize-space()='Status'])[1]");
    private final By clicknewRestaurant = By.xpath("(//button[normalize-space()='New Restaurant'])[1]");
    private final By newRestaurantHeading = By.xpath("(//h1[normalize-space()='New Restaurant'])[1]");
    private final By restaurantBasicInfo = By.xpath("(//div[@class='ml-4 text-sm font-medium text-primary'])[1]");
    private final By NameText = By.xpath("(//label[normalize-space()='Name'])[1]");
    private final By NameInput = By.xpath("(//input[@id='name'])[1]");
    private final By Street = By.xpath("(//label[normalize-space()='Street'])[1]");
    private final By StreetInput = By.xpath("(//input[@id='address'])[1]");
    private final By Country = By.xpath("(//label[normalize-space()='Country'])[1]");
    private final By origcountryInput = By.xpath("(//div[@class='flex w-full items-center justify-between'])[2]");
    private final By cityText = By.xpath("(//label[normalize-space()='City'])[1]");
    private final By cityInput = By.xpath("(//div[@class='flex w-full items-center justify-between'])[3]");
    private final By timezoneText = By.xpath("(//label[normalize-space()='Time Zone'])[1]");
    private final By timezonedropdown = By.xpath("(//div[@class='flex w-full items-center justify-between'])[4]");
    private final By timezoneselect = By.xpath("(//div[@class='flex w-full items-center justify-between'])[4]");
    private final By postalcodeText = By.xpath("(//label[normalize-space()='Postal Code'])[1]");
    private final By postalcodeInput = By.xpath("(//input[@id='posPostalCode'])[1]");
    private final By currencyText = By.xpath("(//label[normalize-space()='Currency'])[1]");
//    private final By currencyInput = By.xpath("(//select[@aria-hidden='true'])[4]");
    private final By currencyInput = By.xpath("(//div[@class='flex w-full items-center justify-between'])[5]");
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
    private final By emailInput = By.cssSelector("#registeredEmail");
    private final By phonenumberText = By.xpath("(//label[normalize-space()='Phone Number'])[1]");
    private final By phonenumberInput = By.cssSelector("#registeredMobileNo");
    private final By pointcontactName = By.xpath("(//label[normalize-space()='Point of Contact Name'])[1]");
    private final By pointcontactInput = By.cssSelector("#contactPersonName");
    private final By pointcontactphoneText = By.xpath("(//label[normalize-space()='Point of Contact Phone Number'])[1]");
    private final By pointcontactphoneInput = By.cssSelector("#contactPersonMobileNo");
    private final By clickNextButton3 = By.xpath("(//button[normalize-space()='Next'])[1]");
    private final By SalesinfoText = By.xpath("(//div[@class='ml-4 text-sm font-medium text-primary'])[1]");
    private final By salesmanagerText = By.xpath("(//label[normalize-space()='Sales Manager'])[1]");
    private final By salesmanagerDropdown = By.xpath("(//div[@class='flex w-full items-center justify-between'])[2]");
    private final By restaurantCategoryText = By.xpath("(//label[normalize-space()='Restaurant Category'])[1]");
    private final By restaurantcategoryDropdown = By.xpath("(//div[@class='flex w-full items-center justify-between'])[3]");
    private final By clicknextbutton4 = By.xpath("(//button[normalize-space()='Next'])[1]");
    private final By paymentinforText = By.xpath("(//div[@class='ml-4 text-sm font-medium text-primary'])[1]");
    private final By Payment_ProviderText = By.cssSelector("label[for='paymentProvider']");
    private final By paymentplatformAccountText = By.cssSelector("label[for='platformAccountId']");
    private final By paymentplatformAccountInput = By.xpath("(//div[@class='flex w-full items-center justify-between'])[3]");
    private final By connectAccountText = By.cssSelector("label[for='connectId']");
    private final By connectAccountInput = By.xpath("(//div[@class='flex w-full items-center justify-between'])[4]");
    private final By clicknextbutton5 = By.xpath("//button[normalize-space()='Next']");
    private final By companyinfoText = By.xpath("//div[@class='ml-4 text-sm font-medium text-primary']");
    private final By nameText = By.xpath("//label[normalize-space()='Name']");
    private final By companynewInput = By.xpath("//input[@id='merchantName']");
    private final By companyStreeText = By.xpath("//label[normalize-space()='Street']");
    private final By companyStreetInput = By.xpath("//input[@id='registeredAddress']");
    private final By countryText = By.xpath("//label[normalize-space()='Country']");
    private final By countryInput = By.xpath("(//div[@class='flex w-full items-center justify-between'])[2]");
    private final By companyCityText = By.xpath("//label[normalize-space()='City']");
    private final By companyCityInput = By.xpath("(//button[contains(@class,'flex') and contains(@class,'flex-col') and contains(@class,'relative')])[3]");
    private final By companypostalCodeText = By.xpath("//label[normalize-space()='Postal Code']");
    private final By companypostalCodeInput = By.xpath("//input[@id='registeredPostalCode']");
    private final By registeredNumberText = By.xpath("//label[normalize-space()='Registration Number (UEN)']");
    private final By registeredNumberInput = By.xpath("//input[@id='registeredNumber']");
    private final By gstNumberText = By.xpath("//label[normalize-space()='GST Number']");
    private final By gstNumberInput = By.xpath("//input[@id='customerGSTNumber']");
    private final By clicknextbutton6 = By.xpath("//button[normalize-space()='Next']");
    private final By clicknextbutton7 = By.xpath("(//button[normalize-space()='Next'])[1]");
    private final By logoverifyText = By.xpath("//div[@class='flex flex-col']//p[@id='']");
    private final By aggrementText = By.xpath("//a[normalize-space()='Agreement']");
    private final By AgreementHeading = By.xpath("//div[@class='flex flex-col justify-en gap-2']//div//p[@id='']");
    private final By clicksubmitCreateButton = By.xpath("(//button[normalize-space()='Submit'])[1]");

/*    private final By togglePOS = By.xpath("//button[contains(@data-testid,'posSwitch')]");
    private final By toggleMobileApp = By.xpath("//button[contains(@data-testid,'dinetapApp')]");
    private final By togglePayments = By.xpath("//button[contains(@data-testid,'payments')]");*/

    public String getRestaurantNameText() {
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return shortWait.until(ExpectedConditions.visibilityOfElementLocated(restaurantName))
                .getText().trim();
    }

    public String getPaymentProviderText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(Payment_Provider))
                .getText().trim();
    }
    public void selectPaymentProvider(String provider) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(payment_providerInput));
        dropdown.click();
        By optionLocator = By.xpath("//div[contains(@class,'option') or @role='option'][normalize-space()='" + provider + "']");
        WebElement optionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
        optionElement.click();
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

    public void selectCountry(String country) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(origcountryInput));
        dropdown.click();
        By optionLocator = By.xpath("//div[contains(@class,'option') or @role='option'][normalize-space()='" + country + "']");
        WebElement optionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
        optionElement.click();
    }

    public String getCityText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cityText))
                .getText().trim();
    }

    public void selectCity(String city) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(cityInput));
        dropdown.click();
        By optionLocator = By.xpath("//div[contains(@class,'option') or @role='option'][normalize-space()='" + city + "']");
        WebElement optionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
        optionElement.click();

    }

    public String getTimezoneText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(timezoneText))
                .getText().trim();
    }

    public void enterTimezone(String timezone) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(timezonedropdown));
        dropdown.click();
        By optionLocator = By.xpath("//div[contains(@class,'option') or @role='option'][normalize-space()='" + timezone + "']");
        WebElement optionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
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

/*    public void enterCurrency(String currency) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(currencyInput));
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(currency);
    }*/
    public void enterCurrency(String currency) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(currencyInput));
        dropdown.click();
        By optionLocator = By.xpath("//div[contains(@class,'option') or @role='option'][normalize-space()='" + currency + "']");
        WebElement optionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
        optionElement.click();
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
        // Wait for and focus the input field
        WebElement locationInput = wait.until(ExpectedConditions.visibilityOfElementLocated(insertLocation));
        locationInput.clear();

        // Type letter-by-letter with a slight delay
        for (char c : location.toCharArray()) {
            locationInput.sendKeys(Character.toString(c));
            try {
                Thread.sleep(50); // 100ms delay between keystrokes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Now wait for the suggestion dropdown to load and be clickable
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(8));
        WebElement suggestion = shortWait.until(ExpectedConditions.elementToBeClickable(firstSuggestion));

        // Click the first suggestion
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
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(clickNextButton2));
        // Scroll the button into view again (in case it was pushed out)
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        // Small wait to stabilize UI (if there's animation/transition)
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Wait until clickable and then click
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
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

    public void clickNextButton3() {
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement element = shortWait.until(ExpectedConditions.elementToBeClickable(clickNextButton3));
        element.click();
    }

    public String getSalesinfoText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(SalesinfoText))
                .getText().trim();
    }

    public String getSalesmanagerText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(salesmanagerText))
                .getText().trim();
    }

    public void selectSalesManager(String salesManager) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(salesmanagerDropdown));
        dropdown.click();

        // Wait for the option to appear
        By optionLocator = By.xpath("//div[contains(@class,'option') or @role='option'][normalize-space()='" + salesManager + "']");
        WebElement optionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));

        // Scroll into view and click
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
        optionElement.click();
    }


    public String getRestaurantCategoryText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(restaurantCategoryText))
                .getText().trim();
    }

    public void selectRestaurantCategory(String category) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(restaurantcategoryDropdown));
        dropdown.click();

        // Wait for options to be visible
        By optionLocator = By.xpath("//div[contains(@class,'option') or @role='option'][normalize-space()='" + category + "']");
        WebElement optionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));

        // Scroll to the option and click it
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
        optionElement.click();
    }

    public void clickNextButton4() {
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement element = shortWait.until(ExpectedConditions.elementToBeClickable(clicknextbutton4));
        element.click();
    }

    public String getPaymentInfoText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(paymentinforText))
                .getText().trim();
    }

    public String getPaymentProviderTxt() {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(Payment_ProviderText))
                    .getText().trim();
    }

    public String getPaymentPlatformAccountText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(paymentplatformAccountText))
                .getText().trim();
    }

    public void enterPaymentPlatformAccount(String account) {

/*        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(4));
        WebElement dropdown = shortWait.until(ExpectedConditions.elementToBeClickable(paymentplatformAccountInput));
        dropdown.click();
        By optionLocator = By.xpath("//div[contains(@class,'option') or @role='option'][normalize-space()='" + account + "']");
        WebElement optionElement = shortWait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
        optionElement.click();

/*        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(paymentplatformAccountInput));
        dropdown.click();
        By optionsContainer = By.xpath("//div[contains(@class,'option') or @role='option']");
        wait.until(ExpectedConditions.presenceOfElementLocated(optionsContainer));
        By optionLocator = By.xpath("//div[contains(@class,'option') or @role='option'][normalize-space()='" + account + "']");
        WebElement optionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
        optionElement.click();*/
    }


    public String getConnectAccountText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(connectAccountText))
                .getText().trim();
    }

    public void enterConnectAccount(String connectAccount) {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(connectAccountInput));
        dropdown.click();
        By optionLocator = By.xpath("//div[contains(@class,'option') or @role='option'][normalize-space()='" + connectAccount + "']");
        WebElement optionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
        optionElement.click();
    }

    public void clickNextButton5() {
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement element = shortWait.until(ExpectedConditions.elementToBeClickable(clicknextbutton5));
        element.click();
    }

    public String getCompanyInfoText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(companyinfoText))
                .getText().trim();
    }

    public String getcompanyNameText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(nameText))
                .getText().trim();
    }

    public void enterCompanyName(String companyName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(companynewInput)).sendKeys(companyName);
    }

    public String getCompanyStreetText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(companyStreeText))
                .getText().trim();
    }

    public void enterCompanyStreet(String companyStreet) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(companyStreetInput)).sendKeys(companyStreet);
    }

    public String getCompanyCountryText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(countryText))
                .getText().trim();
    }

    public void selectCompanyCountry(String country) {
       WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(countryInput));
        dropdown.click();
        By optionLocator = By.xpath("//div[contains(@class,'option') or @role='option'][normalize-space()='" + country + "']");
        WebElement optionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
        optionElement.click();
    }

    public String getCompanyCityText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(companyCityText))
                .getText().trim();
    }

    public void selectCompanyCity(String city) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(companyCityInput));
        dropdown.click();
        By optionLocator = By.xpath("//div[contains(@class,'option') or @role='option'][normalize-space()='" + city + "']");
        WebElement optionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
        optionElement.click();
    }

    public String getCompanyPostalCodeText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(companypostalCodeText))
                .getText().trim();
    }

    public void enterCompanyPostalCode(String postalCode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(companypostalCodeInput)).sendKeys(postalCode);
    }

    public String getRegisteredNumberText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(registeredNumberText))
                .getText().trim();
    }

    public void enterRegisteredNumber(String registeredNumber) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(registeredNumberInput)).sendKeys(registeredNumber);
    }

    public String getGstNumberText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(gstNumberText))
                .getText().trim();
    }

    public void enterGstNumber(String gstNumber) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(gstNumberInput)).sendKeys(gstNumber);
    }
    public void clickNextButton6() {
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement element = shortWait.until(ExpectedConditions.elementToBeClickable(clicknextbutton6));
        element.click();
    }

/*    private final By togglePOS = By.xpath("//button[contains(@data-testid,'posSwitch')]");
    public void enablePOSToggle() {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement toggle = shortWait.until(ExpectedConditions.presenceOfElementLocated(togglePOS));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", toggle);

            // Get toggle state
            String state = toggle.getAttribute("aria-checked");
            if ("false".equalsIgnoreCase(state)) {
                shortWait.until(ExpectedConditions.elementToBeClickable(toggle)).click();
                System.out.println("✅ POS toggle enabled.");
            } else {
                System.out.println("✅ POS toggle already enabled.");
            }

        } catch (Exception e) {
            throw new RuntimeException("❌ POS toggle was not clickable or not found in time.", e);
        }
    }*/

    public void scrollToElementJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);
    }

    public void enableToggleIfRequired(String toggleTestId, String value) {
        if (value.equalsIgnoreCase("Yes")) {
            By toggle = By.xpath("//button[contains(@data-testid,'" + toggleTestId + "')]");
            try {
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(toggle));
                if (!element.getAttribute("aria-checked").equals("true")) {
                    scrollToElementJS(element);
                    element.click();
                    System.out.println("Enabled toggle: " + toggleTestId);
                } else {
                    System.out.println("ℹToggle already enabled: " + toggleTestId);
                }
            } catch (Exception e) {
                throw new RuntimeException("Toggle '" + toggleTestId + "' not found or not clickable.");
            }
        } else {
            System.out.println("Skipping toggle: " + toggleTestId + " (Value: " + value + ")");
        }
    }

    public void clickNextButton7() {
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement element = shortWait.until(ExpectedConditions.elementToBeClickable(clicknextbutton7));
        element.click();
    }

    public String getLogoVerifyText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logoverifyText))
                .getText().trim();
    }

    public String getAgreementText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(aggrementText))
                .getText().trim();
    }

    public String getAgreementHeadingText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(AgreementHeading))
                .getText().trim();
    }

    public void clickSubmitCreateButton() {
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(4));
        WebElement element = shortWait.until(ExpectedConditions.elementToBeClickable(clicksubmitCreateButton));
        element.click();
    }


    public void validateRestaurantPageHeaders(SoftAssert softAssert) {
        softAssert.assertEquals(getRestaurantNameText(), "Restaurants", "❌ Header text mismatch!");
        softAssert.assertEquals(getPaymentProviderText(), "Payment Provider", "❌ Payment Provider label mismatch");
        softAssert.assertEquals(getStatusText(), "Status", "❌ Status label mismatch");
    }

}