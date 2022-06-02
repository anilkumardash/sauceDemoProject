package Pages;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCartPage extends BasePage {
	
	private By prodcut_name=By.xpath("//div[text()='Sauce Labs Onesie']");
	private By checkOut_button = By.xpath("//button[@id='checkout']");
	private By firstName=By.xpath("//input[@id='first-name']");
	private By LastName=By.xpath("//input[@id='last-name']");
	private By ZipCode=By.xpath("//input[@id='postal-code']");
	private By continueBtn=By.xpath("//input[@id='continue']");
	private By finishBtn=By.xpath("//button[@id='finish']");
	private By ConfirmMsg=By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']");
	
	public AddToCartPage(WebDriver driver) {
		super(driver);
		
	}


	public String getProdcut_name() {
		return getPageHeader(prodcut_name);
	}


	public WebElement getCheckOut_button() {
		return getElement(checkOut_button);
	}

	public WebElement getFirstName() {
		return getElement(firstName);
	}


	public WebElement getLastName() {
		return getElement(LastName);
	}


	
	public WebElement getZipCode() {
		return getElement(ZipCode);
	}
	

	public WebElement getContinueBtn() {
		return getElement(continueBtn);
	}



	public WebElement getFinishBtn() {
		return getElement(finishBtn);
	}
	public String getConfirmMsg() {
		return getPageHeader(ConfirmMsg);
	}
	
	
	
	public void enterCheckoutData(String FName,String LName,String zip) {
		
		getFirstName().sendKeys(FName);
		getLastName().sendKeys(LName);
		getZipCode().sendKeys(String.valueOf(zip));
	
		
		
	}
	
	
	
	
	
	

	

//	public String checkoutInfo(String path) throws IOException, InterruptedException {
//		
//		File src=new File(path);
//		FileInputStream fis=new FileInputStream(src);
//		XSSFWorkbook wb=new XSSFWorkbook(fis);
//		XSSFSheet sheet=wb.getSheetAt(0);
//		int rowcount=sheet.getLastRowNum();
//		
//		XSSFRow row=null;
//		XSSFCell cell=null;
//		String FirstName=null;
//		String LastName=null;
//		int Zipcode=0;
//		
//		
//		for(int i=1;i<=sheet.getLastRowNum();i++) {
//			row=sheet.getRow(i);
//			for(int j=0;j<row.getLastCellNum();j++) {
//				cell=row.getCell(j);
//				if(j==0)
//				{
//					FirstName=cell.getStringCellValue();
//				}
//				if(j==1)
//				{
//					LastName=cell.getStringCellValue();
//				}
//				if(j==2) 
//				{
//				Zipcode=(int) cell.getNumericCellValue();
////					Zipcode=cell.getStringCellValue();
////					
////					
//				}
//				
//			}
			
//			System.out.println("username is :"+FirstName+"------>"+"password:"+LastName);
//			getFirstName().sendKeys(FirstName);
//			getLastName().sendKeys(LastName);
//			getZipCode().sendKeys(String.valueOf(Zipcode));
//			
//			getContinueBtn().click();
//			getFinishBtn().click();
//			
//			
//		}
//		return getConfirmMsg();
//	}
}