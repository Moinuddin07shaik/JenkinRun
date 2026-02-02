
package stepdefination;

import org.openqa.selenium.By;

import Baseclass.DriverFactory;
import ResusabilityFunctions.seleniumResuable;
import io.cucumber.java.en.Then;
import pages.Filters_page;

public class Filter_stepdef  {
	
	private Filters_page fp;
	private seleniumResuable se;
	
	@Then("Select Minimun and Maximun Amount")
	public void select_minimun_and_maximun_amount() throws Throwable {
		fp= new Filters_page(DriverFactory.getDriver()); 
		String beforeFilter = DriverFactory.getDriver().findElement(By.xpath("(//div[@class=\"col col-7-12\"])[1]")).getText();
		System.out.println("before Filter :"+beforeFilter);
		fp.Min();
		se=new seleniumResuable (DriverFactory.getDriver());
		se.waits();
		fp.max();
		se.waits();
	}
	  


	@Then("Select the Brand")
	public void select_the_brand() throws Throwable {
	    fp.brand();
	    se.waits();
	}

	@Then("Select the Ram")
	public void select_the_ram() throws Throwable {
	    fp.ram();
	    se.waits();
	}

	@Then("Select Battery Capacity")
	public void select_battery_capacity() throws Throwable {
		fp.clickbattery();
		se.waits();
		
	   
	}

	@Then("It should display the Relevant result")
	public void it_should_display_the_relevant_result() {
	   System.out.println("*****************************");
	 String afterfilter = DriverFactory.getDriver().findElement(By.xpath("(//div[@class='col col-7-12'])[1]")).getText();
	   System.out.println("afterfilter :"+afterfilter);
	}



}
