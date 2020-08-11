package hooks;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Test_Base.Test_base;
import cucumber.api.Scenario;
import cucumber.api.java.After;

public class hooks extends Test_base{

	@After
	public void afterscenario(Scenario scenario) throws IOException {

		String status=scenario.getStatus();
		System.out.println(status);
		if(scenario.isFailed()==true) {
			TakesScreenshot screen=(TakesScreenshot)driver;


			File f=screen.getScreenshotAs(OutputType.FILE);
			File des=new File("D:\\Cumcumber\\August_cucumber\\ScreenShots"+scenario.getName()+".png");
			FileUtils.copyFile(f, des);

			byte[] b=screen.getScreenshotAs(OutputType.BYTES);
			scenario.embed(b, "image/png");

		}


	}


	@After
	public void screenshot(Scenario sce){
		TakesScreenshot screen=(TakesScreenshot)driver;
		byte[] b=screen.getScreenshotAs(OutputType.BYTES);
		sce.embed(b, "image/png");
	}
}
