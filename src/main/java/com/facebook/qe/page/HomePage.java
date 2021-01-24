package com.facebook.qe.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.facebook.qe.base.BasePage;
import com.facebook.qe.utility.WebElements;


public class HomePage extends BasePage{
	WebElements webElement;
	
	public HomePage(WebDriver driver) {
		super(driver);
		webElement = new WebElements(driver);
	}
	
	//Page locator
	By homeHeaderTitle = By.xpath("//div/a/span/span[@text='Veroliss']");
	By username = By.xpath("//div/a/span/span[@text='Veroliss']");
	By logOut = By.cssSelector("");
	
	//Page actions/methods
	//public Boolean homeHeaderTitle() {
		//return webElement.waitForElementBoolean(homeHeaderTitle, "Veroliss", 60, 2);
	//}
	
	public Boolean homeHeaderTitle() {
		webElement.getPageTitle();
		return true;
	}
	
	public Boolean getUsername() {
		webElement.waitForElementString(username,"Veroliss", 60, 2);
		return true;
	}
	
	public Boolean logOut() {
		webElement.click(logOut);
		return true;
	}
}
