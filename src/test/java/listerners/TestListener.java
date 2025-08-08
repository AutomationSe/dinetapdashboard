package listerners;

import base.BaseTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import utils.ScreenshotUtil;
import utils.extentManager;

import java.io.File;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("✅ Testcase Started and testcase details are: " + result.getMethod().getMethodName());
        extentManager.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("✅ Test Passed Hurry and testcase details are: " + result.getMethod().getMethodName());
        extentManager.getTest().log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        BaseTest base = (BaseTest) result.getInstance();
        String screenshotPath = ScreenshotUtil.takeScreenshot(base.getDriver(), methodName);

        System.out.println("❌ Test Failed and testcase details are: " + result.getMethod().getMethodName());
        extentManager.getTest().log(Status.FAIL, "Test Failed: " + result.getThrowable());

        // ✅ This is the key change:
        extentManager.getTest().addScreenCaptureFromPath("screenshots/" + new File(screenshotPath).getName());

        // Log into TestNG default report
        Reporter.log("❌ Test Failed: " + result.getThrowable(), true);
        Reporter.log("<br><a href='" + screenshotPath + "' target='_blank'>Click to view screenshot</a>", true);
        Reporter.log("<br><img src='" + screenshotPath + "' height='300' width='400' />", true);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("⏭️ Test Skipped and testcase details are: " + result.getMethod().getMethodName());
        extentManager.getTest().log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extentManager.flushReports();
    }
}
