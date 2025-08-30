package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.Buffer;
import java.time.Duration;

public class UserPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    public UserPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }
    // Locators
    private final By usersMenuLink = By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div[2]/div[1]/div/div/div/ul/li[3]/a");
    private final By usersheaderText = By.xpath("//h1[normalize-space()='Users']");
    private final By countryText = By.xpath("//label[normalize-space()='Countries']");
    private final By statusText = By.xpath("//label[normalize-space()='Status']");
    private final By roleText = By.xpath("//label[normalize-space()='Roles']");
    private final By newUserButton = By.xpath("/html/body/div[1]/div[2]/div[2]/main/div/div[2]/div/div[1]/div[1]/div[2]/button");
    private final By newUserHeadingText = By.xpath("(//h2[normalize-space()='New User'])[1]");
    private final By usernameText = By.xpath("(//label[normalize-space()='Name'])[1]");
    private final By emailText = By.xpath("(//label[normalize-space()='Email'])[1]");
    private final By rolesText = By.xpath("(//label[@for=':rgb:-form-item'])[1]");
    private final By phoneNumber = By.xpath("(//label[normalize-space()='Phone Number'])[1]");
    private final By countriesText = By.xpath("(//label[@for=':rgf:-form-item'])[1]");
    private final By passwordText = By.xpath("(//label[normalize-space()='Password'])[1]");
    private final By nameInput = By.xpath("//label[contains(text(),'Name')]/following::input[1]");
    private final By emailInput = By.xpath("//label[contains(text(),'Email')]/following::input[1]");
    private final By phoneInput = By.xpath("//label[contains(text(),'Phone Number')]/following::input[1]");
    private final By passwordInput = By.xpath("//input[@placeholder='E.g: ••••••••••']");
    private final By createButton = By.xpath("//button[normalize-space()='Create']");
    private final By countryDropdown = By.xpath("(//div[contains(@aria-label,'Select')])[5]");
    private final By singaporeOption = By.xpath("//div[@role='option' and normalize-space()='Singapore']");
    private final By australiaOption = By.xpath("//div[@role='option' and normalize-space()='Australia']");
    private final By roleDropdown = By.xpath("(//div[contains(@aria-label,'Select')])[4]");
    private final By failedusercreation = By.xpath(" (//div[@class='text-lg font-semibold'])[1]");
    private String roleOptionXpath(String role) {
        return "(//div[@class='flex items-center gap-2'][normalize-space()='" + role + "'])[1]";
    }
    private final By closeModalButton = By.xpath("//button[contains(@class, 'absolute') and @aria-label='Close']");
    private final By backdrop = By.xpath("//div[contains(@class, 'bg-black') and contains(@class,'fixed')]");
    // Actions
    public void openUsersPage() {
        wait.until(ExpectedConditions.elementToBeClickable(usersMenuLink)).click();
    }

    public String getUsersHeaderText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(usersheaderText)).getText();
    }

    public String getCountryText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(countryText)).getText();
    }

    public String getStatusText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(statusText)).getText();
    }

    public String getRoleText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(roleText)).getText();
    }

    public void clickNewUser() {
        wait.until(ExpectedConditions.elementToBeClickable(newUserButton)).click();
        try {
            Thread.sleep(2000); // Wait for modal to appear
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getNewUserHeadingText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(newUserHeadingText)).getText();
    }
    public String getUsernameText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(usernameText)).getText();
    }

    public void fillName(String name) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(nameInput));
        input.clear();
        input.sendKeys(name);
    }

    public String getEmailText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailText)).getText();
    }

    public void fillEmail(String email) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        input.clear();
        input.sendKeys(email);
    }

    public String getPhoneNumberText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumber)).getText();
    }

    public void fillPhone(String phone) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneInput));
        input.clear();
        input.sendKeys(phone);
    }

    public String getPasswordText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordText)).getText();
    }
    public void fillPassword(String password) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        input.clear();
        input.sendKeys(password);
    }
/*
        public void selectCountry(String country) {
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(countryDropdown));
            dropdown.click();
            if (country.equalsIgnoreCase("Singapore")) {
                wait.until(ExpectedConditions.visibilityOfElementLocated(singaporeOption)).click();
            } else if (country.equalsIgnoreCase("Australia")) {
                wait.until(ExpectedConditions.visibilityOfElementLocated(australiaOption)).click();
            }
        }*/

    public String getcountrytext() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(countriesText)).getText();
    }

    public void selectCountry(String country) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(countryDropdown));
        actions.moveToElement(dropdown).click().perform(); // simulate mouse click

        if (country.equalsIgnoreCase("Singapore")) {
            WebElement sgOption = wait.until(ExpectedConditions.visibilityOfElementLocated(singaporeOption));
            actions.moveToElement(sgOption).click().perform();
        } else if (country.equalsIgnoreCase("Australia")) {
            WebElement auOption = wait.until(ExpectedConditions.visibilityOfElementLocated(australiaOption));
            actions.moveToElement(auOption).click().perform();
        }
    }

    public String getRolesText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(rolesText)).getText();
    }
    public void selectRoles(String roles) {
        String[] roleList = roles.split(",");
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(roleDropdown));
        actions.moveToElement(dropdown).click().perform();

        for (String role : roleList) {
            String trimmed = role.trim();
            By option = By.xpath(roleOptionXpath(trimmed));
            WebElement roleOption = wait.until(ExpectedConditions.elementToBeClickable(option));
            actions.moveToElement(roleOption).click().perform();
        }
    }

/*    public void selectRoles(String roles) {
        String[] roleList = roles.split(",");
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(roleDropdown));
        dropdown.click();
        for (String role : roleList) {
            String trimmed = role.trim();
            By option = By.xpath(roleOptionXpath(trimmed));
            wait.until(ExpectedConditions.elementToBeClickable(option)).click();
        }
    }*/

    public void clickCreate() {
        wait.until(ExpectedConditions.elementToBeClickable(createButton)).click();
    }

    public boolean isBadRequestPopupPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(failedusercreation));
            return element.isDisplayed();
        } catch (Exception e) {
            return false; // popup not present
        }
    }

    public String getBadRequestText() {
        try {
            return driver.findElement(failedusercreation).getText().trim();
        } catch (Exception e) {
            return "";
        }
    }
    public void closeModalIfOpen() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(closeModalButton)).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(backdrop));
        } catch (Exception e) {
            System.out.println("Modal already closed or not present.");
        }
    }
}