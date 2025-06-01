package pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilites.CommonOperations;

public class HomePage extends CommonOperations{
   WebDriver driver;
   
   public HomePage(WebDriver driver) {
	   this.driver = driver;
	   PageFactory.initElements(driver, this);
   }
   
   //Web Element
   @FindBy(id = "nav-cart")
  public WebElement btn_Cart;
   
   @FindBy(id = "glow-ingress-line2")
   public WebElement btn_Location;
   
   @FindBy(id = "GLUXZipUpdateInput")
   public WebElement txt_Pincode;
   
   @FindBy(xpath = "//*[@aria-labelledby='GLUXZipUpdate-announce']")
   public WebElement btn_Apply;
   
   @FindBy(id = "glow-ingress-line2")
   public WebElement ttl_Location;
   
   @FindBy(id = "nav-link-accountList-nav-line-1")
   public WebElement btn_HelloSignIn;
   
   @FindBy(xpath = "//*[@id='nav-flyout-ya-signin']/a")
   public WebElement btn_SignIn;
   
   @FindBy(id = "twotabsearchtextbox")
   public WebElement txt_SearchBox;
   
   @FindBy(id = "nav-search-submit-button")
   public WebElement btn_Search;
   
   @FindBy(xpath = "//*[@role='listitem']/descendant::h4/descendant::span[3]")
   public WebElement ProductLabel;
   
   @FindBy(xpath = "//*[@role='listitem']/descendant::h4/descendant::span[3]")
   public List<WebElement> lbl_ProductLabelList;
   
   @FindBy(id = "nav-search-dropdown-card")
   public WebElement dd_searchbox;
   
   @FindBy(id = "searchDropdownBox")
   public WebElement dd_searchBoxList;
   
  @FindBy(xpath = "//*[@id='nav-xshop']/ul/li/div/a")
  public List<WebElement> link_header;
   
   //Actions method
   public void navigateToCart() {
   click(driver, btn_Cart);
   logger.info("** ----- Clicked on cart button");
   
}
   public void enterPincode(String pincode) throws InterruptedException {
	   click(driver, btn_Location);
	   logger.info("** ----- Clicked on location button");
	   sendKeys(driver, txt_Pincode, pincode);
	   logger.info("** ----- Entered pincode");
	   click(driver, btn_Apply);
	   logger.info("** ----- Clicked on apply button");
   }
 public String getPincode() throws InterruptedException {
	 Thread.sleep(1000);
	 logger.info("** ----- Returning the applied pincode");
	 return getText(driver, ttl_Location);
 }
 
 public void navigateToSignIn() {
	 moveToHelloSign(driver, btn_HelloSignIn);
	 logger.info("***** ------ Hovering on Hello sign in button");
	 click(driver, btn_SignIn);
	 logger.info("***** ----- Clicked on Sign in button");
 }
 
 public void EnterTextInSearchBox(String productName) {
	 sendKeys(driver, txt_SearchBox, productName);
	 click(driver, btn_Search);
	
	
 }
  public String getProductlabel() throws InterruptedException{
	  Thread.sleep(2000);
	  String actualProductLabel = ProductLabel.getText();
	  String editedProductlabel = actualProductLabel.substring(0, actualProductLabel.length()-5);
	  return editedProductlabel;
  }
	 public int countOfProductsInTheCart() {
		 return lbl_ProductLabelList.size();
	 }
	 
	 public int getcountofoptionsDd() {
		 click(driver, dd_searchbox);
		 return getSizeFromDropDown(dd_searchBoxList);
	 }
	 public String getTheTextOfElementFromDd(int index) {
		 return getTextFromDropDown(dd_searchBoxList, index);
	 }
	 
	 public void selectElementusingVisibleText(String visibleText) {
		 selectOptionFromDropDownusingVisisbleText(dd_searchBoxList,visibleText);
	 }
	 
   public void getHeaderMenuUrl() throws InterruptedException {
	  
	   int count =1;
	   for(int i=0;i<=link_header.size()-1;i++) {
		String linkAttribute  = link_header.get(i).getAttribute("href");
		System.out.println("*****************************link Number : " + count);
		System.out.println("href Attribute : " + linkAttribute);
		   click(driver, link_header.get(i));
		   Thread.sleep(1000);
		   count = count +1;
		   Thread.sleep(1000);
		   System.out.println("URL : " + driver.getCurrentUrl());
		   if(driver.getCurrentUrl().contains(linkAttribute)) {
			   System.out.println("URL matches with the 'href' attribute of the header menu");
		   }else {
			   System.out.println("URL did not match with the 'href' attribute of the header menu");
		   }
		   driver.navigate().back();
		   JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("document.body.style.zoom='40%'");
		   Thread.sleep(2000);
	   }
   }
	
 }

