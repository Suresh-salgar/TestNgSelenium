package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ExtentReporter extends Base {
   static ExtentReports extent;
   
   public static ExtentReports getReporterObject() {
	   String reportPath = System.getProperty("user.dir") + "/Reports/TestRpt" +getDateTime() + ".html";
	   ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath).viewConfigurer().viewOrder()
			   .as(new ViewName[] { ViewName.DASHBOARD,ViewName.TEST}).apply();
	   reporter.config().setDocumentTitle("Test Report");
	   reporter.config().setTheme(Theme.STANDARD);
	   
	   extent =new ExtentReports();
	   extent.attachReporter(reporter);
	   extent.setSystemInfo("QA Name", "Suresh Salgar");
	   extent.setSystemInfo("Designation", "Tester");
	   extent.setSystemInfo("Environment", "QA/UAT");
	   return extent;
	   
}
}
