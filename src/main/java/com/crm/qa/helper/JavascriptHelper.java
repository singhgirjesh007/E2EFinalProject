package com.crm.qa.helper;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.crm.qa.base.TestBase;



public class JavascriptHelper extends TestBase {

	
	//public WebDriver driver;
	/*public JavascriptHelper(WebDriver driver)  {
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}*/
	//No need to define constructor as driver definition coming from test base

	public Object executeJavascript(String script) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object obj = js.executeScript(script);
		return obj;

	}

	public Object executeJavascript(String script, Object... args) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object obj = js.executeScript(script, args);
		return obj;
		// or return js.executeScript(script,args);
	}

	public void scrollToElement(WebElement element) {
		executeJavascript("windows.ScrollTo(argumeants[0],arguments[1])", element.getLocation().x,
				element.getLocation().y);
		// return element;
	}

	public void clickToElement(WebElement element) {
		scrollToElement(element);
		element.click();
		// Object obj=executeJavascript("arguments[0].click();",
		// scrollToElement(element));

	}

	public void scrollIntoView(WebElement element) {
		executeJavascript("arguments[0].scrollIntoView()", element);

	}

	public void scrollIntoViewandClick(WebElement element) {
		scrollIntoView(element);
		element.click();

	}

	public void scrollDownVertically() {
		executeJavascript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public void scrollUpVertically() {
		executeJavascript("window.scrollTo(0,-document.body.scrollHeight)");
	}
	
	public void scrollDownByPixel(int pixel) {
		executeJavascript("window.ScrollBy(0,"+pixel+")");
	}
	
	public void scrollUpByPixel(int pixel) {
		executeJavascript("window.ScrollBy(0,-"+pixel+")");
	}
	
	public void zoomInBypercentage(int zoomPercent) {
		executeJavascript("document.body.style.zoom='"+zoomPercent+"'%");
	}
	
	public void clickElement(WebElement element) {
		executeJavascript("arguments[0].click();",element);
	}
	
	
	
	
}
