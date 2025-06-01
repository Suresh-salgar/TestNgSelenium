package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilites.CommonOperations;

public class CartPage extends CommonOperations {
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	//locators
	@FindBy(xpath = "(//input[@id='add-to-cart-button'])[2]")
	public WebElement btn_AddToCart;
	
	
	//Actions
	
	public void ClickOnAddToCart(){
		driver.navigate().refresh();
		click(driver, btn_AddToCart);
	}
}
