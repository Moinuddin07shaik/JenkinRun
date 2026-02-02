package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Baseclass.DriverFactory;
import Baseclass.Library;
import ResusabilityFunctions.seleniumResuable;

public class Fashion_page  {
	
	private WebDriver driver;
	private seleniumResuable se;
	
	public Fashion_page(WebDriver driver) {
		
		this.driver=DriverFactory.getDriver();
		
		PageFactory.initElements(driver, this);
		se = new seleniumResuable(driver);

	}
	
	@FindBy(xpath="//span[text()='Fashion']") private WebElement Fashionlink;
	@FindBy(xpath="//a[text()='Kids']")private WebElement Kidslink;
	@FindBy(xpath="//a[contains(text(),'Girls')]")private WebElement Girls_Dresslink;
	@FindBy(xpath="//div[text()='Price -- High to Low']") private WebElement price_High_Low;
	
	
	public void Movefashionlink() {
		se.highlightElement(Fashionlink);
        se.mousehover(Fashionlink);
	}
	public void Movekindslink() {
		se.highlightElement(Kidslink);
        se.mousehover(Kidslink);
	}
	public void Clickgirlsdress() {
		se.highlightElement(Girls_Dresslink);
        se.moveelement(Girls_Dresslink);
	}
	public void ClickOnprice() {
		se.highlightElement(price_High_Low);
		se.Click(price_High_Low);
	}

}
