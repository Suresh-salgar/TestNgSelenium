package testAnnotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class Annotations {
	

	@Test (priority = 2)
	public void atest2() {
		System.out.println("This is test2");
		
	}

	@Test (priority = 2, description = "This is test 3")
	public void atest3() {
		System.out.println("This is test3");
	}

	
	@BeforeTest
	public void setup() {
		System.out.println("This is Before Test");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("This is After Suite");
	}

	@Test (priority = 1, description = "This test's description", dependsOnMethods = "atest2")
	public void btest() {
		System.out.println("This is test");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("This is After Class");
	}

	@BeforeClass
	public void getDate() {
		System.out.println("This is Before Class");
	}

	@AfterTest
	public void postsetup() {
		System.out.println("This is After Test");
	}

	
@BeforeSuite
	public void beforeSuite() {
		System.out.println("This is Before Suite");
	}


}
