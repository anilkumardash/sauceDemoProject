package Tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;


public class LoginPageTest extends BaseTest{
	
	HomePage home;
	LoginPage login;
	
	
	@Test(priority=1)
	public void validateApplicationLogo() {
		boolean logo =page.getInstance(LoginPage.class).getLogo();
		Assert.assertTrue(logo);
		

	}
	@Test(priority=2)
	public void validateLoginPageTitle() {
		String title =page.getInstance(LoginPage.class).getloginTitle();
		System.out.println(title);
		Assert.assertEquals(title,"Swag Labs");

		
	}
//	
	@Test(priority=3)
	public void validateLogin() {
		home=page.getInstance(LoginPage.class).doLogin(prop.getProperty("username"), prop.getProperty("password"));
		String homeHeader =home.getHomepage_header();
		System.out.println(homeHeader);
		Assert.assertEquals(homeHeader, "PRODUCTS");
	}
//	
	@Test(priority=4)
	public void validateLoginWithInvalidCredential() throws InterruptedException {
		login =page.getInstance(LoginPage.class).doLoginWithInvalidData(prop.getProperty("iusername"), prop.getProperty("ipassword"));
		String msg =login.getInvalidText();
		System.out.println(msg);
		Assert.assertEquals(msg, "Epic sadface: Username and password do not match any user in this service");
		
	}
	
	

}
