package com.crm.qa.testcase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.helper.ExcelHelper;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactPage;
import com.crm.qa.utilis.TestUtils;


public class NewContactPageTest extends TestBase{
	LoginPage lp;
	HomePage hp;
	NewContactPage ncp;
	
	@BeforeMethod
	public void setupNewContactPage() {
		initiliazeDriver();
		lp=new LoginPage();
		hp=new HomePage();
		ncp =new NewContactPage();
		hp= lp.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtils.switchFame();
		ncp =hp.clickOnNewContact();
		
	}
	
	@Test(dataProvider="getData" , enabled=false)
	public void insertNewConacts(String fname,String lname ,String address,String c,String s,String z,String co) {
	
		ncp.createNewContact(fname, lname, address, c, s, z, co);
		
	}
	
	
	@DataProvider
	public Object[][] getData() {
		return ExcelHelper.getExcelData("Contacts");
		
	}
	

	
}
