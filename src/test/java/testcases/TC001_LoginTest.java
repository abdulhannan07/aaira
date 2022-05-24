package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class TC001_LoginTest extends BaseClass {
	
	
	@Test
	public void TC001_Login() throws IOException {
		LoginPage lp=new LoginPage(driver);
		lp.user(username);
		logger.info("entered username");
		lp.passWord(password);
		logger.info("entered password");
		lp.logIn();
		logger.info("clicked on login button");
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("test case passed");
			System.out.println("test case passed");
		}else {
			System.out.println("test case failed");
			logger.info("test case failed");
			screenShot(driver,"TC001_LoginTest");
			Assert.assertTrue(false);
		}
		
	}

}
