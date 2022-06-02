package Pages;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Pages.Page;

public class BasePage extends Page {
	
	public static String path="D:\\Anil\\JAVA_Selenium\\Selenium_Workspace\\MyProjectSauceDemo\\src\\main\\java\\TestData\\testdata.xlsx";
	public static Workbook book;
	public static org.apache.poi.ss.usermodel.Sheet sheet;
	
	public BasePage(WebDriver driver) {
		super(driver);
		
	}

	@Override
	public String getpageurl() {
		
		return driver.getCurrentUrl();
	}
	@Override
	public String getPageHeader(By locator) {
		
		return getElement(locator).getText();
	}

	@Override
	public String getPageTitle() {
		
		return driver.getTitle();
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element=null;
		try {
			waitForElementPresent(locator);
			element=driver.findElement(locator);
		}catch(Exception e){
			e.getStackTrace();
			
		}
		return element;
	}

	@Override
	public boolean getLogo(By locator) {
		boolean logo =driver.findElement(locator).isDisplayed();
		return logo;
	}

	@Override
	public WebElement waitForElementPresent(By locator) {
		WebElement element=null;
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}catch(Exception e) {
			e.getStackTrace();
		}
		return element;
		
	}

	@Override
	public void waitForPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<WebElement> getElements(By locator) {
		List<WebElement>elements=null;
		try {
			elements =driver.findElements(locator);
		}catch(Exception e) {
			e.getStackTrace();
		}
		return elements;
	}
	public WebElement mousehoverClick(By locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(locator)).click().build().perform();
		return null;
		
	}


	
	public static Object[][] getTestData(String sheetname){
		FileInputStream file=null;
		try {
			file=new FileInputStream(path);
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			book=WorkbookFactory.create(file);
		}catch(Exception e) {
			e.printStackTrace();
		}
		sheet=book.getSheet(sheetname);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
		}
				
		return data;
		
		
		
	}
}
