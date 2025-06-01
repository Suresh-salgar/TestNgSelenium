package test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.SearchResultPage;

public class Test6 extends Base{
	HomePage home;
	SearchResultPage search; 
	CartPage cart;
	
	@BeforeClass
	public void preTest () {
		home = new HomePage(driver);
		search = new SearchResultPage(driver);
		cart = new CartPage(driver);
	}
    
	@Test
	public void Test06() throws InterruptedException {
		String parentHandle = driver.getWindowHandle();
		home.EnterTextInSearchBox("Samsung Galaxy");
		search.openProductDetails(1);
		String productTitle = search.getProducttitle(1);
		System.out.println(productTitle);
		search.ClickOnFirstResult();
		switchToChildWindow(driver);
		cart.ClickOnAddToCart();
		returnToParentwindow(driver, parentHandle);
		home.navigateToCart();
		driver.navigate().refresh();
		System.out.println(home.getProductlabel());
		Assert.assertTrue(productTitle.contains(home.getProductlabel()));;
	}
}

