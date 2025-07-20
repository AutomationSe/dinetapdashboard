package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class accountPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public accountPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        this.driver = driver;
        this.wait = wait;
        this.actions = actions;
    }

    private final By systemAccountlink = By.xpath("//span[normalize-space()='Accounts']");

    // Page Headers & Labels
    private final By headerAccount = By.xpath("(//h1[normalize-space()='System Variables'])[1]");
    private final By statusAccountTypes = By.xpath("(//label[normalize-space()='Product Types'])[1]");
    private final By clickNewAccount = By.xpath("(//button[normalize-space()='New Account'])[1]");
    private final By nameLabel = By.xpath("(//label[normalize-space()='Name'])[1]");
    private final By nameInput = By.xpath("//label[normalize-space()='Name']/following::input[1]");
    private final By nameverification = By.xpath("(//p[@id=':r2eh:-form-item-description'])[1]");
    private final By typeLabel = By.xpath("(//label[normalize-space()='Type'])[1]");
    private final By typeDropdown = By.xpath("(//div[@class='flex w-full items-center justify-between'])[2]");
    private final By Registrationlabel = By.xpath("(//label[normalize-space()='Registration Number (UEN)'])[1]");
    private final By registrationInput = By.xpath("(//input[@id='registeredNumber'])[1]");
    private final By gstLabel = By.xpath("(//label[normalize-space()='GST Number'])[1]");
    private final By gstInput = By.xpath("(//input[@id='customerGSTNumber'])[1]");
    private final By organizationLabel = By.xpath("(//label[normalize-space()='Organization Type'])[1]");
    private final By organizationInput = By.xpath("(//div[@class='flex w-full items-center justify-between'])[3]");
    private final By CountryLabel = By.xpath("(//label[normalize-space()='Country'])[1]");
    private final By CountryInput = By.xpath("(//div[@class='flex w-full items-center justify-between'])[4]");
    private final By StreetLabel = By.xpath("(//label[normalize-space()='Street Name'])[1]");
    private final By StreetInput = By.xpath("(//input[@id='street'])[1]");
    private final By PostalLabel = By.xpath("(//label[normalize-space()='Postal Code'])[1]");
    private final By PostalInput = By.xpath("(//input[@id='postalCode'])[1]");
    private final By WebsiteLabel = By.xpath("(//label[normalize-space()='Website'])[1]");
    private final By WebsiteInput = By.xpath("(//input[@id='websiteUrl'])[1]");
//    Click next button
    private final By clickNext = By.xpath("(//button[normalize-space()='Next'])[1]");
//

    private final By ResnameLabel = By.xpath("(//label[normalize-space()='Name'])[1]");
    private final By ResnameInput = By.xpath("//label[normalize-space()='Name']/following::input[1]");
    private final By Restaurant_CategoryLabel = By.xpath("(//label[normalize-space()='Restaurant Category'])[1]");
    private final By IndustryCodeLabel = By.xpath("(//label[normalize-space()='Industry Code'])[1]");
    private final By shopperstatementLabel = By.xpath("(//label[normalize-space()='Shopper Statement'])[1]");
    private final By shopperstatementinput = By.xpath("(//input[@id='shopperStatement'])[1]");

    private final By Owner_EmailLabel = By.xpath("(//label[normalize-space()='Owner Email'])[1]");
    private final By Owner_Emailinput = By.xpath("(//input[@id='registeredEmail'])[1]");

    private final By PhoneLabel = By.xpath("(//label[normalize-space()='Restaurant Phone Number'])[1]");
    private final By Phoneinput = By.xpath("(//input[@id='registeredMobileNo'])[1]");

    private final By Contact_Name = By.xpath("(//label[normalize-space()='Point of Contact Name'])[1]");
    private final By Contact_Nameinput = By.xpath("(//input[@id='contactPersonName'])[1]");

    private final By contactPhoneNumberlabel = By.xpath("(//label[normalize-space()='Point of Contact Phone Number'])[1]");
    private final By contactPhoneNumberInput = By.xpath("(//input[@id='contactPersonMobileNo'])[1]");

    private final By contactSalesManager = By.xpath("(//label[normalize-space()='Sales Manager'])[1]");
    private final By SalesManagerInput = By.xpath("(//div[@class='flex w-full items-center justify-between'])[2]");

    private final By clickSubmit = By.xpath("(//button[normalize-space()='Submit'])[1]");

}