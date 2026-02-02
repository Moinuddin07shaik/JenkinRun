
package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Baseclass.DriverFactory;
import Baseclass.Library;
import ResusabilityFunctions.seleniumResuable;

public class Multiplesearch_page {
	private WebDriver driver;
	private seleniumResuable se;
	
	public Multiplesearch_page(WebDriver driver) {
		this.driver=DriverFactory.getDriver();
		
		PageFactory.initElements(driver, this);
		se= new seleniumResuable(driver);

	}
	
	@FindBy(xpath="//input[@name='q']")private WebElement SearchField;
	
	public void Entersearch(String Searchtext) {
		
		se.entervalue(SearchField, Searchtext);
		
	}
	public void Clicksearch() {
		SearchField.sendKeys(Keys.ENTER);
	}
	
	

}
