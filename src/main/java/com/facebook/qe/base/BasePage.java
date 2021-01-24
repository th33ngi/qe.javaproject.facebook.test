package com.facebook.qe.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.facebook.qe.listener.WebEventListener;
import com.facebook.qe.page.Page;
import com.facebook.qe.utility.OptionsManager;


public class BasePage extends Page{
	public Properties prop;
	public static WebDriver driver;
	public OptionsManager optionsManager;
	public static EventFiringWebDriver eventDriver;
	public static WebEventListener eventListener;
	
	//a base page constructor is created
	public BasePage(WebDriver driver) {
		super(driver);
	}
	
	//start the web driver
	public WebDriver initDriver (Properties prop) {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			optionsManager = new OptionsManager(prop);
			System.setProperty("webdriver.chrome.driver","/Users/Th33NGi/Documents/chrome/chromedriver.exe");
			driver = new ChromeDriver(optionsManager.getChromeOptions());
		}else if(browserName.equals("firefox")) {
			optionsManager = new OptionsManager(prop);
			System.setProperty("webdriver.gecko.driver","/Users/Th33NGi/Documents/firefox/geckodriver.exe");
			driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
		}
		
		eventDriver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		eventDriver.register(eventListener);
		driver = eventDriver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
	//get properties from properties file
	public Properties initProperties() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("./src/main/java/com/facebook/qe/config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
