package stepdefination;

import Baseclass.DriverFactory;
import Baseclass.Library;
import ResusabilityFunctions.seleniumResuable;
import io.cucumber.java.en.*;
import pages.Searchxcel_page;

public class Searchwithxcell {
	private Searchxcel_page sp;
	private seleniumResuable se;
	
	@Given("Enter search test in the search field")
	public void enter_search_test_in_the_search_field() throws Throwable {
		
		sp = new Searchxcel_page(DriverFactory.getDriver());
		
		sp.Searchwithexcel();
	
	  
	}

	@When("click search icon")
	public void click_search_icon() {
		se = new seleniumResuable(DriverFactory.getDriver());
	    se.screenshot("C:\\Users\\moinu\\eclipse-workspace\\Flipkart\\src\\test\\resources\\Screenshots\\Searchbox"+System.currentTimeMillis()+".png");

	}
	   

	@Then("It Should display the Relevant result")
	public void it_should_display_the_relevant_result() {
		se.gettitle();
	    	}

}
