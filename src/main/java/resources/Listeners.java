package resources;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;

public class Listeners extends BaseClass implements ITestListener {

	WebDriver driver;

	ExtentReport rep = new ExtentReport();

	ExtentReports eRep = rep.getReports();

	ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<ExtentTest>();
	ExtentTest etest;

	@Override
	public void onTestStart(ITestResult result) {
		etest = eRep.createTest(result.getMethod().getMethodName()+" :: "+ result.getMethod().getMethodName());
		threadLocal.set(etest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		threadLocal.get().log(Status.PASS,"Test Passed Successfully");
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			threadLocal.get().addScreenCaptureFromPath(getScreenshot(methodName,driver),result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		threadLocal.get().fail(result.getThrowable());
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			threadLocal.get().addScreenCaptureFromPath(getScreenshot(methodName,driver),result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		eRep.flush();
	}

}
