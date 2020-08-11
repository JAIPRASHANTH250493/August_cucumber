package WebElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Test_Base.Test_base;

public class Adding_product extends Test_base{

	public Adding_product() {
		PageFactory.initElements(driver, this);
	}

	private	By catalog=By.xpath("//ul[@class='sidebar-menu tree']/li[2]/a");
	private By product=By.xpath("//ul[@class='sidebar-menu tree']/li[2]/ul/li");
	private By addnew=By.xpath("//div[@class='pull-right']/a");

	private By productinfo=By.xpath("//div[@class='form-horizontal']/nop-panels/nop-panel[1]");
	                                 ///html/body/div[3]/div[3]/div[2]/form[1]/div[1]/div/a
	private By productname=By.xpath("//*[@id=\"Name\"]");
	private By productdes=By.xpath("//*[@id=\"ShortDescription\"]");
	private By cat=By.id("SelectedCategoryIds");

	private By priceinfo=By.xpath("//div[@class='form-horizontal']/nop-panels/nop-panel[2]");
	private By price=By.xpath("//*[@id=\"product-price\"]/div[2]/div/div[1]/div/div[1]/div[2]/span[1]/span/span[2]/span[1]/span");
	private By pricedes=By.id("DisableWishlistButton");
	private By callforprice=By.id("CallForPrice");


	private By save=By.xpath("//div[@class='content-header clearfix']//div/button[@name='save']");

	//prodctdescription

	private By checktext=By.xpath("//div[@class='alert alert-success alert-dismissable']");





	public void catalogmethod() {
		driver.findElement(catalog).click();

	}

	public void productmehtod() {
		List<WebElement> li=driver.findElements(product);
		int size=li.size();
		System.out.println(size);
		for (WebElement text : li) {
			String textof=	text.getText();
			System.out.println(textof);
			if(textof.equals("Products")) {
				text.click();
				break;
			}

		}

	}

	public void addnewmethod() {

		driver.findElement(addnew).click();

	}
	public void prodcutdetails(String productname1,String des,String tag) {

		driver.findElement(productinfo).click();
		driver.findElement(productname).sendKeys(productname1);
		driver.findElement(productdes).sendKeys(des);
		WebElement tagsis=	driver.findElement(cat);

		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);",tagsis);
		Select s=new Select(tagsis);
		s.deselectByIndex(4);
		WebElement pro=	driver.findElement(productinfo);
		je.executeScript("arguments[0].scrollIntoView(true);",pro);

		pro.click();
	}


	public void pricedetails() {
		driver.findElement(priceinfo).click();

		for(int i=0;i<3;i++) {
			driver.findElement(price).click();
		}

		driver.findElement(pricedes).click();
		WebElement web=	driver.findElement(callforprice);
		boolean b=web.isSelected();
		System.out.println(b);
		web.click();
		driver.findElement(priceinfo).click();
	}

	public void savemethod() {
		driver.findElement(save).click();
		String text=driver.findElement(checktext).getText();
		System.out.println(text);
	}


}
