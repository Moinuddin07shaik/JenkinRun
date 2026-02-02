package stepdefination;

import java.io.IOException;

import Baseclass.DriverFactory;
import Baseclass.Library;
import io.cucumber.java.en.*;
import pages.search_page;

public class searchmobile_testcase {
	
	private search_page sp;
	
	@Given("Launch the Flipkart application")
	public void launch_the_flipkart_application() throws IOException {
		
	   
	}

	@When("close the popup")
	public void close_the_popup() {
	    System.out.println(DriverFactory.getDriver().getTitle());
	}

	@Then("It should navigate to home page")
	public void it_should_navigate_to_home_page() {
		sp = new search_page(DriverFactory.getDriver());
		sp.homescreen();
	    
	}

	@Given("user enter the text in the search field")
	public void user_enter_the_text_in_the_search_field() {
	    sp.search("Mobiles");
	}

	@When("clicks the search button")
	public void clicks_the_search_button() {
		sp.clicksearch();
	    
	}

	@Then("It should navigate to the search result page and display the relevent details")
	public void it_should_navigate_to_the_search_result_page_and_display_the_relevent_details() {
	    sp.Result();
	}
	@Then("Extract the results and print console")
	public void extract_the_results_and_print_console() {
		sp.printentaireresult();
	   
	}
	@Then("print the third result and keep it in console")
	public void print_the_third_result_and_keep_it_in_console() {
	   sp.print3rdresult();
	}




}
