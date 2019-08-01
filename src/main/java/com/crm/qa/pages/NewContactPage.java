package com.crm.qa.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class NewContactPage extends TestBase{
	
	public NewContactPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath=".//*[@id='first_name']")
	WebElement fName;
	
	@FindBy(xpath=".//*[@id='surname']")
	WebElement lName;
	
	@FindBy(xpath="//select[@name='type']")
	WebElement billingAddressType;
	
	@FindBy(name="address")
	WebElement addr;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="postcode")
	WebElement zipcode;
	
	@FindBy(name="country")
	WebElement country;
	
	public void createNewContact(String fname,String lname ,String address,String c,String s,String z,String co) {
		
		fName.sendKeys(fname);
		lName.sendKeys(lname);
		Select sel = new Select(billingAddressType);
		sel.selectByVisibleText("Shipping Address");
		addr.sendKeys(address);
		city.sendKeys(c);
		state.sendKeys(s);
		zipcode.sendKeys(z);
		country.sendKeys(co);
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		
		
		
	}
	
	
	
	
	

}
