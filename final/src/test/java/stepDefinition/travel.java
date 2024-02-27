package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import base.baseClass;
import base.screenshot;
import io.cucumber.java.en.*;
import pageObject.home;
import pageObject.travelInsurance;
import pageObject.travelInsurance_result;


public class travel {

	WebDriver driver;
	home h;
	travelInsurance t;
	screenshot s;
	travelInsurance_result tr;
	
	
	@Given("user is present on policybazaar.com")
	public void user_is_present_on_policybazaar_com() throws IOException {
		baseClass.getlogger().info("*****Navigating to policyBazaar Website**********");
		h=new home(baseClass.getDriver());
		t=new travelInsurance(baseClass.getDriver());
		s=new screenshot(baseClass.getDriver());
		tr=new travelInsurance_result(baseClass.getDriver());
		s.ScreenShots("homePage");
	}

	@When("user clicks on travel insurance option from all the options available on the main page")
	public void user_clicks_on_travel_insurance_option_from_all_the_options_available_on_the_main_page() throws IOException {
		baseClass.getlogger().info("*****Scrolling down until all options are available**********");
		h.scrollDown();
		baseClass.getlogger().info("*****Selecting travel insurance out of the options available**********");
		h.selectTravelInsOption();
	}

	@When("user enters the country")
	public void user_enters_the_country() throws IOException {
		
		baseClass.getlogger().info("*****selecting the country to travel to**********");
		t.chooseCountry();
		s.ScreenShots("country");
		baseClass.getlogger().info("*****Clicking on next button**********");
		t.clickNext();
	}

	@When("user selects the start date and end date of the trip")
	public void user_selects_the_start_date_and_end_date_of_the_trip() throws IOException {
		baseClass.getlogger().info("*****selecting the start end and end date for the trip**********");
		t.selectDate();
		s.ScreenShots("date");
		t.clickNext();
	}

	@When("user enters the number of Students traveling along with their age")
	public void user_enters_the_number_of_students_traveling_along_with_their_age() throws IOException {
		baseClass.getlogger().info("*****selecting the number of people traveling**********");
		t.selectNoOfStudents();
		baseClass.getlogger().info("*****selecting age of the person **********");
		t.selectAge1();
		baseClass.getlogger().info("*****selecting age of second person**********");
		t.selectAge2();
		s.ScreenShots("age");
		t.clickNext();
	}

	@When("user enters pre-existing medical condition if any")
	public void user_enters_pre_existing_medical_condition_if_any() throws IOException, InterruptedException {
		baseClass.getlogger().info("*****entering the details of any pre-existing medical condition if any**********");
	   t.selectMedicalCondition();
	   s.ScreenShots("medicalcondn");
	}

	@When("user enters mobile number and clicks on submit button")
	public void user_enters_mobile_number_and_clicks_on_submit_button() throws IOException {
		baseClass.getlogger().info("*****entering the mobile number **********");
		s.ScreenShots("phnNo");
		t.enterMobileNumber();
		t.viewplan.click();
	}

	@Then("user is navigated to results page")
	public void user_is_navigated_to_results_page() throws IOException {
		baseClass.getlogger().info("*****displaying the title of the page opened**********");
		s.ScreenShots("resultsIns");
		System.out.println(tr.resultPageTitle);
	}

}
	   

