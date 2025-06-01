package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilites.CommonOperations;

public class SearchResultPage extends CommonOperations{
	
	WebDriver driver;
	
	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	
	
	// Locators
	
	@FindBy(xpath = "//*[@data-cel-widget='search_result_3']/descendant::a[2]")
	public WebElement  href_FirstResult;
	
	//@FindBy(xpath = "//*[@data-cel-widget='search_result_3']/descendant::a/h2")
	//public WebElement  FirstResulttext;
	
	@FindBy(xpath = "//*[@role='listitem']/descendant::a/h2")
	public List<WebElement> lbl_searchResultsProductlist;
	
	 @FindBy(xpath = "//i[@class='a-icon a-icon-star-medium a-star-medium-4']")
	 public WebElement btn_4AndUpratings;
	
	 @FindBy(xpath = "//*[@role='listitem']/descendant::a[@aria-label='4.5 out of 5 stars, rating details']")
	  public List<WebElement> ratings_Product4_5;
	 
	 @FindBy(xpath = "//*[@role='listitem']/descendant::a[@aria-label='4.4 out of 5 stars, rating details']")
	  public List<WebElement> ratings_Product4_4;
	 
	 @FindBy(xpath = "//*[@role='listitem']/descendant::a[@aria-label='4.3 out of 5 stars, rating details']")
	  public List<WebElement> ratings_Product4_3;
	//Actions
	
	public void ClickOnFirstResult() {
		click(driver, href_FirstResult);
	}
	
   public String getProducttitle(int index) {
    	return getText(driver, lbl_searchResultsProductlist.get(index));
    }
    
    public void openProductDetails(int index) {
    	waitTillVisisbilityOfAllElements(driver, lbl_searchResultsProductlist);
    	click(driver, lbl_searchResultsProductlist.get(index));
    }
    
    public void setRatingsFourAndUp() {
    	click(driver, btn_4AndUpratings);
    }
    public  int getCountOfSameRating() {
    	System.out.println("Count of Products with 4.5 ratings : " + ratings_Product4_5.size());
    	System.out.println("Count of Products with 4.5 ratings : " + ratings_Product4_4.size());
    	System.out.println("Count of Products with 4.5 ratings : " + ratings_Product4_3.size());
    	return ratings_Product4_5.size() + ratings_Product4_4.size() + ratings_Product4_3.size();
    	
    }
    
    
    }

