package testcases;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelLibrary;

public class TC002_DDT_LoginTest extends BaseClass {
	
	public ExcelLibrary ex=new ExcelLibrary();
	
	@Test(dataProvider="DataWithLogin")
	public  void DDTLoginTest(String us,String pw) throws InterruptedException {
		LoginPage lp1=new LoginPage(driver);
		lp1.user(us);
		logger.info("entered username");
		lp1.passWord(pw);
		logger.info("entered password");
		lp1.logIn();
		logger.info("clicked login");
		Thread.sleep(2000);
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("test case failed");
			Assert.assertTrue(false);
			
		}else {
			lp1.logOut();
			logger.info("entered logout button");
			Assert.assertTrue(true);
			logger.info("test case passed");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}
	}
	
	@DataProvider(name="DataWithLogin")
	public Object [][] loginData(){
		return new Object[][] {
			{ex.excelLibrary("Sheet", 0, 0),ex.excelLibrary("Sheet", 0,1 )},
			{ex.excelLibrary("Sheet", 1, 0),ex.excelLibrary("Sheet", 1,1 )},
			{ex.excelLibrary("Sheet", 2, 0),ex.excelLibrary("Sheet", 2,1 )},
			{ex.excelLibrary("Sheet", 3, 0),ex.excelLibrary("Sheet", 3,1 )},
			{ex.excelLibrary("Sheet", 4, 0),ex.excelLibrary("Sheet", 4,1 )},
			{ex.excelLibrary("Sheet", 5, 0),ex.excelLibrary("Sheet", 5,1 )},
			
			
			
			
		};
		
	

}}
