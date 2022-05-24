package testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utilities.ReadFromConfig;

public class BaseClass {
	
	public Logger logger;

	public ReadFromConfig rd=new ReadFromConfig();
	public WebDriver driver;
	public String baseurl=rd.baseUrl();
	public String username=rd.userName();
	public String password=rd.passWord();


	@Parameters("browser")
	@BeforeClass
	public void launchUrl(String br) {
		// this is base class
		//added second comment
		logger=Logger.getLogger("Automation Project");
		PropertyConfigurator.configure(System.getProperty("user.dir")+"//Log4j//log4j.properties");
	
		if(br.equals("chrome")) {

		System.setProperty("webdriver.chrome.driver", rd.chromePath());
		driver=new ChromeDriver();
		logger.info("launched chrome browser");
		
		}else if(br.equals("firefox")) {
			System.setProperty("webdriver.gekco.driver", rd.firefoxPath());
			logger.info("launched firefox browser");
		}
		driver.manage().window().maximize();
		driver.get(baseurl);
		logger.info("entered url");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		
	}

	@AfterClass
	public void tearDown() {
		driver.close();
		logger.info("browser closed");

	}

	public void screenShot(WebDriver driver, String testname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File(System.getProperty("user.dir")+"//Screenshots//"+testname+".jpg");
		FileUtils.copyFile(source, destination);

	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}catch
			(NoAlertPresentException e){
			return false;
		}
	}


}
