package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Baseclass.DriverFactory;
import Baseclass.Library;
import ResusabilityFunctions.seleniumResuable;

public class Filters_page  {
	
	private WebDriver driver;
	private seleniumResuable se;
	
	public Filters_page(WebDriver driver) {
		this.driver=DriverFactory.getDriver();
		
		PageFactory.initElements(driver, this);
		se=new seleniumResuable(driver);
     
	}
	
	@FindBy (xpath="(//select[@class='hbnjE2'])[1]") private WebElement MinimumAmount;
	@FindBy (xpath="(//select[@class='hbnjE2'])[2]") private WebElement MaximumAmount;
	@FindBy(xpath="//div[text()='vivo']") private WebElement Brand;
	@FindBy(xpath="//div[text()='4 GB']") private WebElement Ram;
	@FindBy(xpath="//div[text()='Battery Capacity']")private WebElement BatteryRow;
	@FindBy(xpath="//div[text()='3000 - 3999 mAh']") private WebElement BatteryCapacity;
	
	public void Min() {
		se.dropdown(MinimumAmount, "10000");
		
	}
	public void max() {
		se=new seleniumResuable(driver);
		se.dropdown(MaximumAmount, "20000");
	}
	public void brand() {
		se=new seleniumResuable(driver);
		se.Click(Brand);
	}
	public void ram() {
		se=new seleniumResuable(driver);
		se.Click(Ram);
		
	}
	public void clickbattery() {
		se=new seleniumResuable(driver);
		se.Click(BatteryRow);
		se.Click(BatteryCapacity);
	}
	

}
