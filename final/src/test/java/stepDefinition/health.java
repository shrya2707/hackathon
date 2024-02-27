package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import base.baseClass;
import base.dataDriven;
import base.screenshot;
import io.cucumber.java.en.*;
import pageObject.home;


public class health {
	WebDriver driver;
	home h=new home(baseClass.getDriver());
	screenshot s=new screenshot(baseClass.getDriver());
	
	
	@When("user hovers over the insurance plans on main page")
	public void user_hovers_over_the_insurance_plans_on_main_page() throws InterruptedException, IOException {
		baseClass.getlogger().info("*****hovering over the insurance plans option on the main page**********");
		h.hoverOverInsurance();
		s.ScreenShots("healthInsOptions");
	}

	@When("finds health insurance option from the list")
	public void finds_health_insurance_option_from_the_list() {
		baseClass.getlogger().info("*****capturing the insurance options available**********");
	    h.healthMenuOptions();
	}

	@Then("all the options under health insurance are displayed")
	public void all_the_options_under_health_insurance_are_displayed() throws IOException {
		baseClass.getlogger().info("*****displaying the health insurance options available**********");
		String health[]=new String[h.healthinsoptn.size()];
		System.out.println("Health Insurance Options:");
		for(int j=0;j<h.healthinsoptn.size();j++)
		{
			System.out.println(h.healthinsoptn.get(j).getText());
			health[j]=h.healthinsoptn.get(j).getText();
		}
		dataDriven.writeDatahealth("policyBazaar.xlsx","Sheet2",health);
	}

}
