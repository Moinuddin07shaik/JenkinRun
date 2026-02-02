package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Baseclass.DriverFactory;
import Baseclass.Library;
import ResusabilityFunctions.seleniumResuable;

public class Uptoaddcart_page  {
	private WebDriver driver;
	private seleniumResuable se;
	
	public Uptoaddcart_page(WebDriver driver) {
		this.driver=DriverFactory.getDriver();
		
		PageFactory.initElements(driver, this);
		se = new seleniumResuable(driver);

	}

	@FindBy(xpath="//div[@class='pStjB2 lr29Nk']") private WebElement Loginlink;
	@FindBy(xpath="//a[@title='Flipkart Plus Zone']") private WebElement Flipkartzone;
	@FindBy(xpath="//span[text()='Home & Furniture']") private WebElement Home_furniture;
	@FindBy(xpath="//a[text()='Wall Lamp']") private WebElement wall_lamp;
	@FindBy(xpath="(//a[text()='GLINTAC Swing Arm Wall Light Wall Lamp With Bulb'])[1]") private WebElement Light_wall_lamp;
	@FindBy(xpath="//input[@id='pincodeInputId']")private WebElement Pincode;
	@FindBy(xpath="//span[@class='ZnqmN2']")private WebElement Checklink;
	
	
	public void MovetoLogin() {
		se.highlightElement(Loginlink);
		se.mousehover(Loginlink);
	}

	public void MovetoFlipkartzone() {
		//se.highlightElement(Flipkartzone);
		se.moveelement(Flipkartzone);
	}
	public void MousetoHome_Furniture() {  
		se.highlightElement(Home_furniture);
		se.mousehover(Home_furniture);
	}
	public void MovetoWall_lamp() {
		se.highlightElement(wall_lamp);
		se.moveelement(wall_lamp);
	}
	public void ClickOnresult() {
		se.scrolldown(Light_wall_lamp);
		//se.Click(Light_wall_lamp);
	}
	public void CkickOnPincode() {
		se.windowhandling(Light_wall_lamp);
		Pincode.sendKeys("520001");
		
		
	}
	public void Clickchecklink() {
		se.Click(Checklink);
	}
	
}
