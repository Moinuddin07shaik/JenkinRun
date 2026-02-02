package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Baseclass.DriverFactory;
import Baseclass.Library;
import ResusabilityFunctions.seleniumResuable;

public class Titleprice_page  {
	
	private WebDriver driver;

	  private seleniumResuable se;
	   
	public Titleprice_page(WebDriver driver) {
		
		this.driver=DriverFactory.getDriver();
		
		PageFactory.initElements(driver, this);
		se= new seleniumResuable(driver);

		
	}
	@FindBy(xpath="//input[@name='q']") private WebElement Search;
	@FindBy(xpath="//button[@type='submit']") private WebElement searchicon;
	
	public void entersearch(String text) {
		se.entervalue(Search, text);
		
	}
	public void clicksearchicon() {
		se.Click(searchicon);
	}

}
