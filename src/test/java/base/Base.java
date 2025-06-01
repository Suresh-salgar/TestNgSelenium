package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentTest;

import utilites.CommonOperations;

public class Base extends CommonOperations{
	public static ExtentTest test;
	public static WebDriver driver;
	@BeforeTest
	public void setUp() throws InterruptedException, IOException {
		System.out.println("This is setup method");
		
		Properties prop = new Properties();
		FileInputStream Fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/utilites/config.properties");
		prop.load(Fis);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("baseUrl"));
		Thread.sleep(2000);
		
		//Login
//		Enter userName
//		sendKeys(driver, element, prop.getProperty("userName"));
		
//		Enter password
//		sendKeys(driver, element, prop.getProperty("password"));
	}
    
	@AfterTest
	public void tearDown() {
		System.out.println("This is tear down method");
		driver.quit();
	}
	
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destPath = System.getProperty("user.dir") + "/SrcShot/" + 
		testCaseName + "_" + getDateTime() + ".png" ;
		FileUtils.copyFile(source, new File(destPath));
		return destPath;
	}
	
	public static String getDateTime() {
		return new SimpleDateFormat("ddMMyyyy_HHmmss").format(Calendar.getInstance().getTime());
	}
}
