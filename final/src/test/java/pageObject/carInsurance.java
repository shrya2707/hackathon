package pageObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.baseClass;
import base.dataDriven;

public class carInsurance {

		 WebDriver driver;
		 Properties p;
		 public static String arrcar[]=new String[6];
		   
			public carInsurance(WebDriver driver)
			{
				this.driver=driver;
				PageFactory.initElements(driver, this);
			}
			
			
			@FindBy(xpath="//*[@id='before-tp']/div[2]/a")
			public WebElement newCar;
			
			@FindBy(xpath="//*[@id='dvRTO']/div/ul/li/span")
			public List<WebElement> carCity;
			
			@FindBy(xpath="//*[@id='section1']/ul/li/span")
			public List<WebElement> carNo;
			
			@FindBy(xpath="//*[@id='dvMake']/div/ul/div/li")
			public List<WebElement> carModel;
			
			@FindBy(xpath="//*[@id='modelScroll']/li")
			public List<WebElement> carModelType;
			
			@FindBy(xpath="//*[@id='variantScroll']/li")
			public List<WebElement> carModelType1;
			
			@FindBy(xpath="//*[@id='name']")
			public WebElement name;
			
			@FindBy(xpath="//*[@id='email']")
			public WebElement email;
			
			@FindBy(xpath="//*[@id='mobileNo']")
			public WebElement mobileNo;
			
			@FindBy(xpath="//*[@id='dvVariant']/div[2]/div[1]/div[2]/div[2]")
			public WebElement emailError;
			
			@FindBy(xpath="//*[@id='btnLeadDetails']")
			public WebElement submitButton;
			
			@FindBy(xpath="//*[@id='rootSubDiv']/div[1]/div[1]/div[1]/a[2]")
			public WebElement homepage;
			
			
			@FindBy(xpath="//*[@id='rootSubDiv']/div[1]/div[1]/div[1]/a[2]")
			public WebElement mainPageIcon1;
			
			public void getData() throws FileNotFoundException, IOException
			{
				arrcar=dataDriven.readDataCar("policyBazaar.xlsx");
				
			}
			
			public void clickOnNewCar() throws FileNotFoundException, IOException
			{
				getData();
				newCar.click();
			}
			
			public void selectCity()
			{
				for(int i=0;i<carCity.size();i++)
				{		String s=carCity.get(i).getText();
				if(s.equals(arrcar[1]))
					{
					carCity.get(i).click();
						break;
					}
				}
			}
			
			public void selectCarNo()
			{
				for(int i=0;i<carNo.size();i++)
				{		String s=carNo.get(i).getText();
				if(s.equals(arrcar[2]))
					{
					carNo.get(i).click();
						break;
					}
				}
			}
			
			public void selectCarModel()
			{
				for(int i=0;i<carModel.size();i++)
				{		String s=carModel.get(i).getText();
				if(s.equals(arrcar[3]))
					{
					carModel.get(i).click();
						break;
					}
				}
			}
			
			public void selectCarModelType()
			{
				for(int i=0;i<carModelType.size();i++)
				{		String s=carModelType.get(i).getText();
				if(s.equals(arrcar[4]))
					{
					carModelType.get(i).click();
						break;
					}
				}
			}
			public void selectCarModelType1()
			{
				for(int i=0;i<carModelType1.size();i++)
				{		String s=carModelType1.get(i).getText();
				if(s.equals(arrcar[5]))
					{
					carModelType1.get(i).click();
						break;
					}
				}
			}
			
			public void personalDetails() throws IOException
			{
				p=baseClass.getProperties();
				name.sendKeys(p.getProperty("name"));
				email.sendKeys(p.getProperty("Email"));
				mobileNo.sendKeys(p.getProperty("Phone"));
				submitButton.click();
			}
			
			public void naviagteToMainPage1()
			{
				mainPageIcon1.click();
			}
}
