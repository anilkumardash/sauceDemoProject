package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutPage extends BasePage {
	
	private By logout_curenturl=By.xpath("//a[text()='Logout']");
	

	public LogoutPage(WebDriver driver) {
		super(driver);
		
	}
	public String getLogoutCurenturl() {
		return getpageurl();
	}
	


}
