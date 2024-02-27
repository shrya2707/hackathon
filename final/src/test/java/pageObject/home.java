package pageObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.dataDriven;

public class home {

	 WebDriver driver;
	 String exceltravel[]=new String[8];
	 String excelcar[]=new String[6];
	   
		public home(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="/html/body/main/div[2]/section/div[7]/a/div[1]")
		public WebElement scroll;
		
		@FindBy(xpath="/html/body/main/div[2]/section/div")
		public List<WebElement> mainoptn;
		
		@FindBy(xpath="/html/body/div[5]/div[2]/div/ul/li[2]/a")
		public WebElement hoverinsurance;
		
		@FindBy(xpath="/html/body/div[5]/div[2]/div/ul/li[2]/div/div/div/h3/a")
		public List<WebElement> healthins;
		
		@FindBy(xpath="/html/body/div[5]/div[2]/div/ul/li[2]/div/div/div[3]/ul/li/a/span")
		public List<WebElement> healthinsoptn;
		
		public void getData() throws FileNotFoundException, IOException
		{
			exceltravel=dataDriven.readDataTravel("policyBazaar.xlsx");
			excelcar=dataDriven.readDataCar("policyBazaar.xlsx");
			
		}
		
		public void scrollDown() throws FileNotFoundException, IOException
		{
			getData();
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();",scroll);

		}
		
		
		public void selectTravelInsOption()
		{
			String excelTravel[]=null;
			excelTravel=exceltravel[0].split(" ");
			
			for(int i=0;i<mainoptn.size();i++)
			{		String s=mainoptn.get(i).getText();
			if(s.contains(excelTravel[0]))
				{
				mainoptn.get(i).click();
					break;
				}
			}
		}
		
		public void selectCarInsOption()
		{
			String excelCar[]=null;
			excelCar=excelcar[0].split(" ");
		for(int i=0;i<mainoptn.size();i++)
		{		String s=mainoptn.get(i).getText();
		if(s.contains(excelCar[0]))
			{
			mainoptn.get(i).click();
				break;
			}
		}
		}
		
		public void hoverOverInsurance() throws InterruptedException
		{
			Actions act=new Actions(driver);
			act.moveToElement(hoverinsurance).perform();
			Thread.sleep(2000);
		}
		
		public void healthMenuOptions()
		{
			for(int i=0;i<healthins.size();i++)
			{		
				if(healthins.get(i).getText().contains("Health"))
				{
				System.out.println("The health options available are "+healthinsoptn.size());
				}
			}
		}
		
		
}