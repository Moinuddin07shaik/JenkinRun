package stepdefination;

import Baseclass.DriverFactory;
import Baseclass.Library;
import ResusabilityFunctions.seleniumResuable;
import io.cucumber.java.en.*;
import pages.Fashion_page;

public class Fashion_stepdef  {
	private seleniumResuable se;
	private Fashion_page FFp;
	
	@Given("User to move the fashion link")
	public void user_to_move_the_fashion_link() throws Throwable {
		se = new seleniumResuable(DriverFactory.getDriver());
		System.out.println("before click fashion link");
		se.gettitle();
		FFp = new Fashion_page(DriverFactory.getDriver());
		se.waits();
		FFp.Movefashionlink();
		se.waits();
	    
	}

	@When("Curser to move to the kinds link")
	public void curser_to_move_to_the_kinds_link() throws Throwable {
		FFp.Movekindslink();
		se.waits();
	    
	}

	@When("move to girls dress and click")
	public void move_to_girls_dress_and_click() throws Throwable {
		FFp.Clickgirlsdress();
		se.waits();
	    
	}

	@When("Click the price high to low link")
	public void click_the_price_high_to_low_link() throws Throwable {
		FFp.ClickOnprice();
		se.waits();
	    
	}

	@Then("It should display the relevant details and get the title")
	public void it_should_display_the_relevant_details_and_get_the_title() {
		System.out.println("After clicking Fashion price");
		se.gettitle();
	    	}



}
