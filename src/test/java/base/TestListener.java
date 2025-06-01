package base;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

public class TestListener extends Base implements ITestListener{
	ExtentReports extent = ExtentReporter.getReporterObject();

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, "******------- Test has Started. --------******");
		logger.info(("******------- Test has Started. --------******"));
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "******------- Test has Pass. --------******");
		logger.info(("******------- Test has Started. --------******"));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "******------- Test has Fail. --------******");
		try {
			test.addScreenCaptureFromPath(getScreenShotPath(result.getMethod().getMethodName(), driver), 
					result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info(("******------- Test has Started. --------******"));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.INFO, "******------- Test has Skipped. --------******");
		logger.info(("******------- Test has Skipped. --------******"));
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		test.log(Status.INFO, "******------- Test has Finished. --------******");
		logger.info(("******------- Test has Finished. --------******"));
		extent.flush();
	}
	


}
