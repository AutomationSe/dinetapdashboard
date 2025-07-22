package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {
    public static String takeScreenshot(WebDriver driver, String methodName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotDir = "test-output/screenshots/";
        String screenshotPath = screenshotDir + methodName + "_" + System.currentTimeMillis() + ".png";
        File dest = new File(screenshotPath);
        dest.getParentFile().mkdirs(); // Create dir if not exist
        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotPath;
    }

}
