package com.facebook.qe.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.facebook.qe.base.BasePage;
import com.facebook.qe.utility.WebElements;


public class LoginPage extends BasePage{
	WebElements webElement;

	public LoginPage(WebDriver driver) {
		super(driver);
		webElement = new WebElements(driver);
	}
	
	//Page locator
	By headerTitle = By.id("pageTitle");
	private By username = By.id("email");
	private By password = By.id("pass");
	By loginBtn = By.name("login");
	
	public Boolean loginHeaderTitle() {
		webElement.getPageTitle();
		return true;
	}
	
	public HomePage doLogin(String user, String pwd) {
		webElement.sendKeys(username, user);
		webElement.sendKeys(password, pwd);
		webElement.click(loginBtn);
		return new HomePage(driver);
	}
}
