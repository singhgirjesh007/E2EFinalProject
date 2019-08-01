package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.helper.ResourceHelper;
import com.crm.qa.helper.WaitHelper;
import com.crm.qa.utilis.TestUtils;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase() {
		try {
			prop = new Properties();

			FileInputStream fin = new FileInputStream(ResourceHelper.resourceHelper("\\src\\main\\java\\com\\crm\\qa\\config\\config.properties"));
			prop.load(fin);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public static void initiliazeDriver() {
		
		String browserInUse = prop.getProperty("browser");
		if(browserInUse.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\Automation\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if (browserInUse.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Autmation\\geckodriver-v0.19.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserInUse.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "D:\\Autmation\\IEDriverServer_x64_2.48.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		WaitHelper wait=new WaitHelper(driver);
		
		wait.setPageLoadWait(TestUtils.PAGE_TIMEOUT, TimeUnit.SECONDS);
		wait.setImplicitWait(TestUtils.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
}
