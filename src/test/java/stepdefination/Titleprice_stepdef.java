package stepdefination;

import org.openqa.selenium.By;

import Baseclass.DriverFactory;
import Baseclass.Library;
import ResusabilityFunctions.seleniumResuable;
import io.cucumber.java.en.*;
import pages.Titleprice_page;

public class Titleprice_stepdef  {
	private Titleprice_page tp;
	private seleniumResuable re;
	
	@Given("Enter the search text in the text field")
	public void enter_the_search_text_in_the_text_field() {
		tp =new Titleprice_page(DriverFactory.getDriver());
		tp.entersearch("Shirts");
		
	   	}

	@When("click the search icon")
	public void click_the_search_icon() {
	    tp.clicksearchicon();
	}

	@Then("It should display the search result and get the title")
	public void it_should_display_the_search_result_and_get_the_title() {
	    re =new seleniumResuable(DriverFactory.getDriver());
	    re.MultipleGettext(DriverFactory.getDriver().findElements(By.xpath("//div[@class='p0C73x']")));
	}


}
