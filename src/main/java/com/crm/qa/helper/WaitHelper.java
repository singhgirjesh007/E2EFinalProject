package com.crm.qa.helper;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper{
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	public WaitHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public void setImplicitWait(long timeOut,TimeUnit unit) {
		driver.manage().timeouts().implicitlyWait(timeOut, unit);
	}
	
	public void setPageLoadWait(long timeOut,TimeUnit unit) {
		driver.manage().timeouts().pageLoadTimeout(timeOut, unit);
	}
	
	
	private WebDriverWait getWait(long timeOutInSeconds, long pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds );
		wait.pollingEvery(Duration.ofMillis(pollingTime));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}
	
	
	
	public void waitForElementVisible(WebElement element,long timeOutInSeconds,long pollingTime) {
		
		WebDriverWait wait= getWait(timeOutInSeconds,pollingTime);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void waitForElementClickable(WebElement element,long timeOutInSeconds) {
		//log.info("waiting for "+element.toString()+" to be clickable");
		wait= new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		//log.info("element clickable");
	}
	
	public boolean waitForElementInvisible(WebElement element,long timeOutInSeconds) {
		//log.info("waiting for "+element.toString()+" to be Invisible");
		WebDriverWait wait= new WebDriverWait(driver, timeOutInSeconds);
		boolean status =wait.until(ExpectedConditions.invisibilityOf(element));
		//log.info("Element invisible");
		return status;
	}
	
	public void waitForFrameVisibility(WebElement frameLocator,long timeOutInSeconds) {
		//log.info("waiting for "+frameLocator.toString()+" frame avaialbility");
		WebDriverWait wait= new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
		//log.info("Switch to available frame");
	}
	long timout;
	
	private Wait<WebDriver> getFluentWait(long timeOut,long pollingTime) {
		
	Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(timeOut))
			.pollingEvery(Duration.ofMillis(pollingTime))
			.ignoring(NoSuchElementException.class);
		
	return fWait;
	}
	
	public WebElement setFluentWait(WebElement element,long timeOut,long pollingTime) {
		Wait<WebDriver> fWait = getFluentWait(timeOut,pollingTime);
		WebElement element1 =fWait.until(ExpectedConditions.visibilityOf(element));
		return element1;	
	}
	

}
