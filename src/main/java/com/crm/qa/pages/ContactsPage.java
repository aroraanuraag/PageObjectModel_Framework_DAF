package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ContactsPage extends TestBase {
WebDriverWait wait = new WebDriverWait(driver, 10000);
	
	ExtentReports report;
	ExtentTest logger;
	
	
	//@FindBy(xpath="//a[@id='nav_conts']")
	@FindBy(xpath="html/body/div[5]/div[7]/div/div[3]/div/div/ul/li[2]/span/span/span/span/li[2]/a/span[2]")
	WebElement contactsSelect;
	
	
	//@FindBy(xpath="//label[@id='Full Name_label' and @data-for-id='fullname_label']")
	@FindBy(xpath="//label[@id='Full Name_label']")
	WebElement contactFullName;
	
	@FindBy(xpath="//input[@id='fullname_compositionLinkControl_firstname_i']")
	WebElement contactFirstName;
	
	@FindBy(xpath="//input[@id='fullname_compositionLinkControl_lastname_i']")
	WebElement contactLastName;
	

	@FindBy(xpath="//input[@id='emailaddress1_i']")
	WebElement contactEmail;
	
	@FindBy(xpath="//input[@id='mobilephone_i']")
	WebElement contactMobilePhone;
	
	
	@FindBy(xpath="//span[@class='ms-crm-CommandBar-Menu' and @command='contact|NoRelationship|Form|Mscrm.SavePrimary']")
	WebElement clickSaveButton;
	

	
	//Initialising the Page Objects by Defining the Constructor below.
		public ContactsPage()
		{
			PageFactory.initElements(driver, this);
			
		}

		public void createContactsCRM(String FirstName, String LastName, String Email, String MobilePhone) throws InterruptedException
		{
			
			//report = new ExtentReports("C:\\Users\\Anuraag.Arora\\Documents\\Automation Framework-Final worked on\\eclipse-workspace\\DynamicsCRM_Automation2\\test-output\\CRM HTML Report\\CRM_Automation.html");
			//logger = report.startTest("-*-*-*-*-*-*-CRM Automation-*-*-*-*-*-*-");
			WebElement clickSalesDropdown;
			clickSalesDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[5]/div[2]/div/span[7]/span[2]")));
			clickSalesDropdown.click();
			//logger.log(LogStatus.INFO, "Sales drop-down is clicked");
			
			contactsSelect.click();
			
			Thread.sleep(9000);		
			WebElement elementNew = driver.findElement(By.xpath("//span[@class='ms-crm-CommandBar-Menu' and @command='contact|NoRelationship|HomePageGrid|Mscrm.NewRecordFromGrid']"));
			Actions actions = new Actions(driver);
			actions.moveToElement(elementNew).click().perform();
				

			// The Code below is to handle frames on this page. 
			int size = driver.findElements(By.tagName("iframe")).size();
			System.out.println(size);
		
		    List<WebElement> ele = driver.findElements(By.tagName("iframe"));
		    System.out.println("Number of frames in a page :" + ele.size());
		    for(WebElement el : ele){
		        System.out.println("Frame Id :" + el.getAttribute("id"));
		    
		        System.out.println("Frame name :" + el.getAttribute("name"));
		    }
		    
			Thread.sleep(5000);		
			driver.switchTo().frame("contentIFrame1");	
			
			
			/////////////////////*********** To Fix from here*********************
			
			
			//Thread.sleep(500);	
			contactFullName.click();
			
			contactFirstName.sendKeys(FirstName);
			contactLastName.sendKeys(LastName);
			
			WebElement pressKeysCRM = driver.findElement(By.xpath("//input[@id='fullname_compositionLinkControl_lastname_i']"));
			pressKeysCRM.sendKeys(Keys.TAB);
			pressKeysCRM.sendKeys(Keys.ENTER);
			
			
			contactEmail.sendKeys(Email);
			contactMobilePhone.sendKeys(MobilePhone);
	
			
			
			driver.switchTo().defaultContent();
			clickSaveButton.click();
			
			
					
   }
}

