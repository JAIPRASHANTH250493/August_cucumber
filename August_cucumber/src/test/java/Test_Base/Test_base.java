package Test_Base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test_base {

	public static WebDriver driver;
public static Logger log;

	public static void initializationMethod() {                                              

		System.setProperty("webdriver.chrome.driver","D:\\All selenium projects\\"           
				+ "ALL selenium projects\\com.cucumberproject\\DRIVER\\chromedriver.exe");   
		driver=new ChromeDriver();                                                           

		driver.manage().window().maximize();                                                 
		driver.manage().deleteAllCookies();                                                  
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://admin-demo.nopcommerce.com/login");

	}  

	public void gettitle() {
		
		
		String title=driver.getTitle();       
		System.out.println(title);            

	}


	public void checkurl() {

		String url=driver.getCurrentUrl();  
		System.out.println(url);            
	}
	
	
	public void screenshot() {
		TakesScreenshot screen=(TakesScreenshot)driver;


		File f=screen.getScreenshotAs(OutputType.FILE);
		File des=new File("D:\\Cumcumber\\August_cucumber\\ScreenShots\\allscreenshots"+System.currentTimeMillis()+".png");
		try {
			FileUtils.copyFile(f, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
