package pageObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.dataDriven;

public class travelInsurance_result {

		 WebDriver driver;
		 WebDriverWait wait;
		 public static String arrtravel_result[]=new String[9];
		 
		 public travelInsurance_result(WebDriver driver)
			{
				this.driver=driver;
				PageFactory.initElements(driver, this);
			}
		 
		 @FindBy(xpath="//*[@id='root']/div/div[1]/div/h2")
			public WebElement resultPageTitle;
			
			@FindBy(xpath="//p[@class='filter_name_heading']")
			public WebElement sortBy ;
			
			@FindBy(xpath="//*[@id='root']/div/div[2]/aside/section[1]/details/ul/li")
			public List<WebElement> filterOptn;
			
			@FindBy(xpath="//div[@class='quotesCard__planName']/div/p[1]")
			public List<WebElement> companyName;
			
			@FindBy(xpath="//span[@class='premiumPlanPrice']")
			public List<WebElement> planPrice;
			
			@FindBy(xpath="//div[@class='quotesCard__planName']/div/p[2]")
			public List<WebElement> planName;
			
			
			@FindBy(xpath="//label[@for='studentTrip']")
			public WebElement studentPlan ;
			
			@FindBy(xpath="//*[@id='modal-root']/div/div/span")
			public WebElement waitCondn ;
			
			
			@FindBy(xpath="//input[@id='Traveller_1']")
			public WebElement stuVisa1 ;
			
			@FindBy(xpath="//input[@id='Traveller_2']")
			public WebElement stuVisa2 ;
			
			@FindBy(xpath="//select[@id='feet']")
			public WebElement duration ;
			
			@FindBy(xpath="//button[normalize-space()='Apply']")
			public WebElement applyBttn ;
			
			@FindBy(xpath="//*[@id='root']/div/header/article/h1/a")
			public WebElement mainPageIcon ;
			
			
			public void getData() throws FileNotFoundException, IOException
			{
				arrtravel_result=dataDriven.readDataTravel("policyBazaar.xlsx");
				
				
			}
			
			
			public void studentPlanFilter()
			{ 
				wait=new WebDriverWait(driver,Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(studentPlan));
		
		       studentPlan.click();
			}
			
			public void visaOption()
			{
				
		 
				//wait.until(ExpectedConditions.elementToBeClickable(waitCondn));
				//waitCondn.click();
		 
				stuVisa1.click();
				stuVisa2.click();
			}
			
			public void durationOptn()
			{
		 
				// selecting number of days
				wait.until(ExpectedConditions.elementToBeClickable(duration));
				
				Select menu = new Select(duration);
				menu.selectByIndex(2);
				 
				applyBttn.click();	
			}
			
			public void filter() throws FileNotFoundException, IOException, InterruptedException
			{
				getData();
				Thread.sleep(2000);
				 
				wait.until(ExpectedConditions.elementToBeClickable(sortBy));
				sortBy.click();
				Thread.sleep(2000);
				System.out.println(arrtravel_result[8]);
				for(int i=0;i<filterOptn.size();i++)
				{
					
					if(filterOptn.get(i).getText().equals("Premium low to high"))
					{
						filterOptn.get(i).click();
						break;
					}
				}
			}
			
			public void navigateToMainPage()
			{
				mainPageIcon.click();
			}

}
