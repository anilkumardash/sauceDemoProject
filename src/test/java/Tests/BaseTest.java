package Tests;

import java.io.File;



import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.BasePage;
import Pages.Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	
	public static Properties prop;
	public static FileInputStream fi;
	public Page page;
	
	
	public BaseTest() {
		
		try {
			prop=new Properties();
			fi=new FileInputStream("D:\\Anil\\JAVA_Selenium\\Selenium_Workspace\\MyProjectSauceDemo\\src\\main\\java\\Config\\config.properties");
			prop.load(fi);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	@Parameters({"browser"})
	@BeforeMethod
	public void setUp(String browser) {
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(browser.equals("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else {
			System.out.println("there is no browser available");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		page = new BasePage(driver);
		
		
	}
		
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		driver.quit();
	}
	

}
