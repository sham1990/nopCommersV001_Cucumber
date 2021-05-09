package stepDefiniation;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerpage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class baseClass {
	
	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerpage addcust;
	public SearchCustomerPage serachcust;
	
	public static Logger logger;
	
	public Properties prop;
	
	
	public  String  randamString()
	{
		
		String randamstring = RandomStringUtils.randomAlphabetic(8);
		
		return randamstring;
		
	}
	
	
	

}
