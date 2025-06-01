package test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.HomePage;
import pageObjects.SearchResultPage;

public class Test_12 extends Base{
	HomePage home;
	SearchResultPage search;
	
	@BeforeClass
	public void preTest() {
		home = new HomePage(driver);
		search = new SearchResultPage(driver);
	}
   
	@Test
	public void Test12() throws InterruptedException {
		home.EnterTextInSearchBox("iphone");
		search.setRatingsFourAndUp();
		Thread.sleep(2000);
		System.out.println("Total product count :" + search.lbl_searchResultsProductlist.size());
		Assert.assertEquals(search.lbl_searchResultsProductlist.size(),search.getCountOfSameRating());
	}
}
