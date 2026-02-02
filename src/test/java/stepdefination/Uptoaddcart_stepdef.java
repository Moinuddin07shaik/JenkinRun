package stepdefination;

import Baseclass.DriverFactory;
import Baseclass.Library;
import ResusabilityFunctions.seleniumResuable;
import io.cucumber.java.en.*;
import pages.Uptoaddcart_page;

public class Uptoaddcart_stepdef  {

	private seleniumResuable re;
	private Uptoaddcart_page up;

	@Given("User can move to the login link")
	public void user_can_move_to_the_login_link() throws Throwable {
		up= new Uptoaddcart_page(DriverFactory.getDriver());
		re = new seleniumResuable(DriverFactory.getDriver());
		up.MovetoLogin();
		re.waits();
		System.out.println("parentwindow title");
		re.gettitle();
	}

	@When("User can click the flipkart pluse zone")
	public void user_can_click_the_flipkart_pluse_zone() throws Throwable {
		up.MovetoFlipkartzone();
		re.waits();
		
	}

	@When("Mouse move to the Home&Furniture link")
	public void mouse_move_to_the_home_furniture_link() throws Throwable {
		up.MousetoHome_Furniture();
		re.waits();
	}

	@When("Going to click the wall lamp")
	public void going_to_click_the_wall_lamp() throws Throwable {
		up.MovetoWall_lamp();
		re.waits();
	}

	@When("Scroll down the page and click on particular result")
	public void scroll_down_the_page_and_click_on_particular_result() throws Throwable {
		up.ClickOnresult();
		re.waits();
	}

	@When("Enter delivery pincode and click the check link")
	public void enter_delivery_pincode_and_click_the_check_link() throws Throwable {
		up.CkickOnPincode();
		re.waits();
	}

	@Then("Pincode should be checked and display and verify the title")
	public void pincode_should_be_checked_and_display_and_verify_the_title() {
		up.Clickchecklink();
		System.out.println("Childwindow title");
		re.gettitle();
		re.screenshot("C:\\Users\\moinu\\eclipse-workspace\\Flipkart\\src\\test\\resources\\Screenshots\\uptoaddcart.png");
	}

}
