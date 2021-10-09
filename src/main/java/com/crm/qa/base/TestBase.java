package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;   // This is Global variable.
	public static Properties prop;    // This is Global variable.
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase()   // This is the Constructor - Constructor name is same as Class name.
	{
		
		try {
			
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\61410\\Documents\\1. TEST Automation Framework DAF and IMP\\Automation Framework-Final worked on\\eclipse-workspace\\DAF_DynamicsCRM_Test_Automation\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
			
			} catch(FileNotFoundException e) {
			
				e.printStackTrace();
			
			} catch (IOException e) {
			
				e.printStackTrace();
			
		}
		
	}
	
	public static void initialisation()
	{
		String browserName = prop.getProperty("browser");
		//if(browserName.equals("FF"))
		if(browserName.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\BrowserFilesNew\\LATEST\\MicrosoftWebDriver.exe");
			//System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\BrowserFiles\\geckodriver.exe");
			//System.setProperty("webdriver.firefox.bin",System.getProperty("user.dir")+"\\BrowserFiles\\geckodriver.exe");
			//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Anuraag.Arora\\Documents\\Automation Framework\\eclipse-workspace\\FreeCRM_Test\\BrowserFilesNEW\\geckodriver.exe");
			//driver	= new FirefoxDriver();
			driver	= new EdgeDriver();
			
			
			
		} else if (browserName.equals("chrome"))
			
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\BrowserFilesNew\\LATEST\\chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver","C:\\Users\\Anuraag.Arora\\Documents\\Automation Framework\\eclipse-workspace\\FreeCRM_Test\\BrowserFilesNEW\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
	
/*	public static void initialisation()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\BrowserFilesNew\\chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver","C:\\Users\\Anuraag.Arora\\Documents\\Automation Framework\\eclipse-workspace\\FreeCRM_Test\\BrowserFilesNEW\\chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if (browserName.equals("FF"))
			
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\BrowserFilesNew\\geckodriver.exe");
			//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Anuraag.Arora\\Documents\\Automation Framework\\eclipse-workspace\\FreeCRM_Test\\BrowserFilesNEW\\geckodriver.exe");
			driver	= new FirefoxDriver();
			
		}
		*/

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
			
	}

}
