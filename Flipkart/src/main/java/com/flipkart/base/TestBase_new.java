package com.flipkart.base;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;

public class TestBase_new {

	public static WebDriver driver;
	public static String baseurl;
	public static String baseuri;
	static String driverPath = System.getProperty("user.dir");
	public static String browserName;
    	
    	@Parameters({ "browser", "url" }) 	 
    	public static void initialization(String browser, String url) throws InterruptedException, TimeoutException 
    	{
    		if (browser.equalsIgnoreCase("chrome")) { 
				System.setProperty("webdriver.chrome.driver", driverPath+"\\Drivers\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--start-maximized");
				driver = new ChromeDriver(options);
	    		driver.get(url);
			}else if (browser.equalsIgnoreCase("firefox")) {
				DesiredCapabilities capabilities = new DesiredCapabilities();
				System.setProperty("webdriver.gecko.driver", driverPath+"\\Drivers\\geckodriver.exe");
				capabilities.setCapability("marionette", true);
				driver = new FirefoxDriver();
				driver.get(url);

			}else if (browser.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver", driverPath+"\\Drivers\\MicrosoftWebDriver.exe");
				driver = new EdgeDriver();
				driver.get(url);
				
			}else if (browser.equalsIgnoreCase("safari")) {
				System.setProperty("webdriver.safari.noinstall", "true");
				SafariOptions options = new SafariOptions();
				driver = new SafariDriver(options);
				driver.get(url);
				
			}else if(browser.equalsIgnoreCase("internetexplorer")) {	
				File ieDriverFile = new File(driverPath+"\\Drivers\\IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver", ieDriverFile.getAbsolutePath());
				driver = new InternetExplorerDriver();
				driver.get(url);
			}else {
				System.out.println("The Browser is not picked up");
			}
    		//driver.close();
    	}
    

    	@AfterSuite
    	public void closeBrowser() {
    		driver.quit();
    	}
}