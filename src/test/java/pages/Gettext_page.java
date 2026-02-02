package pages;

import org.openqa.selenium.WebDriver;

import Baseclass.DriverFactory;

public class Gettext_page  {
	
   private WebDriver driver;
   
	public Gettext_page(WebDriver driver) {
		this.driver=DriverFactory.getDriver();
		
	}
}
