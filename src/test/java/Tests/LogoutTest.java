package Tests;
import Pages.HomePage;

import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.LogoutPage;



public class LogoutTest extends BaseTest{
	LoginPage login;
	HomePage home;
	LogoutPage logout;

	
	@Test(priority=1)
	public void validateLogout() throws InterruptedException {
		home=page.getInstance(LoginPage.class).doLogin(prop.getProperty("username"), prop.getProperty("password"));
		logout= home.clickLogout();
		String logoutURL=logout.getLogoutCurenturl();
		Thread.sleep(2000);
		Assert.assertEquals(logoutURL, "https://www.saucedemo.com/");
	}

}
