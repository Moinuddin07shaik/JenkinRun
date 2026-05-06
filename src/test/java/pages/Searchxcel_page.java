package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Baseclass.DriverFactory;
import Baseclass.Library;
import ResusabilityFunctions.seleniumResuable;
import utilitys.excellutility;

public class Searchxcel_page  {
	
	private WebDriver driver;
	private seleniumResuable se;
	private excellutility excel;
	
	public Searchxcel_page(WebDriver driver) {
		this.driver=DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
		
		se = new seleniumResuable(driver);
    	excel = new excellutility();

		
	}
  //  @FindBy(xpath="(//input[@name='q'])[1]") private WebElement searchbox;
    @FindBy(xpath="//div[@id='container']") private  WebElement Homepage;

    
    public void Searchwithexcel() throws Throwable {
    	
    	for(int i=1; i<=6;i++) {
    		String value = excel.excelread("Sheet1", i, 0);
    		WebElement searchbox = se.waitForElement(driver, By.xpath("(//input[@name='q'])[1]"));
    		se.entervalue(searchbox, value);
    		
    		searchbox.sendKeys(Keys.ENTER);
    		
    		
    		if(Homepage.isDisplayed()) {
    			excel.excelwrite("Sheet1", i, 1, "PASS");
    		}else {
    			excel.excelwrite("Sheet1", i, 1, "FAIL");
    		}
    		se.navigateback();

    	}

    }
}
