package Pages;

import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	
	
	static WebDriver driver;
	static WebDriverWait wait;
	
	public Page(WebDriver driver){
		this.driver=driver;
		this.wait=new WebDriverWait(this.driver,30);
	
	}
	
	public abstract String getpageurl();
	public abstract String getPageTitle(); 
	public abstract String getPageHeader(By locator);
	public abstract WebElement getElement(By locator);
	public abstract boolean getLogo(By locator);
	public abstract WebElement waitForElementPresent(By locator);
	public abstract void waitForPageTitle(String title);
	public abstract List<WebElement> getElements(By locator);

	
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		}catch(Exception e) {
			e.getStackTrace();
			return null;
		}
	}

}
