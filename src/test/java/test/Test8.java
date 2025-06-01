package test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.HomePage;

public class Test8 extends Base{

	HomePage home;
	
	@BeforeClass
	public void preTest() {
		home = new HomePage(driver);
	}
	@Test
	public void Test08() {
		System.out.println("Count of Options in Dropdown : " + home.getcountofoptionsDd());
		System.out.println(home.getTheTextOfElementFromDd(4));
		home.selectElementusingVisibleText("Electronics");
		home.EnterTextInSearchBox("Laptop");
		Assert.assertTrue(driver.getTitle().contains("Laptop"));
	}
}
