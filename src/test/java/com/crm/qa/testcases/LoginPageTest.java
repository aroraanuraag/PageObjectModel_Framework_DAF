package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class LoginPageTest extends TestBase 
{
	LoginPage loginpage;
	HomePage homePage;
	
	
	String sheetName = "LoginData";
	
	public  LoginPageTest()   // this is a Constructor.
	{
		super();  
	}
	
	
	@BeforeMethod
	public void setup()
	{
		initialisation();
		
		loginpage = new LoginPage();    
		
	}

	
	@Test(priority=1,enabled=true)
	public void loginTest() throws InterruptedException
	{
		homePage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));

	}
		
	

	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
		
	}

}
