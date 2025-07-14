package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class systemVariablepage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public systemVariablepage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.actions = new Actions(driver);
    }

    // Navigation Link
    private final By systemVariablelink = By.xpath("//span[normalize-space()='System Variables']");

    // Dropdown & Options
    private final By productTypeDropdown = By.xpath("(//div[@aria-label='Select Product Types'])[1]");
    private final By optionPOS = By.xpath("(//div[@class='flex items-center gap-2'][normalize-space()='POS'])[1]");
    private final By optionDinetapApp = By.xpath("(//div[@class='flex items-center gap-2'][normalize-space()='Dinetap App'])[1]");
    private final By optionPayments = By.xpath("(//div[@class='flex items-center gap-2'][normalize-space()='Payments'])[1]");
    private final By optionLegacy = By.xpath("(//div[@class='flex items-center gap-2'][normalize-space()='Legacy'])[1]");

    // Page Headers & Labels
    private final By headerSystemVariables = By.xpath("(//h1[normalize-space()='System Variables'])[1]");
    private final By labelProductTypes = By.xpath("(//label[normalize-space()='Product Types'])[1]");

    // Create Form Elements
    private final By btnNewSystemVariable = By.xpath("(//span[@class='pl-2.5'])[1]");
    private final By headerNewSystemVariable = By.xpath("(//h2[normalize-space()='New System Variable'])[1]");
    private final By labelKey = By.xpath("(//label[normalize-space()='Key'])[1]");
    private final By inputKey = By.xpath("//label[normalize-space()='Key']/following::input[1]");
    private final By labelDescription = By.xpath("(//label[normalize-space()='Description'])[1]");
    private final By inputDescription = By.xpath("//label[normalize-space()='Description']/following::input[1]");
    private final By labelType = By.xpath("(//label[normalize-space()='Type'])[1]");
    private final By dropdownType = By.xpath("(//div[@class='flex w-full items-center justify-between'])[3]");
    private final By dropdownOptionPOS = By.xpath("(//div[@role='option'])[1]");

    private final By dropdownOptionDinetapApp = By.xpath("(//div[@role='option'])[2]");

    private final By dropdownOptionPayments = By.xpath("(//div[@role='option'])[3]");


    private final By labelValue = By.xpath("(//label[normalize-space()='Value'])[1]");
    private final By inputValue = By.xpath("//label[normalize-space()='Value']/following::input[1]");
    private final By btnCreate = By.xpath("(//button[normalize-space()='Create'])[1]");

    // Navigation
    public void clickSystemVariablelink() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(systemVariablelink));
        actions.moveToElement(element).click().perform();
        System.out.println("✅ Clicked on System Variables navigation link using mouse action.");
    }

    // Dropdown Verification
    public WebElement getHeaderSystemVariables() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(headerSystemVariables));
    }

    public WebElement getLabelProductTypes() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(labelProductTypes));
    }

    public void openProductTypeDropdown() {
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(productTypeDropdown));
        actions.moveToElement(dropdown).click().perform();
    }

    public WebElement getOptionPOS() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(optionPOS));
    }

    public WebElement getOptionDinetapApp() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(optionDinetapApp));
    }

    public WebElement getOptionPayments() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(optionPayments));
    }

    public WebElement getOptionLegacy() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(optionLegacy));
    }

    // Form Methods
    public void clickNewSystemVariableButton() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(btnNewSystemVariable));
        actions.moveToElement(btn).click().perform();
        System.out.println("✅ Clicked New System Variable button");
    }

    public String getFormHeading() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(headerNewSystemVariable)).getText().trim();
    }

    public String getKeyLabel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(labelKey)).getText().trim();
    }

    public void enterKey(String key) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(inputKey));
        input.clear();
        input.sendKeys(key);
    }
    public String getDescriptionLabel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(labelDescription)).getText().trim();
    }

    public void enterDescription(String description) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(inputDescription));
        input.clear();
        input.sendKeys(description);
    }

    public String getTypeLabel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(labelType)).getText().trim();
    }

    public void selectType(String type) {
        // Click to open the dropdown
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownType));
        actions.moveToElement(dropdown).click().perform();

        // Select based on dynamic dropdown order
        switch (type.trim().toLowerCase()) {
            case "pos":
                WebElement pos = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownOptionPOS));
                actions.moveToElement(pos).click().perform();
                break;
            case "dinetap app":
                WebElement dtApp = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownOptionDinetapApp));
                actions.moveToElement(dtApp).click().perform();
                break;
            case "payments":
                WebElement payments = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownOptionPayments));
                actions.moveToElement(payments).click().perform();
                break;
            default:
                throw new IllegalArgumentException("Invalid product type: " + type);
        }

        System.out.println("✅ Selected product type: " + type);
    }


    public String getValueLabel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(labelValue)).getText().trim();
    }


    public void enterValue(String value) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(inputValue));
        input.clear();
        input.sendKeys(value);
    }

    public void clickCreateButton() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(btnCreate));
        btn.click();
        System.out.println("✅ Submitted New System Variable form");
    }
}
