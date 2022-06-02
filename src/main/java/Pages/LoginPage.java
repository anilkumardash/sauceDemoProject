package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
	
	private By username=By.xpath("//input[@id='user-name']");
	private By password =By.xpath("//input[@id='password']");
	private By login_btn =By.xpath("//input[@id='login-button']");
	private By logo=By.xpath("//div[@class='login_logo']");
	private By invalid_text=By.xpath("//h3[text()='Epic sadface: Username and password do not match any user in this service']");
	

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

	public WebElement getUsername() {
		return getElement(username);
	}


	public WebElement getPassword() {
		return getElement(password);
	}

	public WebElement getLogin_btn() {
		return getElement(login_btn);
	}
	public String getloginTitle() {
		return getPageTitle();
	}

	public boolean getLogo() {
		return getLogo(logo);
	}
	public String getInvalidText() {
		return getElement(invalid_text).getText();
		
	}
	
	public HomePage doLogin(String un,String pw) {
		getUsername().sendKeys(un);
		getPassword().sendKeys(pw);
		getLogin_btn().click();
		return getInstance(HomePage.class);
		
	}
	public LoginPage doLoginWithInvalidData(String iun,String ipw) throws InterruptedException {
		getUsername().sendKeys(iun);
		getPassword().sendKeys(ipw);
		getLogin_btn().click();
//		return null;
		return getInstance(LoginPage.class);
		
		
	}

}
