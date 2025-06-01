package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;

public class Test1 extends Base{
	
 @Test
	public void test() {
	 System.out.println("This is test method");
		String currentUrl = driver.getCurrentUrl();
		boolean flag = false;
		if(currentUrl.contains("amazon.in")) {
			flag=true;
		}else {
			flag=false;
		}
		Assert.assertTrue(flag,"This is not amazon website");
	}
 @Test
 public void test2() throws InterruptedException {
	 boolean flag =false;
	 System.out.println(driver.getTitle());
	 if(driver.getTitle().contains("Amazon.in")) {
		 flag=true;
		 
	 }else {
		 flag = false;
	 }
		 Assert.assertTrue(flag);
	Thread.sleep(3000);
	driver.quit();
 }
}
