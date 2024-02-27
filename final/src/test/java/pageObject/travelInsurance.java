package pageObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.baseClass;
import base.dataDriven;

public class travelInsurance {

		 WebDriver driver;
		 Properties p;
		 WebDriverWait wait;
		 public static String arrtravel[]=new String[9];
		
		   
			public travelInsurance(WebDriver driver)
			{
				this.driver=driver;
				PageFactory.initElements(driver, this);
			}
			@FindBy(xpath="//*[@id='country']")
			public WebElement countrySearchBox;
			
			@FindBy(xpath="//*[@id='search-country']/ul/li")
			public List<WebElement> countryList;
			
			@FindBy(xpath="//*[@id='prequote-wrapper']/div[2]/div/div[2]/button")
			public WebElement nextButton;
			
			@FindBy(xpath="//*[@id='prequote-wrapper']/div[2]/div/div[1]/div/div[1]/div/div/input")
			public WebElement dateBox;
			
			@FindBy(xpath="/html/body/div[3]/div[2]/div/div/div[1]/div[1]/h6")
			public WebElement startMonth;
			
			@FindBy(xpath="/html/body/div[3]/div[2]/div/div/div[1]/div/div/div/div/div/button")
			public List<WebElement> startDates;
			
			@FindBy(xpath="/html/body/div[3]/div[2]/div/div/div[2]/div[1]/h6")
			public WebElement endMonth;
			
			@FindBy(xpath="/html/body/div[3]/div[2]/div/div/div[2]/div[1]/button[2]")
			public WebElement calendarNextButton;
			
			@FindBy(xpath="/html/body/div[3]/div[2]/div/div/div[2]/div[3]/div/div/div/div/button/span[1]")
			public List<WebElement> endDates;
			
			@FindBy(xpath="//*[@id='prequote-wrapper']/div[2]/div/div[1]/div[1]/div/label")
			public List<WebElement> noOfStudent;
			
			@FindBy(xpath="//*[@id='0']")
			public WebElement ageBox1;
			
			@FindBy(xpath="//*[@id='optionBox_0_wrapper']/div")
			public List<WebElement> ageOptn1;
			
			@FindBy(xpath="//*[@id='1']")
			public WebElement ageBox2;
			
			@FindBy(xpath="//*[@id='optionBox_1_wrapper']/div")
			public List<WebElement> ageOptn2;
			
			@FindBy(xpath="//*[@id='prequote-wrapper']/div[2]/div/div[1]/div/div")
			public List<WebElement> healthcondition;
			
			
			@FindBy(id="mobileNumber")
			public WebElement phnNo;
			
			
			@FindBy(xpath="//*[@id='prequote-wrapper']/div[2]/div/div[2]/div/button")
			public WebElement viewplan;
			
			@FindBy(xpath="//*[@id='prequote-wrapper']/div[2]/div/div[1]/div/div[2]/label")
			public WebElement medcond;
			
			
			
					
			public void getData() throws FileNotFoundException, IOException
			{
				wait=new WebDriverWait(driver,Duration.ofSeconds(10));
				arrtravel=dataDriven.readDataTravel("policyBazaar.xlsx");
				
			}
			
			public void chooseCountry() throws FileNotFoundException, IOException
			{
				getData();
				wait.until(ExpectedConditions.elementToBeClickable(countrySearchBox));
				countrySearchBox.click();
				
				for(int i=0;i<countryList.size();i++)
				{
					if(countryList.get(i).getText().equals(arrtravel[1]))
					{
						countryList.get(i).click();
						break;
					}
				}
				
			}
			
			public void clickNext()
			{
				//wait.until(ExpectedConditions.elementToBeClickable(nextButton));

				nextButton.click();
			}
			
			public void selectDate()
			{
				wait.until(ExpectedConditions.elementToBeClickable(dateBox));
				dateBox.click();
				String date1[]=null;
				String date2[]=null;
				date1=arrtravel[2].split("-");
				date2=arrtravel[3].split("-");
								
					if(startMonth.getText().contains(date1[1]))
						{
						
						for(int i=0;i<startDates.size();i++)
						{
							if(startDates.get(i).getText().equals(date1[0]))
							{
								startDates.get(i).click();
								break;
							}
						}
						}
				
			
			
			         
				int fx=0;
				while(fx!=1)
				{
					if(endMonth.getText().contains(date2[1]))
						{
							fx=1;
						
						for(int i=0;i<endDates.size();i++)
						{
							
							if(endDates.get(i).getText().equals(date2[0]))
							{
								endDates.get(i).click();
								break;
							}
						}
						}
					else
					{
						calendarNextButton.click();
					}
				
				}
					
			
         }
			
			public void selectNoOfStudents()
			{
				wait.until(ExpectedConditions.elementToBeClickable(noOfStudent.get(0)));
				String no=arrtravel[4].substring(0,1);
				for(int i=0;i<noOfStudent.size();i++)
				{
					
					if(noOfStudent.get(i).getText().equals(no))
					{
						noOfStudent.get(i).click();
						break;
					}
				}
			}
			
			public void selectAge1()
			{
				ageBox1.click();
				
				for(int i=0;i<ageOptn1.size();i++)
				{
					if(ageOptn1.get(i).getText().equals(arrtravel[5]))
					{
						ageOptn1.get(i).click();
						
						break;
					}
				}
			}
			
			public void selectAge2()
			{
				ageBox2.click();
				
				for(int i=0;i<ageOptn2.size();i++)
				{
					if(ageOptn2.get(i).getText().equals(arrtravel[6]))
					{
						ageOptn2.get(i).click();
						break;
					}
				}
			}
			
			
			public void selectMedicalCondition() throws InterruptedException
			{
				
				if(medcond.getText().equals(arrtravel[7]))
				medcond.click();
			}
			
			public void enterMobileNumber() throws IOException 
			{
				p=baseClass.getProperties();
				phnNo.sendKeys(p.getProperty("Phone"));
				
				
			}
			
			
			
			
}
