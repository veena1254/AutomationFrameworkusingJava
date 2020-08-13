package com.flipkart;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.flipkart.base.TestBase_new;
import com.flipkart.pages.GoToCartPage;
import com.flipkart.pages.LoginPage;
import com.flipkart.util.Util;
public class GoToCartPageTest extends TestBase_new {
	public GoToCartPageTest(){
		super();
	}
	GoToCartPage gotocartPage;
	LoginPage loginPage ;
	Util util;
	
	/**********************************************************************************/
	// Method Name: setup
	// purpose 	  : Initialize page objects 
	// 
	/**********************************************************************************/
	@BeforeClass
	public void setup() throws InterruptedException{ 
		gotocartPage = new GoToCartPage();
		util = new Util();
		loginPage = new LoginPage();
	}

	/**********************************************************************************/
	// Method Name: verifyProductDataInCartTest
	// purpose 	  : Compare the product data appeared in item selected in search list with
	//				product details displayed on gotocart page.
	//				a. Name
	//				b. price
	//			    Verify camera list between two pages. 
	// Anchor	  : GoToCartPageTest_001
	/**********************************************************************************/
	@Test
	public void verifyProductDataInCartTest() throws Exception{
		Util.implicitWait();
		try {
				boolean productCmpStatus = gotocartPage.verifyProductDataInCart();
				Assert.assertTrue(productCmpStatus, "The productCmpStatus is not successfull.");
		}catch(NoSuchElementException e) {
				Assert.assertTrue(false, "The productCmpStatus is not successfull.");
		}
			
	}
	
	/**********************************************************************************/
	// Method Name: verifygoToCartPageDetailsTest
	// purpose 	  : Verify the selections on goTOCartPage.
	// Anchor	  : GoToCartPageTest_002
	/**********************************************************************************/
	@Test
	public void verifygoToCartPageDetailsTest() throws Exception{
		//Thread.sleep(3000);
		Util.implicitWait();
		System.out.println("verifygoToCartPageDetailsTest-start");
		try {
				boolean loginDisplayStatus=gotocartPage.placeOrder();
				Assert.assertTrue(loginDisplayStatus, "The check out details is not displayed.");
		}catch(NoSuchElementException e) {
				Assert.assertTrue(false, "The check out details is not displayed.");
		}
			
	}
	
	/**********************************************************************************/
	// Method Name: checkOutDetailsTest
	// purpose 	  : Verify the below details on checkout.
	//				a.Delivery option
	//				b.OrderSummary
	//				c.PaymentSelection
	//				d.Price Summary.
	// Anchor	  : GoToCartPageTest_003
	/**********************************************************************************/
	@Test
	public void checkOutDetailsTest() throws Exception{
		Util.implicitWait();
		System.out.println("checkOutDetails-start");
		try {
				gotocartPage.deliveryDetails();
				gotocartPage.orderSummeryContinue();
				gotocartPage.paymentSelection();
				Util.implicitWait();
				boolean priceDisplayStatus=gotocartPage.verifyPriceSummarydata();
				Assert.assertTrue(priceDisplayStatus, "The check out page details is not displayed.");
		}catch(NoSuchElementException e) {
				Assert.assertTrue(false, "The check out details is not displayed.");
		}
			
	}
	
	/**********************************************************************************/
	// Method Name: logOutTest
	// purpose 	  : Verify logout performed
	// Anchor	  : GoToCartPageTest_004
	/**********************************************************************************/	
	@Test
	public void logOutTest() throws Exception{
		try {
		driver.navigate().back();
		loginPage.userAccountDropdownClick();
		loginPage.logoutOptionClick();
		boolean loginButtonStatus=loginPage.loginOptionDisplayStatus();
		Assert.assertTrue(loginButtonStatus, "Login popup is not displayed.");
		}	catch(NoSuchElementException e) {
			Assert.assertTrue(false, "Login popup is not displayed.");
	}	
	}
	
}
