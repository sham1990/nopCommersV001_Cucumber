package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerpage {
public WebDriver ldriver;
	
	public AddCustomerpage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	By link_customermenu= By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	
	By link_customermenu_item = By.xpath("//a[@href=\'/Admin/Customer/List\']//p[contains(text(),'Customers')]");
	
	By btn_addnewbutton =By.xpath("//a[@href=\"/Admin/Customer/Create\"]");
	
	By txt_Email =By.xpath("//input[@id=\"Email\"]");
	
	By txt_pass =By.xpath("//input[@id=\"Password\"]");
	
	By txt_firstname =By.xpath("//input[@id=\"FirstName\"]");
	
	By txt_lastname =By.xpath("//input[@id=\"LastName\"]");
	
	By rd_gendermail =By.xpath("//input[@id=\"Gender_Male\"]");
	
	By rd_genderfemale =By.xpath("//input[@id=\"Gender_Female\"]");
	
	By txt_dateodbirth =By.xpath("//input[@id=\"DateOfBirth\"]");
	
	By txt_company =By.xpath("//input[@id=\"Company\"]");
	
	By check_Tax =By.xpath("//input[@id=\"IsTaxExempt\"]");
	
	By txt_newsletter =By.xpath("//ul[@id=\"SelectedNewsletterSubscriptionStoreIds_taglist\"]");
	
	By newslist1 =By.xpath("//li[contains(text(),'Your store name')");
	
	By newslist2 = By.xpath("//li[contains(text(),'Test store 2')]");
	
	By txt_customergroup = By.xpath("//div[@class=\"input-group-append input-group-required\"]");
	
	By listitem_vendors =By.xpath("//li[contains(text(),\"Vendors\")]");
	
	By listitem_Registered =By.xpath("//li[contains(text(),\"Registered\")]");
	
	//By listitem_Guests =By.xpath("//span[contains(text(),\"Guests\")]");
	By listitem_Guests =By.xpath("//li[contains(text(),\"Guests\")]");
	
	By listitem_ForumModerators = By.xpath("//li[contains(text(),\"Forum Moderators\")]");
	
	By  listitem_Administrators =  By.xpath("//li[contains(text(),\"Administrators\")]");
	
	
	By txt_AdminComment = By.xpath("//textarea[@id=\"AdminComment\"]");
	
	By btn_save =By.xpath("//button[@name=\"save\"]");
	
	
	public String getTitle()
	{
		return ldriver.getTitle();
	}
	
	public void clickonCustomerMenue()
	{
		ldriver.findElement(link_customermenu).click();
	}
	
	public void clickonCustomerItem()
	{
		ldriver.findElement(link_customermenu_item).click();
	}
	
	public void clickonAddnew()
	{
		ldriver.findElement(btn_addnewbutton).click();
	}
	
	public void setEmail(String email)
	{
		ldriver.findElement(txt_Email).sendKeys(email);
	}
	
	public void setPassword(String pass)
	{
		ldriver.findElement(txt_pass).sendKeys(pass);
	}
	
	public void firstName(String fname)
	{
		ldriver.findElement(txt_firstname).sendKeys(fname);
		
	}
	
	public void lastName(String lname)
	{
		ldriver.findElement(txt_lastname).sendKeys(lname);
	}
	
	public void setGender(String gender)
	{
		if(gender.equals("Male"))
		{
			ldriver.findElement(rd_gendermail).click();
		}
		else if  (gender.equals("Female"))
		{
		ldriver.findElement(rd_genderfemale).click();
		}
		else
		{
			ldriver.findElement(rd_gendermail).click();
		}
			
			
	}
	
	public void setbod(String bod )
	{
		ldriver.findElement(txt_dateodbirth).sendKeys(bod);
	}
	
	public void setcmpname(String comp)
	{
		ldriver.findElement(txt_company);
		
	}
	
	
	public void setcustrole(String role) throws InterruptedException
	{
		if(!role.equals("Vendors"))
		{
			Thread.sleep(300);
			//ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span/span[@class=\"k-icon k-i-close\"]")).click();
			ldriver.findElement(By.xpath("//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/span[2]")).click();
			
			
		}
		
		ldriver.findElement(txt_customergroup).click();
		
		Thread.sleep(300);
		
		WebElement  listitem;
		
		if(role.equals("Vendors"))
		{
			listitem=ldriver.findElement(listitem_vendors);
		}
		else if(role.equals("Registered"))
		{
			listitem=ldriver.findElement(listitem_Registered);
		}
		else if(role.equals("Guests"))
		{
			listitem=ldriver.findElement(listitem_Guests);
		}
		
		else if(role.equals("Forum Moderators"))
		{
			listitem=ldriver.findElement(listitem_ForumModerators);
		}
		else if(role.equals("Administrators"))
		{
			listitem=ldriver.findElement(listitem_Administrators);
		}
		else
		{
			listitem=ldriver.findElement(listitem_Guests);	
		}
		
		listitem.click();
		
		//JavascriptExecutor js=(JavascriptExecutor)ldriver;
		//js.executeScript("argument[0].click;", listitem);
		
		Thread.sleep(300);
		
	}
	
	public void setAdmincomments(String comments)
	{
		ldriver.findElement(txt_AdminComment).sendKeys(comments);
	}
	
	public void clickonSave()
	{
		ldriver.findElement(btn_save).click();
	}
	
	
	
	
	
	
	
			
}
