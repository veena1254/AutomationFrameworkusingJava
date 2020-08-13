package com.flipkart.pages;

import com.flipkart.pages.LoginPage;
import com.flipkart.util.Util;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.TestBase_new;

public class HomePage extends TestBase_new{
	LoginPage loginPage;
	/*=========================================================================*/
	/*=====HomePage - Search Web Elements======================================*/
	/*=========================================================================*/
	
	@FindBy(xpath ="//input[@class='LM6RPg']")
	WebElement searchItem;
	
	@FindBys(@FindBy(xpath ="//div[@class='_1UoZlX']/a"))
	List<WebElement> productAvailablelist;
	
	@FindBy(xpath ="//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")
	WebElement addtoCart;
	
	@FindBy(xpath ="//body/div[@id='container']/div/div/div/div/div[3]/div//*[local-name()='svg']")
	WebElement customerAccountDropdown;
	
	@FindBys(@FindBy(xpath ="//div[@class='_3wU53n']"))
	List<WebElement> availableCameralistNames;
	
	@FindBys(@FindBy(xpath ="//div[@class='_1vC4OE _2rQ-NK']"))
	List<WebElement> availableCameralistPrice;
	
	
	/*============Object Declarations ===============================================*/
	
	/*Initialize the PageObjects*/
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public static List<String> productList=new ArrayList<String>();
	public static String testname;
	/*===============================================================================*/
	
	/**********************************************************************************/
	// Method Name: searchCameraItems
	// purpose 	  : Enter camera and Search Camera on search box. 
	// Anchor	  : HomePageCode_001
	/**********************************************************************************/
	public boolean searchCameraItems() throws Exception{
		System.out.println("Search Camera: ");
		searchItem.click();
		searchItem.sendKeys("Digital Camera");
		searchItem.sendKeys(Keys.ENTER);
		 Thread.sleep(4000);
		 System.out.println("Search Camera done ");
		return cameraListDisplayStatus();
			 
	}
	
	/**********************************************************************************/
	// Method Name: productSelection
	// purpose 	  : Return status of production selection 
	// Anchor	  : HomePageCode_002
	/**********************************************************************************/	
	public boolean productSelection() throws Exception{
		Util.implicitWait();
		boolean status=false;
		if(productAvailablelist.size()>2) {
		verifyProductData();
		productAvailablelist.get(3).click(); 
		switch2Tab();
			if( addtoCart.isDisplayed() && addtoCart.isEnabled())
			{
			 return status= true;
			}
		}
		return status;
	}
	
	/**********************************************************************************/
	// Method Name: switch2Tab
	// purpose 	  : Switch to new tab
	// Anchor	  : HomePageCode_003
	/**********************************************************************************/
	public void switch2Tab() throws Exception{
		Util.implicitWait();
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
	}

	/**********************************************************************************/
	// Method Name: addtocartSelection
	// purpose 	  : Select addtocart and return the gotocart title status
	// Anchor	  : HomePageCode_004
	/**********************************************************************************/
	public boolean addtocartSelection() {
		Util.implicitWait();
		addtocartButtonClick();
		return verifygotocartTitle();
	}
	
	/**********************************************************************************/
	// Method Name: verifygotocartTitle
	// purpose 	  : return gotocart title compare result.
	// Anchor	  : HomePageCode_005
	/**********************************************************************************/
	public boolean verifygotocartTitle(){
		boolean flag=false;
		Util.implicitWait();
		String titleName=driver.getCurrentUrl();
		if (titleName.contains("GoToCart")) {
			System.out.println("Goto cart page is displayed");
			flag=true;
		}
		return flag;
	}
	
	/**********************************************************************************/
	// Method Name: addtocartButtonClick
	// purpose 	  : click action on addtocart.
	// Anchor	  : HomePageCode_006
	/**********************************************************************************/
	public void addtocartButtonClick() {
		addtoCart.click();
	}
	
	/**********************************************************************************/
	// Method Name: verifyProductData
	// purpose 	  : add the cameralist details to the List.
	// Anchor	  : HomePageCode_007
	/**********************************************************************************/
	public void verifyProductData() {
		
		productList.add(availableCameralistNames.get(3).getText());
		productList.add(availableCameralistPrice.get(3).getText());
	}
	
	/**********************************************************************************/
	// Method Name: getProductListData
	// purpose 	  : get productlist elements.
	// Anchor	  : HomePageCode_008
	/**********************************************************************************/
	public List<String> getProductListData() {
		return productList;
	}
	
	/**********************************************************************************/
	// Method Name: cameraListDisplayStatus
	// purpose 	  : Return cameralist status appeared on display
	// Anchor	  : HomePageCode_009
	/**********************************************************************************/
	public boolean cameraListDisplayStatus() {
		Boolean cameraListDetailsFlag=false;
		if(!availableCameralistNames.isEmpty())
		{
			cameraListDetailsFlag = true;
		}
		return cameraListDetailsFlag;
	}
	
}
