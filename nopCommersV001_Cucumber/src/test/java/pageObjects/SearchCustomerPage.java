package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.waitHelper;

public class SearchCustomerPage {
	public WebDriver ldriver;

	waitHelper waithelper;
	
	public SearchCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		
		
		waithelper=new waitHelper(ldriver);
	}
	
	@FindBy(how = How.ID,using="SearchEmail")
	WebElement txtEmail;
	
	@FindBy(how = How.ID,using="SearchFirstName")
	WebElement txtFirstName;
	
	@FindBy(how = How.ID,using="SearchLastName")
	WebElement txtLastName;
	
	@FindBy(how = How.ID,using="search-customers")
	WebElement btnSearch;
	
	
	@FindBy(how =How.XPATH,using="//table[@role=\"grid\"]")
	WebElement tblsearchresults;
	
	
	@FindBy(how =How.XPATH,using="//table[@id=\"customers-grid\"]")
	WebElement table;
	
	@FindBy(how =How.XPATH,using="//table[@id=\"customers-grid\"]//tbody/tr")
	List<WebElement> tableRows;
	
	@FindBy(how =How.XPATH,using="//table[@id=\"customers-grid\"]//tbody/tr/td")
	List<WebElement> tableColumn;
	
	
	
	public void setEmail(String email)
	{
		waithelper.waitforElement(txtEmail, 30);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void setFirstName(String fname)
	{
		waithelper.waitforElement(txtFirstName, 30);
		txtFirstName.clear();
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		waithelper.waitforElement(txtLastName, 30);
		txtLastName.clear();
		txtLastName.sendKeys(lname);
		
	}
	
	public void clicksearch()
	{
		btnSearch.click();
	}
	
	public int getnoofRows()
	{
		return (tableRows.size());
	}
	
	public int getnoofColoumn()
	{
		return (tableColumn.size());
	}
	
	public boolean serachCustomerbyEmail(String email)
	{
		boolean flage=false;
		
		for(int i=1;i<=getnoofRows();i++)
		{
			String emailid =table.findElement(By.xpath("//table[@id=\"customers-grid\"]//tbody/tr["+i+"]/td[2]")).getText();
		    System.out.println(emailid);
		
		if(emailid.equals(email))
		{
			flage=true;
		}
			
			}
		return flage;
		
	}
	
	
	public boolean  serachCustomerbyName(String name)
	{
boolean flage=false;
		
		for(int i=1;i<=getnoofRows();i++)
		{
			String Name =table.findElement(By.xpath("//table[@id=\"customers-grid\"]//tbody/tr["+i+"]/td[3]")).getText();
		    
			System.out.println(Name);
		    
		    String Names[]=Name.split(" ");
		
		if((Names[0].equals("James")) && (Names[1].equals("Pan")))
		{
			flage=true;
		}
			
			}
		return flage;
		
	}
	
}


