package com.flipkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.TestBase_new;

public class LoginPage extends TestBase_new {
	
	/*=========================================================================*/
	/*=====LoginPage - Search Web Elements======================================*/
	/*=========================================================================*/
	
	/*Login Popup - Email id field*/
	@FindBy(xpath ="//div[@class='_39M2dM JB4AMj']//input[@class='_2zrpKA _1dBPDZ']")
	WebElement emailId;

	@FindBy(xpath="//div[@class='_39M2dM JB4AMj']//input[@type='password']")
	WebElement password;

	@FindBy(xpath="//body/div[@id='container']/div/div/div/div/div[3]/div[1]/div[1]/div[1]/div[1]")
	WebElement userName;
	
	@FindBy(xpath="//button[@class='_2AkmmA _1LctnI _7UHT_c'and @type='submit']")
	WebElement loginButton;
	
	@FindBy(xpath ="//body/div[@id='container']/div/div/div/div/div[3]/div//*[local-name()='svg']")
	WebElement userAccountDropdown;
	
	@FindBy(xpath="//a[contains(.,'Logout')]")
	WebElement logoutOption;
	/*============Object Declarations ============*/
	/*Initialize the PageObjects*/
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	/*================================================================================*/

	/**********************************************************************************/
	// Method Name: login
	// purpose 	  : Return successful login check after user credentials. 
	// Anchor	  : UserLoginCode_001
	/**********************************************************************************/
	public boolean login(String UserID,String userpassword) throws Exception{
		
		System.out.println("Login Email Id: ");
		 emailId.sendKeys(UserID);
		 password.sendKeys(userpassword);
		 loginButton.click();
		 userAccountDropdownClick();
		return logoutOptionDisplayStatus();		  
	}
	
	/**********************************************************************************/
	// Method Name: userAccountDropdownClick
	// purpose 	  : Mouseover on user account login bezel. 
	// Anchor	  : UserLoginCode_002
	/**********************************************************************************/
	public void userAccountDropdownClick(){
		Actions action = new Actions(driver);
		action.moveToElement(userAccountDropdown).build().perform();
	}

	/**********************************************************************************/
	// Method Name: loginOptionDisplayStatus
	// purpose 	  : Return the login option display in popup window. 
	// Anchor	  : UserLoginCode_003
	/**********************************************************************************/
	public boolean loginOptionDisplayStatus(){
		return loginButton.isDisplayed();
	}
	
	/**********************************************************************************/
	// Method Name: logoutOptionDisplayStatus
	// purpose 	  : Return the logout option display in user account dropdown. 
	// Anchor	  : UserLoginCode_004
	/**********************************************************************************/
	public boolean logoutOptionDisplayStatus(){
		return logoutOption.isDisplayed();
	}
	/**********************************************************************************/
	// Method Name: logoutOptionDisplayStatus
	// purpose 	  : Click action on logout. 
	// Anchor	  : UserLoginCode_005
	/**********************************************************************************/
	public void logoutOptionClick(){
		 logoutOption.click();
	}

}
