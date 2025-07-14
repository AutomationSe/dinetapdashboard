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
    private final By logoutPopupText = By.xpath("//*[@id='radix-:re:']");
    private final By confirmLogoutButton = By.xpath("//button[normalize-space()='Logout']");

    // Actions
    public void clickProfile() {
        wait.until(ExpectedConditions.elementToBeClickable(profileButton)).click();
    }

    public void clickLogoutInMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutMenuItem)).click();
    }

    public String getLogoutPopupText() {
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(logoutPopupText));
        return popup.getText();
    }

    public void confirmLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmLogoutButton)).click();
    }
}
