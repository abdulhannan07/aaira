package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="uid")
	WebElement txtUsername;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	WebElement BtnLogin;
	
	@FindBy(linkText="Log out")
	WebElement BtnLogout;
	
	public void user(String username) {
		txtUsername.sendKeys(username);
	}
	
	public void passWord(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void logIn() {
		BtnLogin.click();
	}
	
	public void logOut() {
		BtnLogout.click();
	}
	

}
