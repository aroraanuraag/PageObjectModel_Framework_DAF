package com.crm.qa.pages;

import static org.testng.Assert.assertTrue;

import java.awt.Desktop.Action;
import java.awt.RenderingHints.Key;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.ActionChainExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.Helper;
import com.crm.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

public class HomePage extends TestBase{
	
	//WebDriverWait wait = new WebDriverWait(driver, 10000);
	
	ExtentReports report;
	ExtentTest logger;
	
	
	@FindBy(xpath="//a[@class='list-group-item' and @href='/apply/']")
	WebElement clickApply_for_Licence_Option;
	
	@FindBy(xpath="//a[@id='my_greyhound']")
	WebElement clickGreyhound;
	
	
	@FindBy(xpath="//a[contains(text(),'Breeders')]")
	WebElement select_Breeders;
	
	
	//@FindBy(xpath="//a[contains(text(),'Breeder category 4')]")
	@FindBy(xpath="//a[@id='button4']")
	WebElement select_BreederCat_4;
	
	
	@FindBy(xpath="//a[contains(text(),'Studmaster')]")
	WebElement clickStudmaster;
	
	
	@FindBy(xpath="//h1[contains(text(),'Greyhound Breeder Category 4 application')]")
	WebElement verify_GH_Breeder_CAT4_Page;
	
	//@FindBy(xpath="//div[contains(text(),'Greyhound Studmaster')]")
	@FindBy(xpath="html/body/form/div[3]/div[2]/div/div[2]/div[3]/div/div[2]/h1")
	WebElement verify_GH_Studmaster_Page;
	
	@FindBy(xpath="//h1[contains(text(),'Animal Welfare statutory declaration')]")
	WebElement verify_Animal_Welfare_Page;
	
	
	@FindBy(xpath="//h1[contains(text(),'Add new kennelling address')]")
	WebElement verify_KennelAddress_Page;
	
	
	@FindBy(xpath="//h1[contains(text(),'Upload a photo')]")
	WebElement verify_File_Upload_Page;
	
	@FindBy(xpath="//h1[contains(text(),'Proof of Identity (POI)')]")
	WebElement verify_POI_Page;
	
	@FindBy(xpath="//h1[contains(text(),'National Police Check (NPC) certificate')]")
	WebElement verify_NPC_Page;
	
	
	@FindBy(xpath="//h1[contains(text(),'Right to work in Australia (RTW)')]")
	WebElement verify_RTW_Page;
	
	@FindBy(xpath="//h1[contains(text(),'Emergency contact details')]")
	WebElement verify_Emergency_Contacts_Page;
	
	@FindBy(xpath="//h1[contains(text(),'Written Assessment - Getting Started')]")
	WebElement verify_WrittenAssessment_GettingStartedPage;
	
	
	@FindBy(xpath="//h1[contains(text(),'Written Assessment - Greyhound Studmaster')]")
	WebElement verify_WrittenAssessment_Studmaster_Page;
	
	
	@FindBy(xpath="//h1[contains(text(),'Contact with racing control bodies')]")
	WebElement verify_Contact_with_racing_control_bodies_Page;
	
	
	@FindBy(xpath="//h1[contains(text(),'Disqualification question')]")
	WebElement verify_Disqualification_question_Page;
	
	@FindBy(xpath="//h1[contains(text(),'Consent questionnaire')]")
	WebElement verify_ConsentQuestionnaire_Page;
	

	@FindBy(xpath="//h1[contains(text(),'Criminal history declaration')]")
	WebElement verify_Criminal_History_Declaration_Page;
	
	//@FindBy(xpath="//h1[contains(text(),'Statutory Declaration')]")
	@FindBy(xpath="//h1[@data-bind='html: Title']")
	WebElement verify_Statutory_Declaration_Page;
	
	@FindBy(xpath="//h1[@id='portal_wp_name_h1']")
	WebElement verify_Payment_Page;
	
	@FindBy(xpath="//button[contains(text(),'Already paid')]")
	WebElement clickAlreadyPaid;
	
	@FindBy(xpath="//button[@id='btnReturn']")
	WebElement verify_Application_Complete_Page;
	
	//@FindBy(xpath="//input[@id='qric_address1_line2']")
	@FindBy(xpath="//input[@id='qric_address1_line2' and @aria-label='Street address']")
	WebElement text_StreetAddress;
	
	@FindBy(xpath="//select[@id='qric_address1_city_lookup_qld']")
	WebElement clickSuburb;
	
	@FindBy(xpath="//input[@id='InsertButton']")
	WebElement clickNext_Kennel;
	
	@FindBy(xpath="//input[@id='qric_iagreeunderstand']")
	WebElement kennel_checkbox1;
	
	@FindBy(xpath="//input[@id='qric_iagreedeclare']")
	WebElement kennel_checkbox2;
	
	@FindBy(xpath="//a[@id='submit_this']")
	WebElement clickSubmit_Kennel;
	
	
	@FindBy(xpath="//input[@id='ans3e8ba724-ebcd-e911-a97e-000d3ad1cc81']")
	WebElement click_1st_chkbox_AWS;
	
	@FindBy(xpath="//input[@id='ans64a89652-ebcd-e911-a97e-000d3ad1cc81']")
	WebElement click_2nd_chkbox_AWS;
	

	@FindBy(xpath="//input[@id='ans7ee3256b-ebcd-e911-a97e-000d3ad1cc81']")
	WebElement click_3rd_chkbox_AWS;
	

	@FindBy(xpath="//input[@id='ans0adcd58f-ebcd-e911-a97e-000d3ad1cc81']")
	WebElement click_4th_chkbox_AWS;
	

	@FindBy(xpath="//input[@id='ans6f6c5ea8-ebcd-e911-a97e-000d3ad1cc81']")
	WebElement click_5th_chkbox_AWS;
	
	
	@FindBy(xpath="//input[@id='ansd8a4eaeb-ebcd-e911-a97e-000d3ad1cc81']")
	WebElement  enterSignature;
	
	@FindBy(xpath="//input[@id='ansf2e09711-eccd-e911-a97e-000d3ad1cc81']")
	WebElement click_6th_chkbox_AWS;
	
	@FindBy(xpath="//button[@id='btnSubmitMe']")
	WebElement click_Continue_AWS;
	
	//@FindBy(xpath="//input[@id='AttachFile']")
	@FindBy(xpath="//input[@aria-label='Attach a file...']")
	WebElement click_Browse;
	
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	WebElement click_Submit;
	
	@FindBy(xpath="//a[@id='submit_this']")
	WebElement click_Submit_KennelAddress;
	
	@FindBy(xpath="//a[@id='refReturn']")
	WebElement clickClose;
	
	
	
	@FindBy(xpath="//input[@id='txtIssue']")
	WebElement text_IssueDate;
	
	
	@FindBy(xpath="//a[contains(text(),'Submit')]")
	WebElement clickSubmit_RTW;
	
	
	@FindBy(xpath="//input[@id='ans11252538-f6c2-e911-a9d6-000d3ad1c6f2']")
	WebElement textEmergencyContact;
	
	
	@FindBy(xpath="//input[@id='ans8734546f-f6c2-e911-a9d6-000d3ad1c6f2']")
	WebElement textEmergencyContactNumber;
	
	
	@FindBy(xpath="//input[@id='ans5d851d9b-f6c2-e911-a9d6-000d3ad1c6f2']")
	WebElement textRelationship_To_applicant;
	
	@FindBy(xpath="//button[contains(text(),'Continue')]")
	WebElement click_Continue;
	
	@FindBy(xpath="//button[@id='btnNext' and @onclick='goNext()']")
	WebElement click_Continue_StudmasterQues;
	
	
	
	@FindBy(xpath="//input[@name='1956b735-08c3-e911-a991-000d3ad10801' and @valuelabel='D']")
	WebElement select_Ans1;
	
	@FindBy(xpath="//input[@name='e0ae54b7-08c3-e911-a991-000d3ad10801' and @valuelabel='D']")
	WebElement select_Ans2;
	
	@FindBy(xpath="//input[@name='add42de2-08c3-e911-a991-000d3ad10801' and @valuelabel='B']")
	WebElement select_Ans3;
	
	@FindBy(xpath="//input[@id='ans9a88e201-09c3-e911-a991-000d3ad10801' and @valuelabel='C']")
	WebElement select_Ans4;
	
	
	@FindBy(xpath="//input[@id='ans416b8721-09c3-e911-a991-000d3ad10801' and @valuelabel='D']")
	WebElement select_Ans5;
	
	@FindBy(xpath="//input[@id='ansd9710640-09c3-e911-a991-000d3ad10801' and @valuelabel='B']")
	WebElement select_Ans6;
	
	
	@FindBy(xpath="//input[@id='ans8a851d5e-09c3-e911-a991-000d3ad10801' and @valuelabel='B']")
	WebElement select_Ans7;
	
	
	@FindBy(xpath="//input[@id='anscffbcc76-09c3-e911-a991-000d3ad10801' and @valuelabel='C']")
	WebElement select_Ans8;
	
	
	@FindBy(xpath="//input[@id='ans9de27dc0-09c3-e911-a991-000d3ad10801' and @valuelabel='D']")
	WebElement select_Ans9;
	
	
	@FindBy(xpath="//input[@id='ans5a3a4c8e-0ac3-e911-a991-000d3ad10801' and @valuelabel='C']")
	WebElement select_Ans10;
	
	
	@FindBy(xpath="//input[@name='521f3457-f7c2-e911-a9d6-000d3ad1c6f2' and @valuelabel='No']")
	WebElement select_No_radio_button;
	
	
	@FindBy(xpath="//input[@name='eeb1562c-d0c3-e911-a991-000d3ad10801' and @valuelabel='No']")
	WebElement select_No_radio_button_DisqualifyPage;
	
	
	
	@FindBy(xpath="//input[@name='d3379f1d-fac2-e911-a9d6-000d3ad1c6f2' and @valuelabel='Yes']")
	WebElement select_first_Yes;
	
	
	@FindBy(xpath="//input[@name='e5eb3636-fac2-e911-a9d6-000d3ad1c6f2' and @valuelabel='Yes']")
	WebElement select_second_Yes;
	
	
	@FindBy(xpath="//input[@name='0cce0c8f-fac2-e911-a991-000d3ad10801' and @valuelabel='Yes']")
	WebElement select_third_Yes;

	
	
	@FindBy(xpath="//input[@name='d001abe4-01c3-e911-a991-000d3ad10801' and @valuelabel='Yes']")
	WebElement select_first_Yes_CHD;
	
	
	
	@FindBy(xpath="//input[@name='f47f0c27-02c3-e911-a991-000d3ad10801' and @valuelabel='No']")
	WebElement select_No_radio_button_CHD;
	
	@FindBy(xpath="//input[@id='ans8f79000d-aac3-e911-a991-000d3ad10801']")
	WebElement signature_SD_Text;
	
	@FindBy(xpath="//input[@id='ansd643fbb4-a0f4-e911-a813-000d3ad1cf6f']")
	WebElement declare_checkbox;
	
	
	@FindBy(xpath="//input[@id='ansd39a892b-aac3-e911-a991-000d3ad10801']")
	WebElement acknowledge_checkbox;
	
	
	@FindBy(xpath="//h1[contains(text(),'New Licence Greyhound Breeder Category 2 Quiz')]")
	WebElement verify_Quiz_Page_Present;
	
	
	@FindBy(xpath="//input[@id='InsertButton']")
	WebElement clickNextButton;
	
	
	
	@FindBy(xpath="//button[@aria-label='New' and @data-id='contact|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.contact.NewRecord']")
	WebElement clickNewButton;
	
	//@FindBy(xpath="//input[@aria-label='First Name Recommended']")
	@FindBy(xpath="//input[@id='id-1fed44d1-ae68-4a41-bd2b-f13acac4acfa-1-fullname_compositionLinkControl_firstname-fullname_compositionLinkControl_firstname.fieldControl-text-box-text']")
	WebElement textFirstName;
	

	//@FindBy(xpath="//input[@aria-label='Last Name']")
	@FindBy(xpath="//input[@id='id-1fed44d1-ae68-4a41-bd2b-f13acac4acfa-3-fullname_compositionLinkControl_lastname-fullname_compositionLinkControl_lastname.fieldControl-text-box-text']")
	WebElement textLastName;
	
	
	@FindBy(xpath="//input[@data-id='emailaddress1.fieldControl-mail-text-input']")
	WebElement textEmail;
	
	@FindBy(xpath="//input[@data-id='mobilephone.fieldControl-phone-text-input']")
	WebElement textMobile;
	
	
	@FindBy(xpath="//button[@aria-label='Save' and @data-id = 'contact|NoRelationship|Form|Mscrm.Form.contact.Save']")
	WebElement clickSave;
	
	@FindBy(xpath="//label[@data-id='mobilephone-error-message']")
	WebElement mobileNotEnteredError;
	
	//span[contains(text(),'Mobile Phone : A required field cannot be empty.')]
	
	//@FindBy(xpath="//button[@aria-label='Assign'")
	@FindBy(xpath="//button[@aria-label='Assign']")
	WebElement check_AssignOption;
	
	@FindBy(xpath="//h1[@aria-label='Duplicate Records Detected']")
	WebElement title_DuplicateRecordsDetected;
	
	//@FindBy(xpath="//input[@title='Select to enter data']")
	@FindBy(xpath="//input[@id='quickFind_text_1']")
	WebElement search_Contact_Record;
	
	@FindBy(xpath="//div[@title='Anuraag Arora']")
	WebElement element_Contact_Fullname;
	
	@FindBy(xpath="//input[@aria-label='Job Title']")
	WebElement textJobTitle;
	
	
	@FindBy(xpath="//input[@name='01e2fd45-3bc9-e911-a97d-000d3ad1cc81' and @valuelabel='B']")
	WebElement clickAns1_Studmaster;
	
	@FindBy(xpath="//input[@name='9441b182-3bc9-e911-a97d-000d3ad1cc81' and @valuelabel='A']")
	WebElement clickAns2_Studmaster;
	
	@FindBy(xpath="//input[@name='ada861bf-3bc9-e911-a97d-000d3ad1cc81' and @valuelabel='D']")
	WebElement clickAns3_Studmaster;
	
	
	
	
	
	// *************************************************CRM Xpaths****************************************************
	
	//@FindBy(xpath="//input[@id='i0116' and @type='email']")
	@FindBy(xpath="/html/body/div/form[1]/div/div/div[2]/div[3]/div/div/div/div[2]/div[2]/div/input[1]")
	WebElement textCRM_LoginEmail;
	
	@FindBy(xpath="//input[@id='idSIButton9' and @value='Next']")
	WebElement clickNext;
	
	@FindBy(xpath="//input[@id='idSIButton9']")
	WebElement clickYes;
	
	
	@FindBy(xpath="//button[@aria-label='Switch to another app']")
	WebElement clickRandle_dropdown;
	
	
	//@FindBy(xpath="html/body/div[3]/div/div[1]/div/div[1]/div[2]/div/div/nav[1]/div/div[3]/div[6]/button[1]")
	@FindBy(xpath="//*[@id=\"taskpane-scroll-container\"]/div[6]/button[1]/div/div[3]/span[1]")
	//html/body/div[3]/div/div[1]/div/div[1]/div[2]/div/div/nav[1]/div/div[3]/div[6]/button[1]
	WebElement clickRandle_Manager;
	
	
	@FindBy(xpath="//span[contains(text(),'Licences')]")
	WebElement clickLicences;
	

	@FindBy(xpath="//span[contains(text(),'Inactive Accounts')]")
	
	//"//span[@class='symbolFont DropdownArrow-symbol']")
	WebElement clickLicences_dropdown;
	
	@FindBy(xpath="//span[contains(text(),'Staff – Applications submitted')]")
	WebElement select_Staff_Applications_view;
	
	
	@FindBy(xpath="//div[contains(text(),'Created On') and @class='grid-header-text']")
	WebElement clickCreatedOn;
	
	
	@FindBy(xpath="//div[contains(text(),'Account Name') and @class='grid-header-text']")
	WebElement clickAccountName;
	
	
	@FindBy(xpath="//label[contains(text(),'Breeder Category 4')]")
	WebElement click_Applicant;
	
	@FindBy(xpath="//li[@aria-label='Process application']")
	WebElement clickProcess_Application_option;
	
	
	@FindBy(xpath="//input[@aria-label='All Prereqs checked']")
	WebElement tick_AllPrerequisites_checkbox;
	
	@FindBy(xpath="//input[@aria-label='Application checked']")
	WebElement tick_ApplicationChecked_checkbox;
	
	
	@FindBy(xpath="//button[@aria-label='Save & Close']")
	WebElement click_SaveClose;
	
	
	//div[@id='Grid95e5bfcb-a7cf-ab44-98e3-c8f071fbc87d-id-cell-1-3' and @title='Breeder Category 4']
	
	//Initialising the Page Objects by Defining the Constructor below.
	public HomePage()
	{
		PageFactory.initElements(driver, this);
		
	}

	
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
		
	}
	
	
	
	
	public void click_ApplyforLicence()
	
	{
		
		report = new ExtentReports("C:\\\\Users\\\\Anuraag.Arora\\\\Documents\\\\Automation Framework-Final worked on\\\\eclipse-workspace\\\\DAF_DynamicsCRM_Test_Automation\\\\test-output\\\\CRM HTML Report\\\\CRM_Automation.html");
		logger = report.startTest("-*-*-*-*-*-*-QRIC Licence Application Test Automation-*-*-*-*-*-*-");
				
		
		Helper.highLightElement(driver, clickApply_for_Licence_Option);
		clickApply_for_Licence_Option.click();
	}
	
	

	
	
	public void click_Greyhound() throws InterruptedException
	{

		Helper.highLightElement(driver, clickGreyhound);
		clickGreyhound.click();
			
	}
	
	
	public void click_Studmaster() throws InterruptedException
	{

		Helper.highLightElement(driver, clickStudmaster);
		clickStudmaster.click();
			
	}
	
	
	
	
	public void click_Breeders()
	{
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		Helper.highLightElement(driver, select_Breeders);
		select_Breeders.click();	

		
	}
	
	public void select_BreederCat_4()
	
	{
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		Helper.highLightElement(driver, select_BreederCat_4);
		select_BreederCat_4.click();
	}
	
	
	public boolean verify_Presence_of_Greyhound_Breeder_Cat_4_Page() throws InterruptedException
	
	{
        WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement Greyhound_BR_CAT4_Page = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Greyhound Breeder Category 4 application')]")));
		return verify_GH_Breeder_CAT4_Page.isDisplayed();
		
	}
	
	
	
	public boolean verify_Presence_of_Studmaster_Page() throws InterruptedException
	
	{
        WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement Studmaster_Page = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/form/div[3]/div[2]/div/div[2]/div[3]/div/div[2]/h1")));
		return verify_GH_Studmaster_Page.isDisplayed();
		
	}
	
	
	public boolean verify_Presence_of_AnimalWelfare_Page() throws InterruptedException
	
	{
		Helper.highLightElement(driver, click_Continue);
		click_Continue.click();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement AnimalWelfare_Page = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Animal Welfare statutory declaration')]")));
		return verify_Animal_Welfare_Page.isDisplayed();
		
		
	}
	
	
	
	
	
	public boolean verify_Presence_of_Kennel_Address_Page() throws InterruptedException
	
	{
		Helper.highLightElement(driver, click_Continue);
		click_Continue.click();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement KennelAddress_Page = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Add new kennelling address')]")));
		return verify_KennelAddress_Page.isDisplayed();
		
	}
	
	
	public void complete_KennelAddress_Page(String kennel_Streetaddress) throws InterruptedException
	{
		
		Thread.sleep(1000);
		text_StreetAddress.sendKeys(kennel_Streetaddress);
		//Helper.highLightElement(driver, clickSuburb);
		clickSuburb.click();
		
		Select Kennelsuburb = new Select(driver.findElement(By.id("qric_address1_city_lookup_qld")));
		Kennelsuburb.selectByVisibleText("ABBOTSFORD-BUNDABERG");
		//Kennelsuburb.selectByIndex(1);
		clickNext_Kennel.click();
		Thread.sleep(500);
		kennel_checkbox1.click();
		kennel_checkbox2.click();
		click_Submit_KennelAddress.click();
		Thread.sleep(500);
		clickClose.click();
		
	}
	
	
	public void complete_AnimalWelfare_Page(String Signature)
	 {
			
		    
		    click_1st_chkbox_AWS.click();
		    
		   // Helper.highLightElement(driver, click_2nd_chkbox_AWS);
			click_2nd_chkbox_AWS.click();
			
			//Helper.highLightElement(driver, click_3rd_chkbox_AWS);
			click_3rd_chkbox_AWS.click();
			
			//Helper.highLightElement(driver, click_4th_chkbox_AWS);
			click_4th_chkbox_AWS.click();
			
			//Helper.highLightElement(driver, click_5th_chkbox_AWS);
			click_5th_chkbox_AWS.click();
			
			//Helper.highLightElement(driver, enterSignature);
			enterSignature.sendKeys(Signature);
			
			//Helper.highLightElement(driver, click_6th_chkbox_AWS);
			click_6th_chkbox_AWS.click();
			
			//Helper.highLightElement(driver, click_Continue_AWS);
			click_Continue_AWS.click();
			
	 }
	
	public boolean verify_Presence_of_File_Upload_Page() throws InterruptedException
		
		{
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			return verify_File_Upload_Page.isDisplayed();
			
		}
		
	public void upload_Photo() throws IOException, InterruptedException
	 {
		//Helper.highLightElement(driver, click_Browse);
		WebElement elementNew = driver.findElement(By.xpath("//input[@aria-label='Attach a file...']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(elementNew).click().perform();
		
		//click_Browse.click();*/
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Users\\Anuraag.Arora\\Documents\\Automation Framework-Final worked on\\eclipse-workspace\\DAF_DynamicsCRM_Test_Automation\\AUTOIT\\FileUploadChrome.exe");
		driver.manage().timeouts().implicitlyWait(50000, TimeUnit.SECONDS);
		Thread.sleep(2000);
		Helper.highLightElement(driver, click_Submit);
		click_Submit.click();
		
		//driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	 }
	
	
	public boolean verify_Presence_of_POI_Page() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		return verify_POI_Page.isDisplayed();
		
	}
	
	
	public void upload_POI() throws IOException, InterruptedException
	{
	
		WebElement elementNew = driver.findElement(By.xpath("//input[@aria-label='Attach a file...']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(elementNew).click().perform();
		
		//Helper.highLightElement(driver, click_Browse);
		//click_Browse.click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Users\\Anuraag.Arora\\Documents\\Automation Framework-Final worked on\\eclipse-workspace\\DAF_DynamicsCRM_Test_Automation\\AUTOIT\\FileUploadChrome.exe");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		Thread.sleep(2000);
		Helper.highLightElement(driver, click_Submit);
		click_Submit.click();
		
	}
	
	
	public boolean verify_Presence_of_NPC_Page() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		return verify_NPC_Page.isDisplayed();
		
	}
	
	
	public void submit_NPC() throws IOException, InterruptedException
	{	
		// ** Today's date conversion **
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dateToday = dateFormat.format(new Date());
		System.out.println(dateFormat.format(new Date()));
		
		text_IssueDate.sendKeys(dateToday);
		//Helper.highLightElement(driver, click_Browse);
		//click_Browse.click();
		
		WebElement elementNew = driver.findElement(By.xpath("//input[@aria-label='Attach a file...']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(elementNew).click().perform();
		
		
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Users\\Anuraag.Arora\\Documents\\Automation Framework-Final worked on\\eclipse-workspace\\DAF_DynamicsCRM_Test_Automation\\AUTOIT\\FileUploadChrome.exe");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		Thread.sleep(2000);
		Helper.highLightElement(driver, click_Submit);
		click_Submit.click();
		
	}
	
	
	public boolean verify_Presence_of_RTW_Page() throws IOException
	{
		//driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		
		WebElement verify_RTW_Page = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Right to work in Australia (RTW)')]")));

		return verify_RTW_Page.isDisplayed();
		
	}

	
	public void submit_RTW() 
	{
		Select drpdownRTW = new Select(driver.findElement(By.xpath("//select[@id='qric_ausornzpermresident']")));
		drpdownRTW.selectByVisibleText("Yes");
		
		Helper.highLightElement(driver, clickSubmit_RTW);
		clickSubmit_RTW.click();
		
	}
	
	
	public boolean verify_Presence_of_EmergencyContactDetails_Page()
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		
		WebElement verify_EmergencyContactPageelement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Emergency contact details')]")));
		return verify_Emergency_Contacts_Page.isDisplayed();
		
	}
	
	public void submit_EmergencyContactDetails(String EmergencyContact,String EmergencyContactNumber,String Relationship)
	{
		
	  Helper.highLightElement(driver, textEmergencyContact);
	  textEmergencyContact.sendKeys(EmergencyContact);
		
	  Helper.highLightElement(driver, textEmergencyContactNumber);
	  textEmergencyContactNumber.sendKeys(EmergencyContactNumber);
		
	  
	  Helper.highLightElement(driver, textRelationship_To_applicant);
	  textRelationship_To_applicant.sendKeys(Relationship);
	  
	  
	  Helper.highLightElement(driver, click_Continue);
	  click_Continue.click();
		
	}
	
	
	
	public boolean verify_Presence_of_Written_Assessment_Getting_Started()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		
		WebElement WA_GettingStartedPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Written Assessment - Getting Started')]")));
		return verify_WrittenAssessment_GettingStartedPage.isDisplayed();
	}
	
	
	public void submit_Written_Assessment_Getting_Started() throws InterruptedException
	{
		
		WebDriverWait wait1 = new WebDriverWait(driver, 500);
		
		//Helper.highLightElement(driver, select_Ans1);
		select_Ans1.click();
		
		WebElement Ans2_element = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='e0ae54b7-08c3-e911-a991-000d3ad10801' and @valuelabel='D']")));
		//Helper.highLightElement(driver, select_Ans2);
		select_Ans2.click();
		
		WebElement Ans3_element = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='add42de2-08c3-e911-a991-000d3ad10801' and @valuelabel='B']")));
		//Helper.highLightElement(driver, select_Ans3);
		select_Ans3.click();
		
		WebElement Ans4_element = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ans9a88e201-09c3-e911-a991-000d3ad10801' and @valuelabel='C']")));
		//Helper.highLightElement(driver, select_Ans4);
		select_Ans4.click();
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		//Helper.highLightElement(driver, select_Ans5);
		select_Ans5.click();
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		//Helper.highLightElement(driver, select_Ans6);
		select_Ans6.click();
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		//Helper.highLightElement(driver, select_Ans7);
		select_Ans7.click();
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		//Helper.highLightElement(driver, select_Ans8);
		select_Ans8.click();
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		//Helper.highLightElement(driver, select_Ans9);
		select_Ans9.click();
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		//Helper.highLightElement(driver, select_Ans10);
		select_Ans10.click();
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		Helper.highLightElement(driver, click_Continue);
		click_Continue.click();
		Thread.sleep(500);
		
		Helper.highLightElement(driver, click_Continue);
		click_Continue.click();
		
	}
	
	
	public boolean verify_Presence_of_Written_Assessment_Studmaster()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		
		WebElement WA_Studmaster = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Written Assessment - Greyhound Studmaster')]")));
		return verify_WrittenAssessment_Studmaster_Page.isDisplayed();
	}
	
	
	public void submit_Written_Assessment_Studmaster() throws InterruptedException
	{
		clickAns1_Studmaster.click();
		clickAns2_Studmaster.click();
		clickAns3_Studmaster.click();
		
		click_Continue.click();
		Thread.sleep(50);
		
		WebDriverWait wait10 = new WebDriverWait(driver, 1000);
		WebElement Continue_element = wait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='btnNext' and @onclick='goNext()']")));
		click_Continue_StudmasterQues.click();
		
		//WebElement elementNew = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
		//Actions actions = new Actions(driver);
		//actions.moveToElement(elementNew).click().perform();
		//click_Continue.click();
		//click_Continue.click();
	}
	
	
	
	public boolean verify_Presence_of_Contact_with_racing_control_bodies_Page()
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement Contact_with_ControlBodies = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Contact with racing control bodies')]")));
		return verify_Contact_with_racing_control_bodies_Page.isDisplayed();

	}
	
	
	public void submit_RacingControlBodies_Page()
	{
	  Helper.highLightElement(driver, select_No_radio_button);
	  select_No_radio_button.click();
	  
	  Helper.highLightElement(driver, click_Continue);
	  click_Continue.click();
		
	}
	
	
	
	
	public boolean verify_Presence_of_Disqualification_question_Page()
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement DisqualificationQuestion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Disqualification question')]")));
		return verify_Disqualification_question_Page.isDisplayed();

	}
	
	
	public void submit_Disqualification_question_Page()
	{
		
	  Helper.highLightElement(driver, select_No_radio_button_DisqualifyPage);
	  select_No_radio_button_DisqualifyPage.click();
	  
	  Helper.highLightElement(driver, click_Continue);
	  click_Continue.click();
		
	}
	
	
	
	
	public boolean verify_Consent_Questionnaire_Page()
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement Consent_Questionnaire = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Consent questionnaire')]")));
		return verify_ConsentQuestionnaire_Page.isDisplayed();

	}
	
	
	public void submit_Consent_Questionnaire_Page()
	{
	  //Helper.highLightElement(driver, select_first_Yes);
	  select_first_Yes.click();
	  
	  //Helper.highLightElement(driver, select_second_Yes);
	  select_second_Yes.click();
	  
	  //Helper.highLightElement(driver, select_third_Yes);
	  select_third_Yes.click();
	  
	  //Helper.highLightElement(driver, click_Continue);
	  click_Continue.click();
		
	}
	
	
	
	public boolean verify_Criminal_History_Declaration_Page()
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement Criminal_History_Declaration = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Criminal history declaration')]")));
		return verify_Criminal_History_Declaration_Page.isDisplayed();

	}
	
	
	
	public void submit_Criminal_History_Declaration_Page()
	{
		
	  Helper.highLightElement(driver, select_first_Yes_CHD);
	  select_first_Yes_CHD.click();
	  
	  Helper.highLightElement(driver, select_No_radio_button_CHD);
	  select_No_radio_button_CHD.click();
	
	  Helper.highLightElement(driver, click_Continue);
	  click_Continue.click();
		
	}
	
	
	
	public boolean verify_Statutory_Declaration_Page()
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement Statutory_Declaration = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-bind='html: Title']")));
		return verify_Statutory_Declaration_Page.isDisplayed();

	}
	
	
	
	public boolean verify_Payment_Page()
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement Statutory_Declaration = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@id='portal_wp_name_h1']")));
		return verify_Payment_Page.isDisplayed();

	}
	
	
	
	public void submit_Payment()
	{
		clickAlreadyPaid.click();
	}
	
	
	public void submit_Statutory_Declaration_Page(String StatutoryDeclaration)
	{
		Helper.highLightElement(driver, signature_SD_Text);
		signature_SD_Text.sendKeys(StatutoryDeclaration);
		
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		Helper.highLightElement(driver, declare_checkbox);
		declare_checkbox.click();
		
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		Helper.highLightElement(driver, acknowledge_checkbox);
	    acknowledge_checkbox.click();
	    
	    Helper.highLightElement(driver, click_Continue);
	    click_Continue.click();
		
	}
	
	
	public boolean verify_Application_Complete()
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement ApplicationComplete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='btnReturn']")));
		return verify_Application_Complete_Page.isDisplayed();

	}
	
	
	
////////////////////////////////////////////////////////////////////CRM Approval Code////////////////////////////////////////////////////////////////////
	
	public void validate_CrmLogin() throws InterruptedException
	{
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		Thread.sleep(2000);
		textCRM_LoginEmail.sendKeys("anuraag.arora@daf.qld.gov.au");
		clickNext.click();
		//clickYes.click();
		
	}
	
	
	public void clickRandleManager_app() throws InterruptedException
	{
		
		// The Code below is to handle frames on this page. 
	    List<WebElement> ele = driver.findElements(By.tagName("iframe"));
	    System.out.println("Number of frames in a page :" + ele.size());
	    for(WebElement el : ele){
	        System.out.println("Frame Id :" + el.getAttribute("id"));
	    
	        System.out.println("Frame name :" + el.getAttribute("name"));
	    }
	    
		Thread.sleep(1000);
		clickRandle_dropdown.click();
		clickRandle_Manager.click();

		
	}
	
	
	public void clickLicences() throws InterruptedException
	{
		Thread.sleep(500);
		clickLicences.click();
	}
	
	// From here click Licences and further on.
	
	
	public void validate_StaffApplications_View() throws InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement Licencesdropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Inactive Accounts')]")));
		clickLicences_dropdown.click();
		
		select_Staff_Applications_view.click();
		
		Thread.sleep(200);
		
		WebDriverWait wait5 = new WebDriverWait(driver, 500);
		WebElement ApplicationComplete = wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Account Name') and @class='grid-header-text']")));
		clickAccountName.click();
		
		Thread.sleep(500);
	
		Actions actions = new Actions(driver);
		//WebElement elementLocator = driver.findElement(By.xpath("//div[@title='Matthew Hayden']"));
		WebElement elementLocator = driver.findElement(By.xpath("//label[contains(text(),'Breeder Category 4')]"));
		actions.doubleClick(elementLocator).perform();
	
	}

	
	
	public void ProcessApplication_Staff_To_Senior() throws InterruptedException
	{
		Thread.sleep(100);	
		clickProcess_Application_option.click();
		Thread.sleep(50);
		tick_AllPrerequisites_checkbox.click();
		Thread.sleep(50);
		tick_ApplicationChecked_checkbox.click();
		Thread.sleep(100);
		click_SaveClose.click();
		
		
		
	}
	
	
	//////////////////////////////////////////////////////////////////End of CRM Code/////////////////////////////////////////////////////////////////////
	
	
	public void click_Next()
	{
		Helper.highLightElement(driver, clickNextButton);
		clickNextButton.click();
	}
		
	
	public boolean verify_Presence_of_QUIZ_Page()
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		return verify_Quiz_Page_Present.isDisplayed();
	}
		
	
	public void select_QUIZ_Answers()
	{
		Select Q_Ans1 = new Select(driver.findElement(By.xpath("//select[@id='dlg_ad01_mc4']")));
		Q_Ans1.selectByVisibleText("D");   
		
	}
	
	
	
	public void clickNew() throws InterruptedException
	{
		
		Thread.sleep(2000);		
		WebElement elementNew = driver.findElement(By.xpath("//button[@aria-label='New' and @data-id='contact|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.contact.NewRecord']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(elementNew).click().perform();
	
	}
		

	
	
	public void ContactLastName(String LastName)
	{
		Helper.highLightElement(driver, textLastName);
		textLastName.sendKeys(LastName);

		textLastName.sendKeys(Keys.TAB);
	}
	
	
	public void ContactEmail(String Email)
	{
		Helper.highLightElement(driver, textEmail);
		textEmail.sendKeys(Email);

		textEmail.sendKeys(Keys.TAB);
	}
	
	
	public void ContactMobileNumber(String MobileNumber)
	{
		Helper.highLightElement(driver, textMobile);
		textMobile.sendKeys(MobileNumber);
	
		textMobile.sendKeys(Keys.TAB);
	}
	
	
	public void saveContact()
	
	{
		Helper.highLightElement(driver, clickSave);
		clickSave.click();
		
		
	}
	
	
	public boolean verifyContactCreation() throws InterruptedException
	
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		return check_AssignOption.isDisplayed();
		
	}
	
	
	public boolean verifyContactCreation_Negative_Scenario() throws InterruptedException
	
	{
		Thread.sleep(2000);
		
		return mobileNotEnteredError.isDisplayed();
		
	}
	
	
	public boolean Contact_DuplicateDetection() throws InterruptedException
	{
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return title_DuplicateRecordsDetected.isDisplayed();
		
	}
		

	public void search_Contact_Record(String Search_Contact, String Update_JobTitle,String Update_Email ) throws InterruptedException
	{
		
		Thread.sleep(1000);
		search_Contact_Record.sendKeys(Search_Contact);
		search_Contact_Record.sendKeys(Keys.ENTER);
		element_Contact_Fullname.click();
		Thread.sleep(2000);
		textJobTitle.sendKeys(Keys.CONTROL + "a");
		textJobTitle.sendKeys(Keys.DELETE);
		textJobTitle.sendKeys(Update_JobTitle);
		textEmail.sendKeys(Keys.CONTROL + "a");
		textEmail.sendKeys(Keys.DELETE);
		textEmail.sendKeys(Update_Email);
		textEmail.sendKeys(Keys.CONTROL + "s");
		
	}
	
	
}
		

