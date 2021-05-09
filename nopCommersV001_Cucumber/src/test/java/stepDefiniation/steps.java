package stepDefiniation;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.AddCustomerpage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;


public class steps extends baseClass {
	
	
	@Before
	public void setup() throws IOException
	{
		
		prop= new Properties();
		FileInputStream file= new FileInputStream("config.properties");
		prop.load(file);
				
		logger=Logger.getLogger("nopCommers");
		PropertyConfigurator.configure("log4j.properties");
		
		String br=prop.getProperty("browser");
		
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromepath"));
		logger.info("lanching chrome browser");
		driver =new ChromeDriver();
		}
		else if (br.equals("firefox"))
		{System.setProperty("webdriver.firefox.driver", prop.getProperty("firefoxpath"));
		logger.info("lanching Firefox browser");
		driver =new FirefoxDriver();
			
		}
		
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", prop.getProperty("iepath"));
			logger.info("lanching ie browser");
			driver =new InternetExplorerDriver();
				
			
		}
		
	}
	

	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		
		lp =new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		logger.info("lanching url");
		driver.get(url);
	}
	    

	@When("User enters Email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as_admin(String uname,String pass) {
	    
		lp.setUserName(uname);
		lp.setPassword(pass);
	}

	@When("Click on Login")
	public void click_on_login() {
		logger.info("clk on login");
	    lp.cliclLogin();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
	   
		if(driver.getPageSource().contains("Login was unsuccessfull"))
		{
			
			Assert.assertTrue(false);
			driver.close();
		}
		else
		{
			Assert.assertEquals(title,driver.getTitle());
		}
		
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		logger.info("clk on logout");
	   lp.clickLogout();
	   Thread.sleep(300);
	}

	
	@Then("close browser")
	public void close_browser() {
	    driver.quit();
	}

	
	//Create the Customer

@Then("User can view Dashboard")
public void user_can_view_dashboard() {
	
	addcust =new AddCustomerpage(driver);
	
	Assert.assertEquals("Dashboard / nopCommerce administration", addcust.getTitle());
	
}


@When("User click on Customer Menu")
public void user_click_on_customer_menu() {
	addcust.clickonCustomerMenue();
    
}
@When("User click on Customer Menu Item")
public void user_click_on_customer_menu_item() {
	logger.info("clk on customer");
	addcust.clickonCustomerItem();
   
}
@When("User clikc on Add new button")
public void user_clikc_on_add_new_button() {
	addcust.clickonAddnew();
    
}
@Then("User can view Add new Customer page")
public void user_can_view_add_new_customer_page() {
	Assert.assertEquals("Add a new customer / nopCommerce administration", addcust.getTitle());
    
}
@When("User enter Customer info")
public void user_enter_customer_info() throws InterruptedException {
	
	String email=randamString()+"@gmail.com";
	addcust.setEmail(email);
	addcust.setGender("Male");
	addcust.setPassword("Test123");
	addcust.setcustrole("Guests");
	addcust.firstName("java");
	addcust.lastName("Sham");
	addcust.setbod("03/21/1990");
	addcust.setcmpname("BYQA");
	addcust.setAdmincomments("Created for test");
	
	
    
}
@When("Click on save button")
public void click_on_save_button() throws InterruptedException {
	
	addcust.clickonSave();
	Thread.sleep(300);
    
}
@Then("User cna view confirmation message {string}")
public void user_cna_view_confirmation_message(String msg) {
    
	Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));
}

//search Customer by emailid

@When("Enter Customer Emailid")
public void enter_customer_emailid() {
	serachcust=new SearchCustomerPage(driver);
	
	serachcust.setEmail("victoria_victoria@nopCommerce.com");
    
}




@When("User click on search button")
public void user_click_on_search_button() throws InterruptedException {
	
	serachcust.clicksearch();
	
	Thread.sleep(300);
   
}
@Then("User should found Email in the Search Table")
public void user_should_found_email_in_the_search_table() {
   
	boolean status = serachcust.serachCustomerbyEmail("victoria_victoria@nopCommerce.com");
	
	Assert.assertEquals(true,status);
}

//Search Customer by Name

@When("Enter Customer FirstName")
public void enter_customer_first_name() {
	serachcust=new SearchCustomerPage(driver);
	serachcust.setFirstName("James");
}




@When("Enter Customer LastName")
public void enter_customer_last_name() {
	
	serachcust.setLastName("Pan");
    
}
@Then("User should found Name in the Search Table")
public void user_should_found_name_in_the_search_table() {
	
	boolean satus=serachcust.serachCustomerbyName("James Pan");
	
	Assert.assertEquals(true, satus);
    
}






}
