package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	@FindBy(id ="Email")
    WebElement txtxEmail;
	
	@FindBy(id ="Password")
	WebElement txtxPassword;
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement btnLogin;
	
	@FindBy(linkText="Logout")
	WebElement lnkLogout;
	
	public void setUserName(String uname)
	{txtxEmail.clear();
	txtxEmail.sendKeys(uname);
		
	}
	
	public void setPassword(String pass)
	{
		txtxPassword.clear();
		txtxPassword.sendKeys(pass);
		
	}
	
	public void cliclLogin()
	{
		btnLogin.click();
		
	}
	
	public void clickLogout()
	{
		lnkLogout.click();	
	}
}
