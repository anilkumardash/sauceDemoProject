package Tests;
import Pages.HomePage;

import Pages.LoginPage;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.AddToCartPage;
import Pages.BasePage;




public class AddToCartTest extends BaseTest {
	
	LoginPage login;
	HomePage home;
	AddToCartPage addcart;
	String sheetname="checkoutdetail";
	
	

	@DataProvider
	public Object[] testdata(){
		Object data[]=BasePage.getTestData(sheetname);
		return data;
	}
	
	@Test(priority=1,dataProvider="testdata")
	public void validateAddTocart(String firtname,String lastName,String zip) throws InterruptedException{
		home=page.getInstance(LoginPage.class).doLogin(prop.getProperty("username"), prop.getProperty("password"));
		addcart =home.getClickCart();
		
		addcart.getCheckOut_button().click();
		addcart.enterCheckoutData(firtname,lastName,zip);
		Thread.sleep(30000);
//		Assert.assertEquals(confirm_msg,"THANK YOU FOR YOUR ORDER");
//		System.out.println("Order product successfully");
	
	}
		
	
		
		
	
	

}
