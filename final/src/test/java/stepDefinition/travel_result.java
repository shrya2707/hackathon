package stepDefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import base.baseClass;
import base.dataDriven;
import io.cucumber.java.en.*;
import pageObject.travelInsurance;
import pageObject.travelInsurance_result;

public class travel_result {
	
	travelInsurance_result tr;
	
	@When("user selects student plan from the filter options")
	public void user_selects_student_plan_from_the_filter_options() {
		tr=new travelInsurance_result(baseClass.getDriver());
		
		baseClass.getlogger().info("*******user selects student plan from the filter options********");
		tr.studentPlanFilter();
	}

	@Then("Student Travel Information slider page is opened")
	public void student_travel_information_slider_page_is_opened() {
		baseClass.getlogger().info("*******Student Travel Information slider page is opened********");   
	}

	@When("user selects the Student Visa for both the student travellers")
	public void user_selects_the_student_visa_for_both_the_student_travellers() {
		baseClass.getlogger().info("*******user selects the Student Visa for both the student travellers********");
		tr.visaOption();
	}

	@When("user enters the duration of the trip and clicks on apply changes")
	public void user_enters_the_duration_of_the_trip_and_clicks_on_apply_changes() {
		baseClass.getlogger().info("*******user enters the duration of the trip and clicks on apply changes********");
	   tr.durationOptn();
	}
	@When("user selects premium low to high filter from sort by dropdown")
	public void user_selects_premium_low_to_high_filter_from_sort_by_dropdown() throws InterruptedException, FileNotFoundException, IOException {
		baseClass.getlogger().info("*****selecting low to high filter from the sort by dropdown to apply filter**********");
	    tr.filter();
	}


	@Then("insurance plans are displayed and top3 cheapest plan names along with their is captured")
	public void insurance_plans_are_displayed_and_top3_cheapest_plan_names_along_with_their_is_captured() throws IOException {
		
		baseClass.getlogger().info("*****printing the top3 minimum travel insurance plans for students**********");
		String name[]=new String[tr.planName.size()];
		String price[]=new String[tr.planPrice.size()];
		String company[]=new String[tr.planPrice.size()];
		
		for (int i = 0; i < 3; i++) {
			company[i]=tr.companyName.get(i).getText();
			System.out.println( tr.companyName.get(i).getText());
			name[i]=tr.planName.get(i).getText();
			
			price[i]=tr.planPrice.get(i).getText();
	}
		for(int i=0;i<3;i++)
		{
			System.out.println(name[i]+" :"+price[i]);
			
		}
		dataDriven.writeData("policyBazaar.xlsx","Sheet2",company,name,price);
		
	}

		@Then("user is navigated to main page")
		public void user_is_navigated_to_main_page() {
		    tr.navigateToMainPage();
		}

	
	
}
