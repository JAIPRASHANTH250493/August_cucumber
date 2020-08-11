package WebElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Test_Base.Test_base;

public class Login_webelements extends Test_base {


	public Login_webelements() {
		PageFactory.initElements(driver, this);
	}


	@FindBy(id="Email")
	private WebElement email;

	@FindBy(id = "Password")
	private WebElement password;

	@FindBy(xpath = "/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/input")
	public WebElement buton;

	public void emailmethod(String emailadress,String pwd) {

		email.clear();
		password.clear();

		email.sendKeys(emailadress);
		password.sendKeys(pwd);

	}

	public void butonmethod() {

		buton.click();
	}
}
