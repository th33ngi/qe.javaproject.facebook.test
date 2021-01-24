package com.facebook.qe.page;

import org.openqa.selenium.WebDriver;

import com.facebook.qe.base.BasePage;


public class Page {
	public WebDriver driver;
	
	//page class constructor
	public Page(WebDriver driver) {
		this.driver= driver;
	}
	
	//create a method with java and return a new page
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
