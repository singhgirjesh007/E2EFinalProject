package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//td[contains(text(),'User: Girjesh Singh']")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement newContact;
	
	
	
	public String verfiyHomePageTitle() {
		return driver.getTitle();
		
	}
	
	public ContactPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public NewContactPage clickOnNewContact() {
		
		Actions action=new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContact.click();
		return new NewContactPage();
		
	}
	
	
	
	
	
}
