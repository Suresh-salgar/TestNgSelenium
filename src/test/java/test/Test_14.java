package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.HomePage;

public class Test_14 extends Base{
	HomePage home;
	
	@BeforeClass
	public void preTest() {
		home = new HomePage(driver);
	}
	
	@Test
	public void Test14() throws InterruptedException {
		System.out.println("Total count of links in the Header :" + home.link_header.size());
		home.getHeaderMenuUrl();
	}

}
