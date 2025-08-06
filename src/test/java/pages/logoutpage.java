package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class logoutpage {
    private WebDriver driver;
    private WebDriverWait wait;

    public logoutpage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private final By profileButton = By.xpath("//button[@id='radix-:r9:']");
    private final By logoutMenuItem = By.xpath("//div[normalize-space()='Logout']");
    private final By username = By.cssSelector(".text-sm.font-medium.leading-none");
    private final By emailaddress = By.cssSelector(".text-xs.leading-none.text-muted-foreground");
    private final By userRoles = By.cssSelector(".px-3.py-1.bg-emg-primary.text-emg-primary-foreground.text-xs.font-medium.rounded-lg");
    private final By logoutPopupText = By.xpath("//*[@id='radix-:re:']");
    private final By confirmLogoutButton = By.xpath("//button[normalize-space()='Logout']");

    // Actions
    public void clickProfile() {
        wait.until(ExpectedConditions.elementToBeClickable(profileButton)).click();
    }

    public void clickLogoutInMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutMenuItem)).click();
    }

    public String getUsername() {
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        return usernameElement.getText();
    }

    public String getEmailAddress() {
        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailaddress));
        return emailElement.getText();
    }

    public String getUserRoles() {
        WebElement rolesElement = wait.until(ExpectedConditions.visibilityOfElementLocated(userRoles));
        return rolesElement.getText();
    }

    public String getLogoutPopupText() {
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(logoutPopupText));
        return popup.getText();
    }

    public void confirmLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmLogoutButton)).click();
    }
}
