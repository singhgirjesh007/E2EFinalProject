package com.crm.qa.pages;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.helper.JavascriptHelper;
import com.crm.qa.helper.WaitHelper;
import com.crm.qa.utilis.TestUtils;

public class LoginPage extends TestBase {
	
	WaitHelper wait;
	JavascriptHelper js;
	/**
	 * driver initialization from TestBase
	 * and PageFactory implementation with initElements method
	 * @param driver
	 * @throws IOException
	 */
	public LoginPage() {
		
		PageFactory.initElements(driver,this);
		//this means current class object variabales all webelememt ojects
	}
	
	/**
	 * Page Factory Objects for
	 * Login page
	 */
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='input-group']/div/input")
	WebElement loginbutton;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement logo;
	
	
	/**
	 * Actions on the webelemt
	 * @return 
	 * @throws IOException 
	 * 
	 * 
	 */
	public HomePage login(String un,String pass)   {
		username.sendKeys(un);
		password.sendKeys(pass);
		//wait=new WaitHelper(driver);
		//wait.waitForElementClickable(loginbutton,TestUtils.TEST_TIME_OUT);
		js=new JavascriptHelper();
		js.clickElement(loginbutton);
		//loginbutton.click();
		
		return new HomePage();
		
	}
	
	
	
	public String getTitle() {
		String str =driver.getTitle();
		return str;
	}
	
	public boolean validateCRMImage() {
		return logo.isDisplayed();
	}
	

}
