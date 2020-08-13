package com.flipkart.pages;

import com.flipkart.pages.HomePage;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;


import com.flipkart.base.TestBase_new;

public class GoToCartPage extends TestBase_new {

	HomePage  homepage = new HomePage();
	
	/*=============================================*/
	/*=====GoToCart page - Search Web Elements=====*/
	/*=============================================*/
	
	@FindBy(xpath ="//button[@class='_2AkmmA iwYpF9 _7UHT_c']")
	WebElement placeOrderButton;
	
	@FindBy(xpath ="//div[@class='_1QbRjw']")
	WebElement checkoutLoginDetails;
	
	@FindBy(xpath="//button[contains(text(),'Deliver Here')]")
	WebElement deliveryHereButton;
	
	@FindBy(xpath="//button[contains(text(),'CONTINUE')]")
	WebElement continueButton;
	
	@FindBy(xpath="//label[5]/div[1]")
	WebElement codRadioButton;
	
	@FindBy(xpath="//input[@name='captcha']")
	WebElement enterCaptcha;
	
	@FindBy(xpath="//button[@class='_2AkmmA _23FrK1 _7UHT_c']")
	WebElement confirmOrderButton;
	
	@FindBy(xpath="//div[@class='hJYgKM' ]/div[@xpath='1']")
	WebElement getPriceText;

	@FindBys(@FindBy(xpath ="//div[@class='hJYgKM' ]"))
	List<WebElement> getPriceListDetails;
	
	@FindBy(xpath ="//body/div[@id='container']/div/div/div/div/div[3]/div//*[local-name()='svg']")
	WebElement userAccountDropdown;
	
	@FindBys(@FindBy(xpath ="//a[@class='_325-ji _3ROAwx']"))
	List<WebElement> getProductTitleInCart;
	
	@FindBys(@FindBy(xpath ="//span[@class='pMSy0p XU9vZa']"))
	List<WebElement> getProductPriceInCart;
	

	
	@FindBy(xpath="//a[contains(.,'Logout')]")
	WebElement logoutOption;
	
	/*============Object Declarations ===============================================*/
	/*Initialize the PageObjects*/
	public GoToCartPage(){
		PageFactory.initElements(driver, this);
	}
	/*================================================================================*/
	
	
	/**********************************************************************************/
	// Method Name: placeOrder
	// purpose 	  : Return checkoutlogin status after selection of PlaceOrder. 
	// Anchor	  : GoToCartPageCode_001
	/**********************************************************************************/
	public boolean placeOrder(){
		placeOrderButton.click();
	    return checkoutLoginDetails();
	}
	
	/**********************************************************************************/
	// Method Name: checkoutLoginDetails
	// purpose 	  : Return checkoutlogin status 
	// Anchor	  : GoToCartPageCode_002
	/**********************************************************************************/
	public boolean checkoutLoginDetails(){
		return checkoutLoginDetails.isDisplayed();
	}
	
	/**********************************************************************************/
	// Method Name: deliveryDetails
	// purpose 	  : Action click on Delivery option 
	// Anchor	  : GoToCartPageCode_003
	/**********************************************************************************/
	public void deliveryDetails(){
		deliveryHereButton.click();
	}

	/**********************************************************************************/
	// Method Name: orderSummeryContinue
	// purpose 	  : Action click on orderSummery option 
	// Anchor	  : GoToCartPageCode_004
	/**********************************************************************************/
	public void orderSummeryContinue(){
		continueButton.click();
	}

	/**********************************************************************************/
	// Method Name: paymentSelection
	// purpose 	  : Action click on paymentSelection option 
	// Anchor	  : GoToCartPageCode_005
	/**********************************************************************************/
	public void paymentSelection() throws InterruptedException{
		Thread.sleep(5000);
		codRadioButton.click();
	}
	
	/**********************************************************************************/
	// Method Name: confirmOrderSelection
	// purpose 	  : Action click on confirmOrder option 
	// Anchor	  : GoToCartPageCode_006
	/**********************************************************************************/
	public void confirmOrderSelection(){
	confirmOrderButton.click();
	}
	
	/**********************************************************************************/
	// Method Name: verifyPriceSummarydata
	// purpose 	  : return PriceSummary report details status.
	// Anchor	  : GoToCartPageCode_007
	/**********************************************************************************/
	public boolean verifyPriceSummarydata(){
		boolean pricelistStatus = false;
		for(WebElement priceSummaryList : getPriceListDetails) {
			if(priceSummaryList.getText().contains("Price")){
				System.out.println("Price success");
				pricelistStatus = true;
			}
			else if(priceSummaryList.getText().contains("Delivery"))
			{
				System.out.println("Delivery success");
				pricelistStatus = true;
			}
			else if(priceSummaryList.getText().contains("Amount"))
			{
				System.out.println("Amount success");
				pricelistStatus = true;
			}
			else {
				System.out.println("List has few more items");
				pricelistStatus = false;
			}
			
		}
		System.out.println("User is not performing order placemant due to payment option required");
		return pricelistStatus;
		}
	
	/**********************************************************************************/
	// Method Name: verifyProductDataInCart
	// purpose 	  : Compare the product data appeared in item selected in search list with
	//				product details displayed on gotocart page.
	//				a. Name
	//				b. price
	//			    Return camera list compare status between two pages.
	// Anchor	  : GoToCartPageCode_008
	/**********************************************************************************/
	public boolean verifyProductDataInCart(){
		System.out.println("verifyProductDataInCart");
		List<String> productlist = homepage.getProductListData();
		boolean productCmpStatus = false; 
		for(int j=0; j<= getProductTitleInCart.size();j++ )
		{
			if(productlist.get(0).equalsIgnoreCase(getProductTitleInCart.get(j).getText()))
			{
				if(productlist.get(1).equalsIgnoreCase(getProductPriceInCart.get(j).getText()))
				{
					productCmpStatus = true;
					return productCmpStatus;
				}
			}	
		}
		return productCmpStatus;
	
	}
}
