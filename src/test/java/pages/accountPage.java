package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class accountPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    // Constructor initializes WebDriverWait and Actions
    public accountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    // Locators
    private final By systemAccountlinkbutton = By.xpath("//span[normalize-space()='Accounts']");
    private final By headerAccount = By.xpath("(//h1[normalize-space()='Accounts'])[1]");
    private final By clickButton = By.xpath("(//button[normalize-space()='New Account'])[1]");
    private final By cancelButtonone = By.xpath("(//button[normalize-space()='Cancel'])[1]");
    private final By cancelButtonText = By.xpath("(//p[contains(text(),'Are you sure you want to cancel this account creat')])[1]");
    private final By getCancelButtontwo = By.xpath("(//button[normalize-space()='Yes, Cancel'])[1]");
    private final By CreateTexttwo = By.xpath("(//h1[normalize-space()='Accounts'])[1]");
    private final By legalText = By.xpath("(//div[@class='ml-4 text-sm font-medium text-primary'])[1]");
    //accountform
    private final By accountNameText = By.xpath("(//label[normalize-space()='Name'])[1]");
    private final By accountNextInput = By.xpath("(//input[@id='name'])[1]");

    private final By registrationNumber = By.xpath("(//label[normalize-space()='Registration Number (UEN)'])[1]");
    private final By registrationNumberInput = By.xpath("(//input[@id='registeredNumber'])[1]");

    private final By GSTNumber = By.xpath("(//label[normalize-space()='GST Number'])[1]");
    private final By GSTNumberInput = By.xpath("(//input[@id='customerGSTNumber'])[1]");

    private final By citytext = By.xpath("(//label[normalize-space()='City'])[1]");
    private final By cityDropdown = By.xpath("(//select[@name='cityId'])[1]");
//    private final String cityOptionXPath = "//div[contains(@class,'select-content')]//div[normalize-space()='%s']";
    private final By streetNameText = By.xpath("(//label[normalize-space()='Street Name'])[1]");
    private final By streetNameInput = By.xpath("(//input[@id='street'])[1]");
    private final By postalCodeText = By.xpath("(//label[normalize-space()='Postal Code'])[1]");
    private final By postalCodeInput = By.xpath("(//input[@id='postalCode'])[1]");
    private final By websiteText = By.xpath("(//label[normalize-space()='Website'])[1]");
    private final By websiteInput = By.xpath("(//input[@id='websiteUrl'])[1]");
    private final By clickNextButton = By.xpath("(//button[normalize-space()='Next'])[1]");

    //Restaurant page
    private final By RestaurantText = By.xpath("(//div[@class='ml-4 text-sm font-medium text-primary'])[1]");

    private final By nameText = By.xpath("(//label[normalize-space()='Name'])[1]");
    private final By nameInput = By.xpath("(//input[@id='name'])[1]");

    private final By ShopperStatementtext = By.xpath("(//label[normalize-space()='Shopper Statement'])[1]");
    private final By ShopperStatementInput = By.xpath("(//input[@id='shopperStatement'])[1]");
    private final By CountryText = By.xpath("(//label[normalize-space()='Country'])[1]");
    private final By CitynewText = By.xpath("(//label[normalize-space()='City'])[1]");
    private final By streetText = By.xpath("(//label[normalize-space()='Street Name'])[1]");
    private final By postalcodetext = By.xpath("(//label[normalize-space()='Postal Code'])[1]");

    private final By Currency = By.xpath("(//label[normalize-space()='Currency'])[1]");
    private final By CurrencyInput = By.xpath("(//select[@name='posCurrency'])[1]");
    private final By timeZonetext = By.xpath("(//label[normalize-space()='Time Zone'])[1]");
    private final By owneremailtext = By.xpath("(//label[normalize-space()='Owner Email'])[1]");
    private final By owneremailInput = By.xpath("(//input[@id='registeredEmail'])[1]");
    private final By resphonenumbertext = By.xpath("(//label[normalize-space()='Restaurant Phone Number'])[1]");
    private final By resphoneinput = By.xpath("(//input[@id='registeredMobileNo'])[1]");


    // Actions
    public void clickSystemAccountLink() {
        actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(systemAccountlinkbutton)))
                .click().perform();
    }
    public String getHeaderAccountText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(headerAccount))
                .getText().trim();
    }

    public void clickAccountButton() {
        actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(clickButton)))
                .click().perform();
    }

    public void clickCancelButton() {
        actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(cancelButtonone)))
                .click().perform();
    }

    public String getCancelButtonText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cancelButtonText))
                .getText().trim();
    }

    public void clickCancelButtonTwo() {
        actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(getCancelButtontwo)))
                .click().perform();
    }

    public String getCreateTextTwo() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(CreateTexttwo))
                .getText().trim();
    }

    public String getLegalText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(legalText))
                .getText().trim();
    }

    public String getAccountNameText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(accountNameText))
                .getText().trim();
    }
    public void enterAccountName(String accountName) {
        WebElement accountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(accountNextInput));
        accountInput.clear();
        accountInput.sendKeys(accountName);
    }


    public String getRegistrationNumberText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(registrationNumber))
                .getText().trim();
    }

    public void enterRegistrationNumber(String registrationNumber) {
        WebElement regInput = wait.until(ExpectedConditions.visibilityOfElementLocated(registrationNumberInput));
        regInput.clear();
        regInput.sendKeys(registrationNumber);
    }

    public String gstNumberText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(GSTNumber))
                .getText().trim();
    }

    public void enterGSTNumber(String gstNumber) {
        WebElement gstInput = wait.until(ExpectedConditions.visibilityOfElementLocated(GSTNumberInput));
        gstInput.clear();
        gstInput.sendKeys(gstNumber);
    }

    public String getCityText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(citytext))
                .getText().trim();
    }
    public void selectCity(String cityName) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(cityDropdown));
        Select select = new Select(dropdown);
        select.selectByVisibleText(cityName);
    }

    public String getStreetNameText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(streetNameText))
                .getText().trim();
    }
    public void enterStreetName(String streetName) {
        WebElement streetInput = wait.until(ExpectedConditions.visibilityOfElementLocated(streetNameInput));
        streetInput.clear();
        streetInput.sendKeys(streetName);
    }

    public String getPostalCodeText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeText))
                .getText().trim();
    }

    public void enterPostalCode(String postalCode) {
        WebElement postalInput = wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeInput));
        postalInput.clear();
        postalInput.sendKeys(postalCode);
    }

    public String getWebsiteText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(websiteText))
                .getText().trim();
    }

    public void enterWebsite(String website) {
        WebElement websiteInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(websiteInput));
        websiteInputField.clear();
        websiteInputField.sendKeys(website);
    }

    public void clickNextButton() {
        actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(clickNextButton)))
                .click().perform();
    }

    public String getRestaurantText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(RestaurantText))
                .getText().trim();
    }

    public String getNameText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(nameText))
                .getText().trim();
    }

    public void enterName(String name) {
        WebElement nameInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(nameInput));
        nameInputField.clear();
        nameInputField.sendKeys(name);
    }

    public String getShopperStatementText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ShopperStatementtext))
                .getText().trim();
    }

    public void enterShopperStatement(String statement) {
        WebElement statementInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(ShopperStatementInput));
        statementInputField.clear();
        statementInputField.sendKeys(statement);
    }

    public String getCountryText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(CountryText))
                .getText().trim();
    }

    public String getCityNewText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(CitynewText))
                .getText().trim();
    }

    public String getStreetText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(streetText))
                .getText().trim();
    }

    public String getPostalCodeTextNew() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(postalcodetext))
                .getText().trim();
    }

    public String getCurrencyText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(Currency))
                .getText().trim();
    }

    public void selectCurrency(String currency) {
        WebElement currencyDropdown = wait.until(ExpectedConditions.elementToBeClickable(CurrencyInput));
        Select select = new Select(currencyDropdown);
        select.selectByVisibleText(currency);
    }

    public String getTimeZoneText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(timeZonetext))
                .getText().trim();
    }

    public String getOwnerEmailText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(owneremailtext))
                .getText().trim();
    }

    public void enterOwnerEmail(String email) {
        WebElement emailInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(owneremailInput));
        emailInputField.clear();
        emailInputField.sendKeys(email);
    }

    public String getRestaurantPhoneNumberText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(resphonenumbertext))
                .getText().trim();
    }

    public void enterRestaurantPhoneNumber(String phoneNumber) {
        WebElement phoneInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(resphoneinput));
        phoneInputField.clear();
        phoneInputField.sendKeys(phoneNumber);
    }


}
