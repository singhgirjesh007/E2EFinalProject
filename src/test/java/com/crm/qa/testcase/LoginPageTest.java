package com.crm.qa.testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	

	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setup() {
		initiliazeDriver();
		loginpage=new LoginPage();
	}
	
	@Test
	public void loginPageTitleTest() {
		String str=loginpage.getTitle();
		System.out.println(str);
		System.out.println("excute test case");
		//Assert.assertEquals(str,"CRMPRO  - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test
	public void crmLogoImageTest() {
		boolean flag = loginpage.validateCRMImage();
		Assert.assertTrue(flag);
		System.out.println("validated crm log test");
	}
	
	@Test
	public void loginTest() throws IOException {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDonwn() {
		driver.quit();
	}

}
