package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.poi.hwpf.usermodel.OfficeDrawing.HorizontalRelativeElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePageTest extends TestBase {
	
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	
	
	String sheetName = "ContactData";
	
	public  HomePageTest()   // this is a Constructor.
	{
		super(); 
	
	}

	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initialisation();
		
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password")); // Here, Login method is returning Home Page object.
		
	}
	
	
	// DataProvider fetches data from getCRMTestData method and returns 2 Dimensional Array.
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object data [] [] = TestUtil.getTestData(sheetName);
		return  data;
		
	}
	
	@Test(priority=1,enabled=true)
	public void verifyHomePageTitle()
	{
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Microsoft Dynamics 365","Home page title is not matched");
		
	}
	

	
	@Test(priority=2, dataProvider="getCRMTestData",enabled=false)
	public void verify_Creation_of_Licence_Breeder_Category_4(String Signature, String EmergencyContact, String EmergencyContactNumber, String Relationship,String StatutoryDeclaration,String kennel_Streetaddress) throws InterruptedException, IOException
	{
		
		homePage.click_ApplyforLicence();
		homePage.click_Breeders();
		homePage.select_BreederCat_4();
		Assert.assertTrue(homePage.verify_Presence_of_Greyhound_Breeder_Cat_4_Page());
		
		Assert.assertTrue(homePage.verify_Presence_of_AnimalWelfare_Page());
		homePage.complete_AnimalWelfare_Page(Signature);
		
		Assert.assertTrue(homePage.verify_Presence_of_File_Upload_Page());
		homePage.upload_Photo();
		
		Assert.assertTrue(homePage.verify_Presence_of_POI_Page());
		homePage.upload_POI();
		
		Assert.assertTrue(homePage.verify_Presence_of_NPC_Page());
		homePage.submit_NPC();
		
		Assert.assertTrue(homePage.verify_Presence_of_RTW_Page());
		homePage.submit_RTW();
		
		Assert.assertTrue(homePage.verify_Presence_of_EmergencyContactDetails_Page());
		homePage.submit_EmergencyContactDetails(EmergencyContact,EmergencyContactNumber,Relationship);
		
		Assert.assertTrue(homePage.verify_Presence_of_Written_Assessment_Getting_Started());
		homePage.submit_Written_Assessment_Getting_Started();
		
		Assert.assertTrue(homePage.verify_Presence_of_Contact_with_racing_control_bodies_Page());
		homePage.submit_RacingControlBodies_Page();
		
		Assert.assertTrue(homePage.verify_Presence_of_Disqualification_question_Page());
		homePage.submit_Disqualification_question_Page();
		
		Assert.assertTrue(homePage.verify_Consent_Questionnaire_Page());
		homePage.submit_Consent_Questionnaire_Page();
		
		Assert.assertTrue(homePage.verify_Criminal_History_Declaration_Page());
		homePage.submit_Criminal_History_Declaration_Page();
		
		Assert.assertTrue(homePage.verify_Statutory_Declaration_Page());
		homePage.submit_Statutory_Declaration_Page(StatutoryDeclaration);
		
		Assert.assertTrue(homePage.verify_Application_Complete());
			

	}
	
	
	@Test(priority=3, dataProvider="getCRMTestData",enabled=true)
   
	public void verify_Creation_of_STUDMASTER_LICENCE(String Signature, String EmergencyContact, String EmergencyContactNumber, String Relationship,String StatutoryDeclaration,String kennel_Streetaddress) throws InterruptedException, IOException
	{
		
		homePage.click_ApplyforLicence();
		homePage.click_Studmaster();
		Assert.assertTrue(homePage.verify_Presence_of_Studmaster_Page());
		
		Assert.assertTrue(homePage.verify_Presence_of_Kennel_Address_Page());
		homePage.complete_KennelAddress_Page(kennel_Streetaddress);
		
		Assert.assertTrue(homePage.verify_Presence_of_EmergencyContactDetails_Page());
		homePage.submit_EmergencyContactDetails(EmergencyContact,EmergencyContactNumber,Relationship);
		
		Assert.assertTrue(homePage.verify_Presence_of_Written_Assessment_Studmaster());
		homePage.submit_Written_Assessment_Studmaster();
		
		Assert.assertTrue(homePage.verify_Presence_of_Contact_with_racing_control_bodies_Page());
		homePage.submit_RacingControlBodies_Page();
		
		Assert.assertTrue(homePage.verify_Presence_of_Disqualification_question_Page());
		homePage.submit_Disqualification_question_Page();
		
		Assert.assertTrue(homePage.verify_Consent_Questionnaire_Page());
		homePage.submit_Consent_Questionnaire_Page();
		
		Assert.assertTrue(homePage.verify_Criminal_History_Declaration_Page());
		homePage.submit_Criminal_History_Declaration_Page();
		
		Assert.assertTrue(homePage.verify_Statutory_Declaration_Page());
		homePage.submit_Statutory_Declaration_Page(StatutoryDeclaration);
		
		Assert.assertTrue(homePage.verify_Payment_Page());
		homePage.submit_Payment();
		
		Assert.assertTrue(homePage.verify_Application_Complete());
			

	}
	
	
	
	@Test(priority=3,enabled=false)
	public void verifyCRM_Licence_Approval() throws InterruptedException
	{
		//WebDriver driver = new ChromeDriver();
		driver.get("https://qric-tst.crm6.dynamics.com/");
		homePage.validate_CrmLogin();
		homePage.clickRandleManager_app();
		homePage.clickLicences();
		homePage.validate_StaffApplications_View();
		homePage.ProcessApplication_Staff_To_Senior();
	// ************* From Senior Application view --- Applicant name is Ricky Ponting for BREEDER CAT 4 *****************************
		// Also Run the Code once, to check if Inactive Accounts View is still there to fix it..................
		
		//*********** from here...
		
		
		
		
		
		// From here click on Licences and further..
		
		
	}
	

	
	@Test(priority=4, dataProvider="getCRMTestData",enabled=false)
	public void verify_Create_New_Contact_TestCase(String FirstName, String LastName, String Email, String MobileNumber,String NoMobileNumber,String Search_Contact, String Update_JobTitle, String Update_Email) throws InterruptedException
	{

		homePage.clickNew();
		homePage.ContactLastName(LastName);
		homePage.ContactEmail(Email);
		homePage.ContactMobileNumber(MobileNumber);
		homePage.saveContact();
		Assert.assertTrue(homePage.verifyContactCreation());
		
	}


	@Test(priority=3, dataProvider="getCRMTestData",enabled=false)
	public void verify_All_Mandatory_fields_needed_for_Contact_creation_TestCase(String FirstName, String LastName, String Email, String MobileNumber,String NoMobileNumber,String Search_Contact, String Update_JobTitle, String Update_Email) throws InterruptedException
	
	{

		homePage.clickNew();
		homePage.ContactLastName(LastName);
		homePage.ContactEmail(Email);
		homePage.ContactMobileNumber(NoMobileNumber);
		homePage.saveContact();
		Assert.assertTrue(homePage.verifyContactCreation_Negative_Scenario());	
	
	}
	

	@Test(priority=4, dataProvider="getCRMTestData",enabled=false)
	public void verify_Create_Contact_Duplicate_Detection_TestCase(String FirstName, String LastName, String Email, String MobileNumber,String NoMobileNumber,String Search_Contact, String Update_JobTitle, String Update_Email) throws InterruptedException
	{
		
		homePage.clickNew();
		homePage.ContactLastName(LastName);
		homePage.ContactEmail(Email);
		homePage.ContactMobileNumber(MobileNumber);
		homePage.saveContact();
		Assert.assertTrue(homePage.Contact_DuplicateDetection());
		
	
	}
	
	
	@Test(priority=5, dataProvider="getCRMTestData",enabled=false)
	public void verify_Update_Contact_TestCase(String FirstName, String LastName, String Email, String MobileNumber,String NoMobileNumber,String Search_Contact,String Update_JobTitle, String Update_Email) throws InterruptedException
	{
		homePage.search_Contact_Record(Search_Contact,Update_JobTitle,Update_Email);
	}

	
	
	@AfterMethod
	public void teardown()
	{
		
		driver.quit();
		
	}
	
}
