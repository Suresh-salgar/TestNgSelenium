package test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.SearchResultPage;

public class Test7 extends Base{
	HomePage home;
	SearchResultPage search;
	CartPage cart;
	
	@BeforeClass
	public void preTest() {
		home = new HomePage(driver);
		search = new SearchResultPage(driver);
		cart = new CartPage(driver);
	}
	@Test
	public void Test07() throws InterruptedException {
		home.EnterTextInSearchBox("Mobile Phones");
		String parentHandle = driver.getWindowHandle();
		search.openProductDetails(2);
		switchToChildWindow(driver);
		cart.ClickOnAddToCart();
		returnToParentwindow(driver, parentHandle);
		search.openProductDetails(3);
		switchToChildWindow(driver);
		cart.ClickOnAddToCart();
		Thread.sleep(2000);
		returnToParentwindow(driver, parentHandle);
		home.navigateToCart();
		Assert.assertEquals(home.countOfProductsInTheCart(), 2);
		
	}

}
