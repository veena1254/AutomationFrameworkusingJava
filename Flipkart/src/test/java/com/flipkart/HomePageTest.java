package com.flipkart;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.flipkart.base.TestBase_new;
import com.flipkart.pages.HomePage;
import com.flipkart.util.Util;

public class HomePageTest extends TestBase_new {
	public HomePageTest(){
		super();
	}
	HomePage homepage; 
	Util util;
	/**********************************************************************************/
	// Method Name: setup
	// purpose 	  : Initialize page objects 
	// 
	/**********************************************************************************/
	@BeforeClass
	public void setup() throws InterruptedException{ 
		homepage = new HomePage();
		util = new Util();
	}
	
	/**********************************************************************************/
	// Method Name: searchCameraListTest
	// purpose 	  : Enter the Camera in the search option.
	//			    Verify camera list appears on the display. 
	// Anchor	  : HomePageTest_001
	/**********************************************************************************/
	@Test
	public void searchCameraListTest() throws Exception{
		try {
			System.out.println("searchlist camera-start");
			util.pageLoadWait();
			Boolean cameraListDisplayStatus=homepage.searchCameraItems();
			Assert.assertTrue(cameraListDisplayStatus, "The Search Camara List is not displayed.");
		}catch(NoSuchElementException e){
			Assert.assertTrue(false, "The Search Camara List is not displayed");
			
		}	
	}
	
	/**********************************************************************************/
	// Method Name: productSelectionToAddToCartTest
	// purpose 	  : Choose/select the Camera and 
	//			    Verify AddtoCart button display and enable option appears for 
	//				the product on display. 
	// Anchor	  : HomePageTest_002
	/**********************************************************************************/
	@Test
	public void productSelectionToAddToCartTest() throws Exception{
		System.out.println("productListtoAddToCart-start");
		try {
			boolean selectionStatus=homepage.productSelection();
			Assert.assertTrue(selectionStatus, "The Product details in AddTOCart is not displayed.");
		}catch(NoSuchElementException e) {
			Assert.assertTrue(false, "The Product details in AddTOCart is not displayed.");
		}
			
	}
	
	/**********************************************************************************/
	// Method Name: goToCartPageDisplayTest
	// purpose 	  : Choose/select AddtoCart enable and 
	//			    Verify Goto cart page is displayed. 
	// Anchor	  : HomePageTest_003
	/**********************************************************************************/
	@Test
	public void goToCartPageDisplayTest() throws Exception{
		System.out.println("goToCartPageDisplayTest-start");
		util.pageLoadWait();
		try {

			boolean goToCartPageDisplay=homepage.addtocartSelection();
			Assert.assertTrue(goToCartPageDisplay, "The Goto cart page is not displayed.");
		}catch(NoSuchElementException e) {
			boolean goToCartPageDisplay=homepage.addtocartSelection();
			Assert.assertTrue(goToCartPageDisplay, "The Gotocart is not being displayed.");
		}
		
	}
	
}
