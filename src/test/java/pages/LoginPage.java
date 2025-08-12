package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    private By loginTitle = By.xpath("(//h2[normalize-space()='Login'])[1]");
    private By emailTitle = By.xpath("(//label[normalize-space()='Email'])[1]");
    private By emailField = By.id("email");
    private By passwordTitle = By.xpath("(//label[normalize-space()='Password'])[1]");
    private By passwordField = By.id("password");
    private By signInButton = By.xpath("//button[@type='submit']");
    private By errorKey = By.xpath("(//div[@class='text-lg font-semibold'])[1]");
    private By serverError = By.xpath("(//div[@class='group-[.toast]:text-muted-foreground'])[1]");
    private By version = By.xpath("(//p[@class='text-xs text-foreground'])[1]");

    public String getLoginTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginTitle)).getText().trim();
    }
    public String getEmailTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailTitle)).getText().trim();
    }
    public String getPasswordTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTitle)).getText().trim();
    }
    public String getErrorKey() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorKey)).getText().trim();
    }
    public String getServerError() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(serverError)).getText().trim();
    }
    public String getVersion() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(version)).getText().trim();
    }
    public void login(String email, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).clear();
        driver.findElement(emailField).sendKeys(email);

        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).clear();
        driver.findElement(passwordField).sendKeys(password);

        driver.findElement(signInButton).click();
    }
}
