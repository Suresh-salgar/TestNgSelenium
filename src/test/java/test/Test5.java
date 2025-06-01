package test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.HomePage;

public class Test5 extends Base {
     HomePage home;
     
     @BeforeClass
     public void preTest() {
    	 home = new HomePage(driver);
     }
	
     @Test
     public void Test05() {
    	 home.navigateToSignIn();
    	 logger.info("***** ----- Navigated to Sign in page");
    	 logger.info("***** ------ Validating the sign Url");
    	 Assert.assertTrue(driver.getCurrentUrl().contains("signin") , "Failed : URL does not contain signin");
     }
	 
}
