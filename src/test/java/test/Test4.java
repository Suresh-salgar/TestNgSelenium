package test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.HomePage;

public class Test4 extends Base{
	
	public HomePage home;
	
	@BeforeClass
	public void preTest() {
		home = new HomePage(driver);
	}
	@Test
	public void testFor400068() throws InterruptedException {
		home.enterPincode("400068");
		Assert.assertTrue(home.getPincode().contains("400068"));
	}
	@Test
	public void testFor400069() throws InterruptedException {
		home.enterPincode("400069");
		Assert.assertTrue(home.getPincode().contains("400069"));
	}
	@Test
	public void testFor400070() throws InterruptedException {
		home.enterPincode("400070");
		Assert.assertTrue(home.getPincode().contains("400070"));
	}
}
