package listerners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listerners.TestListener.class)
public class myFirsttestcase {

    @Test
    public void GoogleTitleVerify(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        driver.quit();
    }


}
