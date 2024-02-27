package base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenshot {
	
	WebDriver driver;
	
	public screenshot(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void ScreenShots(String fileName) throws IOException {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File trg= new File(System.getProperty("user.dir")+"\\screenShot\\"+ fileName+".png");
		FileUtils.copyFile(src, trg);
		
		

}

}
