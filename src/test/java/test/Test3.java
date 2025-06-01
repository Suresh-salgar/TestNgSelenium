package test;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.HomePage;

public class Test3 extends Base {
    public HomePage home;
    boolean flag = false;
    
    @BeforeClass
    public void preTest() {
    	home = new HomePage(driver);
    	
    }
    @Test
    public void Test3() throws InterruptedException {
    	home.navigateToCart();
//  	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//    	wait.until(ExpectedConditions.titleContains("Shopping Cart"));
    	// waitTillTitleContains(driver, "Shopping Cart");
    	Assert.assertEquals(driver.getTitle(), "Amazon.in Shopping Cart", "The title does not match");
    	
    	if(driver.getTitle().contains("Shopping Cart"))
    			flag=true;
    	else
    		flag=false;
    	Assert.assertFalse(flag,"The title does not match");
    }
    
}
