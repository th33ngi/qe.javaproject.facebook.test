package com.facebook.qe.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.facebook.qe.page.Page;


public class BaseTest {
	public static WebDriver driver;
	public Properties prop;
	public Page page;
	BasePage basePage;
	
	//set up properties, web driver and instance of page class,
	//before starting the test suite.
	@BeforeSuite
	public void setUp() {
		basePage = new BasePage(driver);
		prop = basePage.initProperties();
		driver = basePage.initDriver(prop);
		page = new Page(driver);
	}
	
	@BeforeClass
	public void startUp() {
		basePage = new BasePage(driver);
		page = new Page(driver);
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

}
