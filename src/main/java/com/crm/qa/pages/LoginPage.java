package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.Helper;

public class LoginPage extends TestBase {   	 // Parent is TestBase class, hence 'extends TestBase' - Parent properties are inherited to Childs.
	
	//Page Factory  - Object repository or Page Objects.
	
	@FindBy(xpath="//a[@id='signin-local']")
	WebElement btnSignIn;
	
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement textLoginEmail;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement textPassword;
	
	@FindBy(xpath="//button[@id='submit-signin-local']")
	WebElement clickSignIn;
	
	@FindBy(xpath="//h1[contains(text(),'My profile')]")
	WebElement verifyLoginSuccessful_My_Profile;
	
	
	//Initializing the Page Objects.
	
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
		
	}
	
	
	//Actions or Features available on Login Page.
	public String validateLoginPageTitle() 
	{
		return driver.getTitle();	
	}
	
	
	public HomePage login(String usname, String pwd) throws InterruptedException
	
	{
		
		Helper.highLightElement(driver, btnSignIn);
		btnSignIn.click();

		Thread.sleep(1500);	
		Helper.highLightElement(driver, textLoginEmail);
		textLoginEmail.sendKeys(usname);
		
		
		Thread.sleep(1500);	
		Helper.highLightElement(driver, textPassword);
		textPassword.sendKeys(pwd);
		
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement SignIn_Btn= driver.findElement(By.xpath("//button[@id='submit-signin-local']"));
		je.executeScript("arguments[0].scrollIntoView(true);",SignIn_Btn);
		Helper.highLightElement(driver, SignIn_Btn);
		SignIn_Btn.click();
		

		return new HomePage();
		
	}
	
	
}
