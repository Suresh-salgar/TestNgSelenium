package utilites;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonOperations {
	
	public static final Logger logger = Logger.getLogger(CommonOperations.class.getName());

	public void waitTillTitleContains(WebDriver driver, String value) {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.titleContains(value));
	}
	
	public void waitTillVisisbilityOf(WebDriver driver, WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitTillVisisbilityOfElementLocated(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}
	
	public void waitTillVisisbilityOfAllElements(WebDriver driver, List<WebElement> elements) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		}
	public void waitTillVisisbilityOfAllElementsLocated(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		}
	
	//not used
	public void waitTillVisisbilityOfAllElementText(WebDriver driver, WebElement element, String value ) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.textToBePresentInElement(element , value));
		}
	
	public void click(WebDriver driver, WebElement element) {
		waitTillVisisbilityOf(driver, element);
		element.click();
	}
	public void sendKeys(WebDriver driver, WebElement element, String value) {
		waitTillVisisbilityOf(driver, element);
		element.clear();
		element.sendKeys(value);
	}
	public String getText(WebDriver driver, WebElement element) {
		waitTillVisisbilityOf(driver, element);
		return element.getText();
	}
	
	public void moveToHelloSign(WebDriver driver, WebElement element) {
		waitTillVisisbilityOf(driver, element);
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public void switchToChildWindow(WebDriver driver) {
		String parentHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for(String handle : windowHandles) {
			if(!handle.equals(parentHandle))
					driver.switchTo().window(handle);
			}
		}
	 
	public void returnToParentwindow(WebDriver driver, String parenthandle) {
		driver.switchTo().window(parenthandle);
	}
	
	public int getSizeFromDropDown(WebElement element ) {
	Select select = new Select(element);
	 return select.getOptions().size();
	}
	
	public String getTextFromDropDown(WebElement element, int index ) {
		Select select = new Select(element);
		 return select.getOptions().get(index).getText();
}
	public void selectOptionFromDropDownusingVisisbleText(WebElement element, String visisbleText ) {
		Select select = new Select(element);
		select.selectByVisibleText(visisbleText);
	}
}

