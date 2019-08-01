package com.crm.qa.testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
	
		initiliazeDriver();
		loginPage= new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void validateHomePageTitleTest() {
		
		String title =homePage.verfiyHomePageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "CRMPRO" ,"Home page title not matched");
	}
	
	@Test(priority =2)
	public void validateContactLinkClick() {
			driver.switchTo().frame("mainpanel");
			homePage.clickOnContactsLink();
	}
	
	@Test
	public void validateDealsLinkClick() {
		System.out.println("On deals link");
		driver.switchTo().frame("mainpanel");
		homePage.clickOnDealsLink();
	}
		
	@Test
	public void validateNewContactLinkClick() {
		driver.switchTo().frame("mainpanel");
		homePage.clickOnNewContact();
		
		}

	

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver=null;
	}
}
