package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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

    private final By organizationTypeText = By.xpath("(//label[normalize-space()='Organization Type'])[1]");
    private final By organizationTypeDropdown = By.xpath("(//select[@aria-hidden='true'])[2]");

    private final By citytext = By.xpath("(//label[normalize-space()='City'])[1]");

    private final By checkdefaultcity = By.xpath("(//span[@class='block truncate'][normalize-space()='Singapore'])[2]");
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

    private final By timeZonetext = By.xpath("(//label[normalize-space()='Time Zone'])[1]");
    private final By owneremailtext = By.xpath("(//label[normalize-space()='Owner Email'])[1]");
    private final By owneremailInput = By.xpath("(//input[@id='registeredEmail'])[1]");
    private final By resphonenumbertext = By.xpath("(//label[normalize-space()='Restaurant Phone Number'])[1]");
    private final By resphoneinput = By.xpath("(//input[@id='registeredMobileNo'])[1]");

    private final By clicksecnextbutn = By.xpath("(//button[normalize-space()='Next'])[1]");

    private final By pointofcontact = By.xpath("(//label[normalize-space()='Point of Contact Name'])[1]");
    private final By pointofcontactInput = By.xpath("(//input[@id='contactPersonName'])[1]");

    private final By pointofcontactnumber = By.xpath("(//label[normalize-space()='Point of Contact Phone Number'])[1]");
    private final By pointofcontactnumberInput = By.xpath("(//input[@id='contactPersonMobileNo'])[1]");
    private final By salesmanager = By.xpath("(//label[normalize-space()='Sales Manager'])[1]");

    private final By clickDropdown = By.xpath("(//div[@class='flex w-full items-center justify-between'])[2]");
//    private final By salesmanagerdropdown = By.xpath("//select[@name='salesManagerId']");
    private final By salesManagerSelect = By.xpath("//select[@name='salesManagerId']");
    private final By ClickSubmitButton = By.xpath("(//button[normalize-space()='Submit'])[1]");
    private final By settingAccount = By.xpath("(//h2[normalize-space()='Setting Up Your Account'])[1]");
    private final By Intializing = By.xpath("(//span[normalize-space()='Initializing'])[1]");
    private final By createinglegal = By.xpath("(//span[normalize-space()='Creating Legal Entity'])[1]");
    private final By creatingaccount = By.xpath("(//span[normalize-space()='Creating Account Holder'])[1]");
    private final By creatingaccountbalance = By.xpath("(//span[normalize-space()='Creating Balance Account'])[1]");
    private final By buisnesslines = By.xpath("(//span[normalize-space()='Creating Business Lines'])[1]");
    private final By Creatingstore = By.xpath("(//span[normalize-space()='Creating Store'])[1]");
    private final By creatingpaymentMethod = By.xpath("(//span[normalize-space()='Creating Payment Methods'])[1]");
    private final By creatingRestaurant = By.xpath("(//span[normalize-space()='Creating Restaurant'])[1]");
    private final By sendingownerinvite = By.xpath("(//span[normalize-space()='Sending Owner Invitation'])[1]");

    private final By popuptext = By.xpath("(//p[@class='text-muted-foreground text-sm font-light'])[1]");
    private final By linkexpire = By.xpath("(//p[@class='text-sm pt-2'])[1]");

    private final By okaybutton = By.xpath("(//button[normalize-space()='Okay'])[1]");

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

    public String getOrganizationTypeText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(organizationTypeText))
                .getText().trim();
    }

    public void selectOrganizationType(String organizationType) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(organizationTypeDropdown));
        Select select = new Select(dropdown);
        select.selectByVisibleText(organizationType);
    }

    public String getCityText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(citytext))
                .getText().trim();
    }

    public String getCheckDefaultCity() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(checkdefaultcity))
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
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(clickNextButton));
        nextBtn.click();
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

    public void clickSecondNextButton() {
        actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(clicksecnextbutn)))
                .click().perform();
    }

    public String getPointOfContactText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pointofcontact))
                .getText().trim();
    }

    public void enterPointOfContact(String contactName) {
        WebElement contactInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(pointofcontactInput));
        contactInputField.clear();
        contactInputField.sendKeys(contactName);
    }

    public String getPointOfContactNumberText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pointofcontactnumber))
                .getText().trim();
    }

    public void enterPointOfContactNumber(String contactNumber) {
        WebElement contactNumberInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(pointofcontactnumberInput));
        contactNumberInputField.clear();
        contactNumberInputField.sendKeys(contactNumber);
    }

    public String getSalesManagerText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(salesmanager))
                .getText().trim();
    }

    public void selectSalesManager(String managerName) {
        try {
            // 🔄 Wait for loader to complete — hard wait (can be replaced with smart loader wait later)
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // ✅ Wait until the <select> element is present and interactable
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(salesManagerSelect));

        // ✅ Now select by visible text using Selenium's Select
        Select select = new Select(dropdown);
        select.selectByVisibleText(managerName);
    }

    public void clickSubmitButton() {
        actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(ClickSubmitButton)))
                .click().perform();
    }


    public String getSettingAccountText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(settingAccount))
                .getText().trim();
    }

    public String getInitializingText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(Intializing))
                .getText().trim();
    }

    public String getCreatingLegalText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(createinglegal))
                .getText().trim();
    }

    public String getCreatingAccountText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(creatingaccount))
                .getText().trim();
    }

    public String getCreatingAccountBalanceText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(creatingaccountbalance))
                .getText().trim();
    }

    public String getBusinessLinesText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(buisnesslines))
                .getText().trim();
    }

    public String getCreatingStoreText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(Creatingstore))
                .getText().trim();
    }

    public String getCreatingPaymentMethodText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(creatingpaymentMethod))
                .getText().trim();
    }

    public String getCreatingRestaurantText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(creatingRestaurant))
                .getText().trim();
    }

    public String getSendingOwnerInviteText() {
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(sendingownerinvite))
                .getText().trim();

        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return text;
    }

    public String getPopupText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(popuptext))
                .getText().trim();
    }

    public String getLinkExpireText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(linkexpire))
                .getText().trim();
    }


    public void clickOkayButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement okBtn = wait.until(ExpectedConditions.elementToBeClickable(okaybutton));
            try {
                // First try regular click
                okBtn.click();
            } catch (Exception e) {
                // Fallback to JS click if normal click fails
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", okBtn);
            }
            System.out.println("✅ Clicked OK button");
        } catch (Exception ex) {
            System.out.println("❌ Failed to click OK button: " + ex.getMessage());
            Assert.fail("OK button click failed.");
        }
    }


}
