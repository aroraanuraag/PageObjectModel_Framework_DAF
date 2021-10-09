package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class Contact_Creation_Test extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactPage;
	
	String sheetName = "ContactData";
	
	
	
	public  Contact_Creation_Test()   // this is a Constructor.
	{
		super(); 
	
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initialisation();

		testUtil = new TestUtil();
		contactPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password")); // Here, Login method is returning Home Page object.
		//testUtil.switchToFrame();
		//contactPage = homePage.createContactsCRM();  // As clickOnContactsTab functions is written inside Home page,hence this is called in this way here.
		
	}
	
	
/*	@Test(priority=4)
	public void verifyContactsLabelTest()
	{
		Assert.assertTrue(contactPage.verifyContactsLabel(),"Contacts Label is missing on the Page");  // This Assert will Pass if the ContactsLabel is displayed or not i.e True or False.
	}
	
	
	@Test(priority=2)
	public void selectSingleContactsTest()
	{
		contactPage.selectContactsByName("t t");
	}
	

	@Test(priority=3)
	public void selectMultipleContactsTest()
	{
		contactPage.selectContactsByName("t t");
		contactPage.selectContactsByName("S S");
	}
	*/
	
	
	
	/*
	// DataProvider fetches data from getCRMTestData method and returns 2 Dimensional Array.
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object data [] [] = TestUtil.getTestData(sheetName);
		return  data;
		
	}*/
	
	
	//IMP Note: If you are using dataprovider, then if your Excel is having 4 columns then you have to give those 4 Columns below in  the @Test also mandatorily. 
	
	@Test(priority=1, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String FirstName, String LastName, String Email, String MobilePhone) throws InterruptedException
	
	{
		contactPage.createContactsCRM(FirstName,LastName,Email,MobilePhone);
		driver.get("C:\\Users\\Anuraag.Arora\\Documents\\Automation Framework-Final worked on\\eclipse-workspace\\DynamicsCRM_Automation2\\test-output\\CRM HTML Report\\CRM_Automation.html");
		
	}
	
	// Similarly further we can Validate whether Contacts are created or not using Assert.
	//And we can do same above thing for 2nd and 3rd Tab of Excel which is for 'DEALS' and 'TASKS'.
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
		
	}
	
	

}
