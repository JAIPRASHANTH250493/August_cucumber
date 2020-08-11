package StepDefinition;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Test_Base.Test_base;
import WebElements.Adding_product;
import WebElements.Login_webelements;
import cucumber.api.java.en.*;

public class Login_Stepdefinition_class extends Test_base {
	


	public static Logger log;

	Login_webelements login;
	Login_Stepdefinition_class step_login;
	Adding_product add_product;
	

	FileInputStream file;
	XSSFWorkbook book;
	XSSFSheet sheet;

	public Login_Stepdefinition_class(){
	

		try {
			file=new FileInputStream("C:\\Users\\New\\Desktop\\cucumbersheet\\jai.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book=new XSSFWorkbook(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet=book.getSheet("cucumber");
	}



	@Given("^User launching the chromedriver and enters the url$")
	public void user_launching_the_chromedriver_and_enters_the_url(){
		
		step_login=new Login_Stepdefinition_class();
		login=new Login_webelements();
		add_product=new Adding_product();
		initializationMethod();
	}

	@When("^user enters the emailid & password \"([^\"]*)\" & \"([^\"]*)\"$")
	public void user_enters_the_emailid_password(String arg1, String arg2){
		WebElement emailid=driver.findElement(By.xpath("//*[@id=\"Email\"]"));
		emailid.clear();
		emailid.sendKeys(arg1);

		WebElement passkey=driver.findElement(By.xpath("//*[@id=\"Password\"]"));
		passkey.clear();
		passkey.sendKeys(arg2);



	}

	@Then("^User clicks on the Signinbutton$")
	public void user_clicks_on_the_Signinbutton(){
		WebElement button=driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/input"));

		button.click();

	}

	@Then("^User could see the loggedin page and checks the title$")
	public void user_could_see_the_loggedin_page_and_checks_the_title() throws InterruptedException{

		step_login.gettitle();

	}

	@Then("^User selects catalog from the list and clicks on the product button$")
	public void user_selects_catalog_from_the_list_and_clicks_on_the_product_button() {
		add_product.catalogmethod();
		add_product.productmehtod();
	}

	@Then("^User clicks on the add new product button$")
	public void user_clicks_on_the_add_new_product_button(){
		System.out.println("addnew product button is goign to beclicked");

	}

	@Then("^User gives the product details and description ,product price and clicks on savebutton$")
	public void user_gives_the_product_details_and_description_product_price_and_clicks_on_savebutton() {

		int rownum=sheet.getLastRowNum();

		for(int i=1;i<=rownum;i++) {
			add_product.addnewmethod();
			String productnamecell=	sheet.getRow(i).getCell(0).getStringCellValue();
			String productdescription=	sheet.getRow(i).getCell(1).getStringCellValue();
			String tagss=sheet.getRow(i).getCell(2).getStringCellValue();
			add_product.prodcutdetails(productnamecell,productdescription, tagss);

			add_product.pricedetails();
			add_product.savemethod();

		}
	}

	@Then("^User asserts now$")
	public void user_asserts_now(){

		driver.getTitle();
		System.out.println(driver.getTitle());
		
		WebElement logout=driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/ul/li[3]/a"));
		Actions ac=new Actions(driver);
		ac.moveToElement(logout);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logout.click();
	}


}
