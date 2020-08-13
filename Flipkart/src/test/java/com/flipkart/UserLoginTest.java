package com.flipkart;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.flipkart.util.Util;
import com.flipkart.base.TestBase_new;
import com.flipkart.pages.LoginPage;

//import com.aftermarket.base.TestBase;

public class UserLoginTest extends TestBase_new{
	
	public UserLoginTest(){
		super();
	}
	
	LoginPage loginPage;
	Util util;
	String globalSearchSheet = "Login_Data";
	
	/**********************************************************************************/
	// Method Name: setup
	// Inputs	  : Browser and Url for Test Suite parameter
	// purpose 	  : Initialize the webdriver with browser and url 
	// 
	/**********************************************************************************/
	
	@BeforeClass
	@Parameters({"browser","url"})
	public void setup(String browser, String url) throws InterruptedException{
		
		initialization(browser,url);
		loginPage = new LoginPage();
		util = new Util();
	}
	
	/**********************************************************************************/
	// Method Name: getLoginDetailsData
	// purpose 	  : get the login details for testdata.xlsx using Dataprovider
	// 
	/**********************************************************************************/
	
	/*Input Data for Search by Global Search*/
	@DataProvider
	public Object[][] getLoginDetailsData(){
		Object searchdata[][] = util.getTestData(globalSearchSheet);
		return searchdata;
	}
	
	/**********************************************************************************/
	// Method Name: LaunchUrlTest
	// purpose 	  : Verify the LaunchUrl with input URL 
	// Anchor	  : UserLoginTest_001
	/**********************************************************************************/
		
	@Test
	@Parameters({"browser","url"})
	public void LaunchUrlTest(String browser, String url) throws NullPointerException, InterruptedException{
		try {
			boolean urlLaunchStatus=loginPage.loginOptionDisplayStatus();
			System.out.println("Launching the Application in "+url+" Environment, On "+browser+" browser.");
			Assert.assertTrue(urlLaunchStatus, "Launch URL is failed ");
		}catch(NullPointerException e) {
			Assert.assertTrue(false, "Launch URL is failed ");
		}
	}
	
	/**********************************************************************************/
	// Method Name: loginUserTest
	// purpose 	  : Verify the successful login after user credentials. 
	// Anchor	  : UserLoginTest_002
	/**********************************************************************************/
	
	@Test(dataProvider = "getLoginDetailsData")
	public void loginUserTest(String UserID, String Password) throws Exception{
		System.out.println("loginusertest-start");
		//Thread.sleep(4000);
		try {
		Util.implicitWait();
		
		Boolean loginStatus=loginPage.login(UserID,Password);
		System.out.println("Login Status"+loginStatus);
		Assert.assertTrue(loginStatus, "The login with user credentials Failed ");
		}catch(NoSuchElementException e){
			Assert.assertTrue(false, "The login with user credentials Failed ");
		}
		
		
		
	}		
}
	